package com.sena.ragozsport.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class indexController {

    @GetMapping(path = {"/","","/index","/home"})
    public String index(){
        return "index";
    }
    
}
