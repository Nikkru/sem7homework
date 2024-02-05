package com.example.sem7homework.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    @GetMapping("/public-data")
    public String publicPage(){
        return "public-data.html";
    }

    @GetMapping("/private-data")
    public String privatePage(){
        return "private-data.html";
    }

    @GetMapping("/login")
    public String login(){
        if (isAuthenticated()) {
            return "redirect:index.html";
        }
        return "login.html";
    }
}
