package com.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // loads login.html
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // loads register.html
    }
    @GetMapping("/home")
    public String homePage() {
        return "home"; // loads home.html
    }
}
