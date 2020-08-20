package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControllers {
    @GetMapping
    public String helloWord(Model model){
        return "hello";
    }
}
