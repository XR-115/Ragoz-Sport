package com.sena.ragozsport.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.ragozsport.model.IUsuario;
import com.sena.ragozsport.model.service.email.EmailSenderService;
import com.sena.ragozsport.model.service.rol.IRolService;
import com.sena.ragozsport.model.service.usuario.IUsuarioService;
import com.sena.ragozsport.model.usuario.Usuario;

@Controller

public class indexController {

    @Autowired
    private IUsuarioService usuarioService;

    
    @Autowired
    private IUsuario IusuarioService;

    @Autowired 
    private EmailSenderService emailSenderService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IRolService interfazRol;
    
    @GetMapping(path = {"/index"})
    public String index(){
        return "index";
    }

    @GetMapping(path = {"/","","/dash","/home"})
    public String dash(Authentication auth, HttpSession session){

        String username= auth.getName();
        System.out.println(auth);

        if (session.getAttribute("username")== null) {
            Usuario usuario = usuarioService.findByNumeroDocumento(username);
      
            usuario.setPassword(null);
            session.setAttribute("usuario", usuario);
      
        }

        return "views/html-customizer/index";
    }

    

    @GetMapping("/login")
    public String login(){
        return "views/login/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:index";
    }

    // ------------------------- Ruta para Abrir Formulario -------------//
        @GetMapping(value = "/loginre")
        public String loginre(Model m) {
            Usuario usuario = new Usuario(); // Para instanciar un objeto de la clase
           
            m.addAttribute("roles", interfazRol.findAll());
            m.addAttribute("usuario", usuario);
            // Aca se retorna a la vista
            return "views/login/login-registro";
        }

        @PostMapping("/loginre")
        public String loginre(@Valid Usuario usuario, BindingResult resultado, Model m, SessionStatus status) {
            if (resultado.hasErrors()) {
                return "views/login/login-registro";
            } 
            if (usuario.getIdUsuario()==null) {
                try {
                    usuarioService.crearUsuario(usuario);
                } catch (Exception e) {
                    m.addAttribute("roles", interfazRol.findAll());
                    m.addAttribute("errorMessage", e.getMessage());
    
                    return "views/login/login-registro";
                }
            } 
           
            else if(usuario.getIdUsuario()!=null)
            {
                try {
                    usuarioService.save(usuario);
                } catch (Exception e) {
                    m.addAttribute("roles", interfazRol.findAll());
                    m.addAttribute("errorMessage", e.getMessage());
    
                    return "views/login/login-registro";
                }
           
            }
       
    
        
            status.setComplete();
            return "redirect:login";
        }

   

    @GetMapping("/loginpa")
    public String loginpa(){
        return "views/login/login-password";
    }
    
    @PostMapping("/loginpa")
    public String loginpa(@Valid String correo){
        emailSenderService.sendSimpleEmailForgotPassword(correo);
        return "views/login/login-registro";


    }
    
    @GetMapping("/restablecerClave/{correo}")
    public String loadViewUpdatePassword(@PathVariable String correo, Model model){
        model.addAttribute("correo", correo);
        return "views/login/login-passwordRecovery";
    }

    @PostMapping("/restablecerClave")
    public String updatePassword(@Valid String correo,@Valid String password) throws Exception{

        Usuario usuario = IusuarioService.findByCorreo(correo);

        usuario.setPassword(passwordEncoder.encode(password));
        IusuarioService.save(usuario);
        return "redirect:/login";
    }
}
