package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Calculator;

@Controller
public class CalculatorControllers {

        @RequestMapping("/calculator")
        public String calculator(@RequestParam(required = false,defaultValue = "0")Double number1,@RequestParam(required = false,defaultValue = "0") Double number2,String calculate, Model model){
            Calculator calculator = new Calculator();
          return  calculator.Calculator(number1,number2,calculate,model);
        }
}
