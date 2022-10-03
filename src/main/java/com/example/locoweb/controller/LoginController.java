/*package com.example.locoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    UserDetailsService uService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/loginProcessing")
    public String loginProcessing(
        @RequestParam String username,
        @RequestParam String password
    ) {
        UserDetails user = uService.loadUserByUsername("admin");
        
        if(user.getPassword().equals("123")) {
            return "redirect:/admin/list";
        } else {
            return "redirect:/login?error=";
        }
    }
}*/