package furama.controller;


import furama.model.KhachHang;
import furama.model.KhachHangSession;
import furama.service.impl.KhachHangServiceImpl;
import furama.service.impl.LoaiKhachHangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("khachhangsession")
public class KhachHangController {

    KhachHang khachHang = null;
    @Autowired
    KhachHangServiceImpl khachHangService;

    @Autowired
    LoaiKhachHangServiceImpl loaiKhachHangService;

    @ModelAttribute("khachhangsession")
    public KhachHangSession setUpUserForm() {
        return new KhachHangSession();
    }

    @GetMapping("/khachhangs")
    public ModelAndView listKhachHangs(@PageableDefault(value = 10) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
        Page<KhachHang> khachHangs = null;
        if (search.equals("")) {
            khachHangs = khachHangService.findAll(pageable);
        } else {
            khachHangs = khachHangService.findAllByHoTenContaining(search, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("khachhang/list");
        modelAndView.addObject("khachhangs", khachHangs);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/view-khachhang/{id}")
    public ModelAndView viewKhachHangs(@PathVariable Long id) {
        KhachHang khachHang = khachHangService.findById(id);
        if (khachHang != null) {
            ModelAndView modelAndView = new ModelAndView("/khachhang/view");
            modelAndView.addObject("khachhang", khachHang);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-khachhang")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("khachhang/create", "khachhang", new KhachHang());
        modelAndView.addObject("loaikhachhang", loaiKhachHangService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-khachhang")
    public ModelAndView saveKhachHangs(@Validated @ModelAttribute("khachhang") KhachHang khachHang, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("khachhang/create");
        modelAndView.addObject("loaikhachhang", loaiKhachHangService.findAll());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            khachHangService.save(khachHang);
            modelAndView.addObject("message", "Them Khach Hang Thanh Cong");
        }
        modelAndView.addObject("khachhang", new KhachHang());
        return modelAndView;
    }

    @GetMapping("/edit-khachhang/{id}")
    public ModelAndView showEditForm(@PathVariable Long id,@ModelAttribute("khachhangsession")KhachHangSession khachHangSession) {
         khachHang = khachHangService.findById(id);
        if (khachHang != null) {
            ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
            modelAndView.addObject("loaikhachhang", loaiKhachHangService.findAll());
            modelAndView.addObject("khachhang", khachHang);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-khachhang")
    public ModelAndView updateKhachHang(@Validated @ModelAttribute("khachhang") KhachHang khachHang1,
                                        BindingResult bindingResult,@ModelAttribute("khachhangsession")KhachHangSession khachHangSession) {
        ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
        modelAndView.addObject("loaikhachhang", loaiKhachHangService.findAll());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            khachHangSession.addKhachHangSession(khachHang);
            khachHangService.save(khachHang1);
            modelAndView.addObject("khachhang", khachHang1);
            modelAndView.addObject("message", "Khách Hàng cập nhật thành công");
        }
        return modelAndView;
    }

    @PostMapping("/delete-khachhang")
    public String deleteKhachHang(@RequestParam Long id, RedirectAttributes redirect) {
        khachHangService.remove(id);
        redirect.addFlashAttribute("message", "Xoa Khach Hang Thanh Cong");
        return "redirect:/khachhangs";
    }

    @GetMapping("/khachhangsession")
    public ModelAndView saveCart(@ModelAttribute("khachhangsession") KhachHangSession khachHangSession){
        return new ModelAndView("/khachhang/khachhangsession","list",khachHangSession.getKhachHangIntegerMap());
    }
}
