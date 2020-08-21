package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Controller
public class SandWich {

    @RequestMapping("/save")
    public String save(@RequestParam(required = false) String[] vehicle,Model model) {
         String vehicle1 = Arrays.toString(vehicle);
         model.addAttribute("vehicle1", vehicle1);
            return "index";
    }
}
