package com.sena.ragozsport.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.ragozsport.model.IRol;
import com.sena.ragozsport.model.service.usuario.IUsuarioService;
import com.sena.ragozsport.model.usuario.Usuario;

@Controller

@SessionAttributes("usuario")
@RequestMapping("/usuario")

public class usuarioController {

    
    @Autowired
    IUsuarioService interfazUsu;

    @Autowired
    IRol interfazRol;

    // ------------ PRINCIPAL PRODUCTO -----------//
    @GetMapping(path = { "/usuario", "/", "" })
    public String usuario(Model m) {
        m.addAttribute("usuario", interfazUsu.findAll());
        return "views/usuario/usuario";

    }


    // ------------------------- Ruta para Abrir Formulario -------------//
    @GetMapping(value = "/addu")
    public String addu(Model m) {
        Usuario usuario = new Usuario(); // Para instanciar un objeto de la clase
       
        m.addAttribute("roles", interfazRol.findAll());
        m.addAttribute("usuario", usuario);
        m.addAttribute("accion", "Agregar Usuario");
        // Aca se retorna a la vista
        return "views/usuario/form-usuario";
    }

    @PostMapping("/addu")
    public String add(@Valid Usuario usuario, BindingResult resultado, Model m, SessionStatus status) {
        if (resultado.hasErrors()) {
            return "views/usuario/form-usuario";
        } 
            try {
                interfazUsu.save(usuario);
            } catch (Exception e) {
                m.addAttribute("errorMessage", e.getMessage());

                return "views/usuario/form-usuario";
            }

    
        status.setComplete();
        return "redirect:usuario";
    }

    // ------------------------- EDITAR -------------//
    @GetMapping("/editarusu/{idUsuario}")
    public String editar(Model m, @PathVariable Integer idUsuario) {
        Usuario usuario = null;
        if (idUsuario > 0) {
            usuario = interfazUsu.findOne(idUsuario);
        } else {
            return "redirect:usuario";
        }
        m.addAttribute("usuario", usuario);
        m.addAttribute("accionusu", "editarUsuario()");
        return "views/usuario/form-usuario";
    }

    // ------------------------- ELIMINAR -------------//
    // @GetMapping("/eliminar/{idUsuario}")
    // public String eliminar(@PathVariable Integer idUsuario){
    // if(idUsuario>0){
    // interfazUsu.delete(idUsuario);
    // }
    // return "redirect:/usuario/usuario";

    // }

    @GetMapping("/dash")
    public String dash(Model m) {

        return "index";
    }

}