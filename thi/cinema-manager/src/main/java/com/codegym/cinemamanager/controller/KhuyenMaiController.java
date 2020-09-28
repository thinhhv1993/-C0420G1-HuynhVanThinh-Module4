package com.codegym.cinemamanager.controller;

import com.codegym.cinemamanager.model.KhuyenMai;
import com.codegym.cinemamanager.service.impl.KhuyenMaiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiServiceImpl khuyenMaiService;


    @GetMapping("/")
    public ModelAndView listKhuyenMai(@RequestParam(value = "searchMucGiamGia", defaultValue = "") String searchMucGiamGia,
                                      @RequestParam(value = "searchNgayBatDau", defaultValue = "") String searchNgayBatDau,
                                      @RequestParam(value = "searchNgayKetThuc", defaultValue = "") String searchNgayKetThuc) {
        List<KhuyenMai> khuyenMais = null;
        if (searchMucGiamGia.equals("") && searchNgayBatDau.equals("") && searchNgayKetThuc.equals("")) {
            khuyenMais = khuyenMaiService.fillAll();
        } else {
            khuyenMais = khuyenMaiService.findAllByMucGiamGiaOrThoiGianBatDauOrThoiGianKetThuc(searchMucGiamGia, searchNgayBatDau, searchNgayKetThuc);
        }
        ModelAndView modelAndView = new ModelAndView("khuyenmai/list");
        modelAndView.addObject("khuyenmais", khuyenMais);
        modelAndView.addObject("khuyenmai", new KhuyenMai());
        modelAndView.addObject("searchMucGiamGia", searchMucGiamGia);
        modelAndView.addObject("searchNgayBatDau",searchNgayBatDau);
        modelAndView.addObject("searchNgayKetThuc", searchNgayKetThuc);
        return modelAndView;
    }


    @PostMapping("/create-khuyenmai")
    public String createKhuyenMai(@Validated @ModelAttribute("khuyenmai") KhuyenMai khuyenMai, BindingResult bindingResult, Model model) {
        new KhuyenMai().validate(khuyenMai, bindingResult);
        if (bindingResult.hasErrors()) {
            List<KhuyenMai> khuyenMais = khuyenMaiService.fillAll();
            model.addAttribute("khuyenmais", khuyenMais);
            return "khuyenmai/list";
        }
        khuyenMaiService.save(khuyenMai);
        return "redirect:/";
    }

    @PostMapping("/edit-khuyenmai")
    public String editeKhuyenMai(@Validated @ModelAttribute("Khuyenmai") KhuyenMai khuyenMai, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<KhuyenMai> khuyenMais = khuyenMaiService.fillAll();
            model.addAttribute("khuyenmais", khuyenMais);
            return "khuyenmai/list";
        }
        khuyenMaiService.save(khuyenMai);
        return "redirect:/";
    }


    @PostMapping("/delete-khuyenmai")
    public String deleteKhuyenMai(@RequestParam Long id) {
        khuyenMaiService.remove(id);
        return "redirect:/";
    }

}
