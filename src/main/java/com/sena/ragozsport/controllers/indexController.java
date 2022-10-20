package com.sena.ragozsport.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class indexController {

    @GetMapping(path = {"/","","/index","/home"})
    public String index(){
        return "index";
    }

    @GetMapping("/dash")
    public String dash(){
        return "views/html-customizer/index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginre")
    public String loginre(){
        return "login-registro";
    }

    @GetMapping("/loginpa")
    public String loginpa(){
        return "login-password";
    }
    
}
