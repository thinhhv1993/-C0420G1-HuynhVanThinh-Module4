package service;

import org.springframework.ui.Model;

public class Calculator {

    public String Calculator(Double number1, Double number2, String calculate, Model model){
        double result = 0;
        switch (calculate){
            case "(+)":
                result = number1 + number2;
                break;
            case "(-)":
                result = number1 - number2;
                break;
            case "(x)":
                result = number1 * number2;
                break;
            case "(/)":
                if(number2 == 0){
                    String error = "please input number 2 # 0";
                    model.addAttribute("result",error);
                    return "index";
                }
                result = number1 / number2;
                break;
        }
        model.addAttribute("result",result);
        return "index";
    }
}
