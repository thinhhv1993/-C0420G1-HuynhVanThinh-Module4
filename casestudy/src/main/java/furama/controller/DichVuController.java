package furama.controller;


import furama.model.DichVu;
import furama.model.HopDong;
import furama.service.impl.DichVuServiceImpl;
import furama.service.impl.HopDongServiceImpl;
import furama.service.impl.KieuThueServiceImpl;
import furama.service.impl.LoaiDichVuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DichVuController {

    @Autowired
    DichVuServiceImpl dichVuService;

    @Autowired
    LoaiDichVuServiceImpl loaiDichVuService;

    @Autowired
    KieuThueServiceImpl kieuThueService;

    @Autowired
    HopDongServiceImpl hopDongService;


    @GetMapping("/dichvus")
    public ModelAndView listDichVu(@PageableDefault(value = 10) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
        Page<DichVu> dichVus = null;
        if (search.equals("")) {
            dichVus = dichVuService.findAll(pageable);
        } else {
            dichVus = dichVuService.findAllByTenDichVuContaining(search, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("dichvu/list");
        modelAndView.addObject("dichvus", dichVus);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/view-dichvu/{id}")
    public ModelAndView viewDichVus(@PathVariable Long id) {
        DichVu dichVu = dichVuService.findById(id);
        if (dichVu != null) {
            ModelAndView modelAndView = new ModelAndView("/dichvu/view");
            modelAndView.addObject("dichvu", dichVu);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-dichvu")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("dichvu/create", "dichvu", new DichVu());
        modelAndView.addObject("loaidichvu", loaiDichVuService.findAll());
        modelAndView.addObject("kieuthue", kieuThueService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-dichvu")
    public ModelAndView saveDichVus(@Validated @ModelAttribute("dichvu") DichVu dichVu, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("dichvu/create");
        modelAndView.addObject("loaidichvu", loaiDichVuService.findAll());
        modelAndView.addObject("kieuthue", kieuThueService.findAll());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            dichVuService.save(dichVu);
            modelAndView.addObject("message", "Them Dich Vu Thanh Cong");
        }
        modelAndView.addObject("dichvu", new DichVu());
        return modelAndView;
    }

    @GetMapping("/edit-dichvu/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        DichVu dichVu = dichVuService.findById(id);
        if (dichVu != null) {
            ModelAndView modelAndView = new ModelAndView("/dichvu/edit");
            modelAndView.addObject("loaidichvu", loaiDichVuService.findAll());
            modelAndView.addObject("kieuthue", kieuThueService.findAll());
            modelAndView.addObject("dichvu", dichVu);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-dichvu")
    public ModelAndView updateKhachHang(@Validated @ModelAttribute("dichvu") DichVu dichVu,
                                        BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/dichvu/edit");
        modelAndView.addObject("loaidichvu", loaiDichVuService.findAll());
        modelAndView.addObject("kieuthue", kieuThueService.findAll());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            dichVuService.save(dichVu);
            modelAndView.addObject("dichvu", dichVu);
            modelAndView.addObject("message", "cập nhật thành công");
        }
        return modelAndView;
    }

    @PostMapping("/delete-dichvu")
    public String deleteKhachHang(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        dichVuService.remove(id,redirectAttributes);
        return "redirect:/dichvus";
    }

}
