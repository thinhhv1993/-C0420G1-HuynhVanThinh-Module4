package furama.controller;


import furama.model.User;
import furama.service.impl.RoleServiceImpl;
import furama.service.impl.UserServiceImpl;
import furama.untils.WebUtils1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.management.remote.JMXAuthenticator;
import java.awt.print.Pageable;
import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userRepository;

    @Autowired
    private RoleServiceImpl roleRepository;

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils1.toString1(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "<script> alert('Hi " + principal.getName() //
                    + "! You do not have permission to access this page!')</script>";
            model.addAttribute("message", message);
        }
        return "/index";
    }

    @PostMapping("/register")
    public ModelAndView viewRegister(@RequestParam("username") String username, @RequestParam("password") String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashPassword);
        user.setRole(roleRepository.findByRoleName("ROLE_USER"));
        userRepository.save(user);
        return new ModelAndView("/index");
    }

    @GetMapping("/logoutSuccessful")
    public ModelAndView logoutS(){
        return new ModelAndView("/index");
    }
}
