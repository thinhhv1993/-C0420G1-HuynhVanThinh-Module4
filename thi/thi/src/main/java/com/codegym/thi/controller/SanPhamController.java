package com.codegym.thi.controller;


import com.codegym.thi.model.SanPham;
import com.codegym.thi.service.Impl.LoaiSanPhamImpl;
import com.codegym.thi.service.Impl.SanPhamServiceImpl;
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


@Controller
public class SanPhamController {

    @Autowired
    private LoaiSanPhamImpl loaiSanPham;

    @Autowired
    private SanPhamServiceImpl sanPhamService;

    @GetMapping("/sanphams")
    public ModelAndView listSanPham(@PageableDefault(value = 5) Pageable pageable,
                                    @RequestParam(value = "searchTenSanPham", defaultValue = "") String searchTenSanPham,
                                    @RequestParam(value = "searchGiaSanPham", defaultValue = "") String searchGiaSanPham,
                                    @RequestParam(value = "searchLoaiSanPham", defaultValue = "all") String searchLoaiSanPham) {
        Page<SanPham> sanPhams = null;
        if (searchTenSanPham.equals("") && searchGiaSanPham.equals("") && searchLoaiSanPham.equals("all")) {
            sanPhams = sanPhamService.findAll(pageable);
        } else if (!searchTenSanPham.equals("") && searchGiaSanPham.equals("") && !searchLoaiSanPham.equals("all")) {
            sanPhams = sanPhamService.findAllByLoaiSanPham_NameAndTensanpham(searchLoaiSanPham, searchTenSanPham, pageable);
        } else if (searchTenSanPham.equals("") && !searchGiaSanPham.equals("") && searchLoaiSanPham.equals("all")) {
            sanPhams = sanPhamService.findAllByGiabatdau(searchGiaSanPham, pageable);
        } else if (searchTenSanPham.equals("") && searchGiaSanPham.equals("") && !searchLoaiSanPham.equals("all")) {
            sanPhams = sanPhamService.findAllByLoaiSanPham_Name(searchLoaiSanPham, pageable);
        } else if (searchTenSanPham.equals("") && !searchGiaSanPham.equals("") && !searchLoaiSanPham.equals("all")) {
            sanPhams = sanPhamService.findAllByLoaiSanPham_NameAndGiabatdau(searchLoaiSanPham, searchGiaSanPham, pageable);
        } else {
            sanPhams = sanPhamService.findAllByLoaiSanPham_NameAndTensanphamAndGiabatdau(searchLoaiSanPham, searchTenSanPham, searchGiaSanPham, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("sanpham/list");
        modelAndView.addObject("sanphams", sanPhams);
        modelAndView.addObject("loaisanphams", loaiSanPham.findAll());
        modelAndView.addObject("sanpham", new SanPham());
        modelAndView.addObject("searchTenSanPham", searchTenSanPham);
        modelAndView.addObject("searchGiaSanPham", searchGiaSanPham);
        modelAndView.addObject("searchLoaiSanPham", searchLoaiSanPham);
        return modelAndView;
    }

    @PostMapping("/create-sanpham")
    public String createSanPham(@Validated @ModelAttribute("sanpham") SanPham sanPham, BindingResult bindingResult, Model model, @PageableDefault(value = 5) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            Page<SanPham> sanPhams = sanPhamService.findAll(pageable);
            model.addAttribute("sanphams", sanPhams);
            model.addAttribute("loaisanphams", loaiSanPham.findAll());
            return "/sanpham/list";
        }
        sanPhamService.save(sanPham);
        return "redirect:/sanphams";
    }

    @PostMapping("/delete-sanpham")
    public String deleteSanPham(@RequestParam Long id) {
        sanPhamService.remove(id);
        return "redirect:/sanphams";
    }
}
