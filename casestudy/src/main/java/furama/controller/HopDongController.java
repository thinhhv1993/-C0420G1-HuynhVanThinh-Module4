package furama.controller;


import furama.model.HopDong;
import furama.service.impl.HopDongServiceImpl;
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
public class HopDongController {


    @Autowired
    private HopDongServiceImpl hopDongService;

    @GetMapping("/hopdongs")
    public ModelAndView listHopDongs(@PageableDefault(value = 5) Pageable pageable){
        Page<HopDong> hopDongs = hopDongService.findAll(pageable);
        return new ModelAndView("hopdong/list","hopdongs",hopDongs);
    }

    @GetMapping("/view-hopdong/{id}")
    public ModelAndView viewHopDongs(@PathVariable Long id){
        HopDong hopDong = hopDongService.findById(id);
        if(hopDong != null) {
            ModelAndView modelAndView = new ModelAndView("/hopdong/view");
            modelAndView.addObject("hopdong", hopDong);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-hopdong")
    public ModelAndView showCreateForm() {
        return new ModelAndView("hopdong/create","hopdong",new HopDong());
    }

    @PostMapping("/create-hopdong")
    public ModelAndView saveHopDongs(@ModelAttribute("hopdong") HopDong hopDong) {
        hopDongService.save(hopDong);
        ModelAndView modelAndView = new ModelAndView("hopdong/create");
        modelAndView.addObject("hopdong", new HopDong());
        modelAndView.addObject("message", "Them Hop Dong Thanh Cong");
        return modelAndView;
    }

    @GetMapping("/edit-hopdong/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        HopDong hopDong = hopDongService.findById(id);
        if(hopDong != null) {
            ModelAndView modelAndView = new ModelAndView("/hopdong/edit");
            modelAndView.addObject("hopdong", hopDong);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-hopdong")
    public ModelAndView updateHopDong(@ModelAttribute("hopdong") HopDong hopDong){
        hopDongService.save(hopDong);
        ModelAndView modelAndView = new ModelAndView("/hopdong/edit");
        modelAndView.addObject("hopdong", hopDong);
        modelAndView.addObject("message", "Hop Dong updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-hopdong/{id}")
    public String deletehopDong(@PathVariable Long id, RedirectAttributes redirect){
        hopDongService.remove(id);
        redirect.addFlashAttribute("message","Xoa Hop Dong Thanh Cong");
        return "redirect:/hopdongs";
    }
}
