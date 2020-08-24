package controllers;


import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.EmailService;
import service.EmailServiceImpl;

import java.util.List;

@Controller
public class EmailController {
    EmailService emailService = new EmailServiceImpl();
    @GetMapping("/form")
    public String showForm(@ModelAttribute("Email") Email email, Model model){
        List<String> listLanguage = emailService.getLanguage();
        List<String> listPageSize = emailService.getPageSize();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listPageSize",listPageSize);
        return "form";
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("Email")Email email, Model model){
        return new ModelAndView("update","Email",email);
    }
}
