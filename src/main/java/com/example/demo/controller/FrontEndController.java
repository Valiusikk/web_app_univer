package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FrontEndController {
    @GetMapping("/index")
    public String getmain(){
        return "index";
    }

    @GetMapping("/new_booking")
    public String getNewBooking(){
        return "new_booking";
    }

    @GetMapping
    public String getindex(){
        return "main";
    }

    @GetMapping("/register")
    public String getRegisterForm(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/pricing")
    public String pricing(){
        return "pricing";
    }

    @GetMapping("/cars")
    public String cars(){
        return "car";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/services")
    public String services(){
        return "services";
    }
}
