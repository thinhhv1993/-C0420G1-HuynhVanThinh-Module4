package furama.controller;

import furama.model.HopDong;
import furama.service.impl.DichVuServiceImpl;
import furama.service.impl.HopDongChiTietServiceImpl;
import furama.service.impl.HopDongServiceImpl;
import furama.service.impl.KhachHangServiceImpl;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("hopdong")
public class HopDongController {


    @Autowired
    private HopDongServiceImpl hopDongService;

    @Autowired
    private KhachHangServiceImpl khachHangService;

    @Autowired
    private DichVuServiceImpl dichVuService;

    @Autowired
    private HopDongChiTietServiceImpl hopDongChiTietService;

    @ModelAttribute("hopdong")
    public HopDong setUpUserForm(){
        return new HopDong();
    }

    @GetMapping("/hopdongs")
    public ModelAndView listDichVu(@PageableDefault(value = 10) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
        Page<HopDong> hopDongs = null;
        if (search.equals("")) {
            hopDongs = hopDongService.findAllByDelete1(pageable,1);
        } else {
            hopDongs = hopDongService.findAllByKhachHang_HoTenContainingAndAndDelete1(search, pageable,1);
        }
        ModelAndView modelAndView = new ModelAndView("hopdong/list");
        modelAndView.addObject("hopdongs", hopDongs);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/view-hopdong/{id}")
    public ModelAndView viewHopDongs(@PathVariable Long id) {
        HopDong hopDong = hopDongService.findById(id);
        if (hopDong != null) {
            ModelAndView modelAndView = new ModelAndView("/hopdong/view");
            modelAndView.addObject("hopdong", hopDong);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-hopdong")
    public ModelAndView showCreateForm(@PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("hopdong/create", "hopdong", new HopDong());
        modelAndView.addObject("khachhang",khachHangService.findAll(pageable));
        modelAndView.addObject("dichvu",dichVuService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/create-hopdong")
    public ModelAndView saveHopDongs(@Validated @ModelAttribute("hopdong") HopDong hopDong, BindingResult bindingResult,@PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("hopdong/create");
        modelAndView.addObject("khachhang",khachHangService.findAll(pageable));
        modelAndView.addObject("dichvu",dichVuService.findAll(pageable));
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            hopDong.setTongTienThanhToan(hopDong.getDichVu().getKieuThue().getGia());
            hopDong.setDelete(1);
            hopDongService.save(hopDong);
            modelAndView.addObject("message", "Them Hợp Đồng Thanh Cong");
        }
        modelAndView.addObject("hopdong", new HopDong());
        return modelAndView;
    }

    @GetMapping("/edit-hopdong/{id}")
    public ModelAndView showEditForm(@Validated @PathVariable Long id,@PageableDefault(value = 10) Pageable pageable) {
        HopDong hopDong = hopDongService.findById(id);
        if (hopDong != null) {
            ModelAndView modelAndView = new ModelAndView("hopdong/edit");
            modelAndView.addObject("khachhang",khachHangService.findAll(pageable));
            modelAndView.addObject("dichvu",dichVuService.findAll(pageable));
            modelAndView.addObject("hopdong", hopDong);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-hopdong")
    public ModelAndView updateHopDong(@Validated @ModelAttribute("hopdong") HopDong hopDong,@PageableDefault(value = 10) Pageable pageable, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("hopdong/edit");
        modelAndView.addObject("khachhang", khachHangService.findAll(pageable));
        modelAndView.addObject("dichvu", dichVuService.findAll(pageable));
        modelAndView.addObject("hopdong", hopDong);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            hopDongService.save(hopDong);
            modelAndView.addObject("hopdong", hopDong);
            modelAndView.addObject("message", "Sửa hợp đồng thành công");
        }
        return modelAndView;
    }

    @PostMapping("/delete-hopdong")
    public String deleteHopDong(@RequestParam Long id, @CookieValue(value = "hopdong", defaultValue = "")String hopDongid,
                                HttpServletResponse response, HttpServletRequest request, Model model) {
        HopDong hopDong1 = hopDongService.findById(id);
        hopDongid = hopDongid + "n" + String.valueOf(hopDong1.getId());
        Cookie cookie = new Cookie("hopdong",hopDongid);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        hopDong1.setDelete(0);
        hopDongService.save(hopDong1);
        return "redirect:/hopdongs";
    }

    @GetMapping("/hopdongcookie")
    public ModelAndView hopDongCookie(@CookieValue(value = "hopdong", defaultValue = "")String hopDongid,
                                      HttpServletResponse response, HttpServletRequest request, Model model){
        ModelAndView modelAndView = new ModelAndView("/hopdong/hopdongdelete");
        Long idhopdong;
        Cookie[] cookies = request.getCookies();
        List<HopDong> list = new ArrayList<>();
        String cookieArray;
        String[] cookieArray1;
        for (Cookie ck : cookies) {
            if (ck.getName().equals("hopdong")) {
                cookieArray = ck.getValue();
                cookieArray1 =  cookieArray.split("n");
                for (String ste : cookieArray1) {
                    idhopdong = Long.parseLong(ste);
                 list.add(hopDongService.addCookies(idhopdong));
                }
                break;
            }
        }
        modelAndView.addObject("hopdong",list);
        return modelAndView;
    }
}
