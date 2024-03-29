package com.tony.springsecurity.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            model.addAttribute("message", "Welcome Message");
        } else {
            model.addAttribute("message", "Hello, " + principal.getName());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Info");
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "Dashboard " + principal.getName());
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Admin " + principal.getName());
        return "index";
    }
}
