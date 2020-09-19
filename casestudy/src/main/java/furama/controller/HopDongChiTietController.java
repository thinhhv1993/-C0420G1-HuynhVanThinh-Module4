package furama.controller;

import furama.model.HopDong;
import furama.model.HopDongChiTiet;
import furama.service.impl.DichVuDiKemServiceImpl;
import furama.service.impl.HopDongChiTietServiceImpl;
import furama.service.impl.HopDongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HopDongChiTietController {


    @Autowired
    private HopDongServiceImpl hopDongService;

    @Autowired
    private HopDongChiTietServiceImpl hopDongChiTietService;

    @Autowired
    private DichVuDiKemServiceImpl dichVuDiKemService;

    @GetMapping("/create-hopdongchitiet/{id}")
    public ModelAndView showCreateForm(@PageableDefault(value = 10) Pageable pageable, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("hopdongchitiet/create", "hopdongchitiet", new HopDongChiTiet());
        modelAndView.addObject("dichvudikem", dichVuDiKemService.findAll());
        modelAndView.addObject("hopdong", hopDongService.findById(id));
        return modelAndView;
    }

    @PostMapping("/create-hopdongchitiet")
    public ModelAndView saveHopDongs(@Validated @ModelAttribute("hopdongchitiet") HopDongChiTiet hopDongChiTiet, BindingResult bindingResult, @PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("hopdongchitiet/create");
        modelAndView.addObject("dichvudikem", dichVuDiKemService.findAll());
        modelAndView.addObject("hopdong", hopDongChiTiet.getHopDong());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            hopDongChiTietService.save(hopDongChiTiet);
            hopDongService.tongTien(hopDongChiTiet);
            modelAndView.addObject("message", "Them Dich Vu dịch vụ đi kèm Thanh Cong");
        }
        modelAndView.addObject("hopdongchitiet", new HopDongChiTiet());
        return modelAndView;
    }
}
