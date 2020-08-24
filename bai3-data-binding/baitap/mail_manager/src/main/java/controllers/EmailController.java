package controllers;


import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.EmailService;
import service.EmailServiceImpl;


import java.util.List;

@RequestMapping("/email")
@Controller
public class EmailController {
    EmailService emailService = new EmailServiceImpl();

    @GetMapping("")
    public ModelAndView getEmailPage(){
        return new ModelAndView("email","emails",emailService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteEmail(@PathVariable Integer id){
        emailService.delete(id);
        return "redirect:/email";
    }



    @GetMapping("/form")
    public ModelAndView showForm( Model model){
        List<String> listLanguage = emailService.getLanguage();
        List<String> listPageSize = emailService.getPageSize();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listPageSize",listPageSize);
        return new ModelAndView("form","email",new Email());
    }

    @PostMapping("/form")
    public String getAddEmail(@ModelAttribute Email email){
        emailService.save(email);
        return "redirect:/email";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Integer id, Model model ){
        Email email = emailService.findById(id);
        List<String> listLanguage = emailService.getLanguage();
        List<String> listPageSize = emailService.getPageSize();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listPageSize",listPageSize);
        return new ModelAndView("edit", "email", email);
    }

    @PostMapping("/edit")
    public String getEditStudent(@ModelAttribute Email email){
        emailService.save(email);
        return "redirect:/email";
    }


}
