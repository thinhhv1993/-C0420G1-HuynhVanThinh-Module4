package furama.controller;

import furama.model.HopDong;
import furama.model.KhachHang;
import furama.service.LoaiKhachHangService;
import furama.service.impl.HopDongServiceImpl;
import furama.service.impl.KhachHangServiceImpl;
import furama.service.impl.LoaiKhachHangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KhachHangController {

    @Autowired
    KhachHangServiceImpl khachHangService;

    @Autowired
    LoaiKhachHangServiceImpl loaiKhachHangService;

    @GetMapping("/khachhangs")
    public ModelAndView listKhachHangs(@PageableDefault(value = 5) Pageable pageable){
        Page<KhachHang> khachHangs = khachHangService.findAll(pageable);
        return new ModelAndView("khachhang/list","khachhangs",khachHangs);
    }

    @GetMapping("/view-khachhang/{id}")
    public ModelAndView viewKhachHangs(@PathVariable Long id){
        KhachHang khachHang = khachHangService.findById(id);
        if(khachHang != null) {
            ModelAndView modelAndView = new ModelAndView("/khachhang/view");
            modelAndView.addObject("khachhang", khachHang);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-khachhang")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView =  new ModelAndView("khachhang/create","khachhang",new KhachHang());
        modelAndView.addObject("loaikhachhang", loaiKhachHangService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-khachhang")
    public ModelAndView saveKhachHangs(@ModelAttribute("khachhang") KhachHang khachHang) {
        khachHangService.save(khachHang);
        ModelAndView modelAndView = new ModelAndView("khachhang/create");
        modelAndView.addObject("khachhang", new KhachHang());
        modelAndView.addObject("message", "Them Khach Hang Thanh Cong");
        return modelAndView;
    }

    @GetMapping("/edit-khachhang/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        KhachHang khachHang = khachHangService.findById(id);
        if(khachHang != null) {
            ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
            modelAndView.addObject("loaikhachhang", loaiKhachHangService.findAll());
            modelAndView.addObject("khachhang", khachHang);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-khachhang")
    public ModelAndView updateKhachHang(@ModelAttribute("khachhang") KhachHang khachHang){
        khachHangService.save(khachHang);
        ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
        modelAndView.addObject("khachhang", khachHang);
        modelAndView.addObject("message", "Khach Hang updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-khachhang/{id}")
    public String deleteKhachHang(@PathVariable Long id, RedirectAttributes redirect){
        khachHangService.remove(id);
        redirect.addFlashAttribute("message","Xoa Khach Hang Thanh Cong");
        return "redirect:/khachhangs";
    }
}
