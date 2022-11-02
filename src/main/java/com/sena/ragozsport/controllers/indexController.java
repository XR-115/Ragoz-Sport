package com.sena.ragozsport.controllers;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sena.ragozsport.model.service.usuario.IUsuarioService;
import com.sena.ragozsport.model.usuario.Usuario;

@Controller

public class indexController {

    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping(path = {"/index"})
    public String index(){
        return "index";
    }

    @GetMapping(path = {"/","","/dash","/home"})
    public String dash(Authentication auth, HttpSession session){

        String username= auth.getName();


        if (session.getAttribute("username")== null) {
            Usuario usuario = usuarioService.findByUsername(username);
      
            usuario.setPassword(null);
            session.setAttribute("usuario", usuario);
      
        }

        return "views/html-customizer/index";
    }

    

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:index";
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
