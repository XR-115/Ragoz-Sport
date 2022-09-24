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

import com.sena.ragozsport.model.guia.guia;
import com.sena.ragozsport.model.service.guia.IGuiaService;
import com.sena.ragozsport.model.service.pedido.IPedidoService;




@Controller
@SessionAttributes("guia")
@RequestMapping("/guia")
public class guiaController {
 
    @Autowired
    IGuiaService guiachi;

    @Autowired
    IPedidoService pedidochi;

    @GetMapping("/index")
    public String index(){
    return "redirect:/index";
    }

    @GetMapping(value="/registrar")
    public String register(Model m){
        guia guia=new guia();
        m.addAttribute("guia", guia);
        m.addAttribute("pedido", pedidochi.findAll());
        return "views/guia/form-guia";
    }

    @GetMapping(value = "/listar")
    public String list(Model m){
        m.addAttribute("guia", guiachi.findAll());
        return "views/guia/guia";
    }

    @PostMapping("/addG")
    public String add(@Valid guia guia,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "views/guia/form-guia";
            }
            else{
                try {
                guiachi.save(guia);
                status.setComplete();

                } catch (Exception e) {

                    m.addAttribute("idGuia", guia);
                    return "views/guia/form-guia";
                }
                
            }

    return "redirect:listar";
    }
    //---------------------------------------------------------- POST PARA ACTUALIZAR----------------------------------------------------//  
    @PostMapping("/UpdateGuia")
    public String UpdateGuia(@Valid guia guia,BindingResult res, Model m, SessionStatus status){

        if(res.hasErrors()){
            return "views/guia/form-guia";
        }
       guiachi.save(guia);
        m.addAttribute("guia", guia);

      
        return "redirect:listar";
    }
   //---------------------------------------------------------- GET RUTA PARA ACTUALIZAR----------------------------------------------------//  
    @GetMapping("/editarG/{idGuia}")
    public String editar (@PathVariable Integer idGuia,  Model m){
        guia guia=null;
        if (idGuia>0){
            guia=guiachi.findOne(idGuia);

        } else {
            return "redirect:listar";
        }
        m.addAttribute("guia", guia);
        m.addAttribute("accionGuia","editarGuia()");
        m.addAttribute("pedido", pedidochi.findAll());
        
        return "views/guia/form-guia";
    }  

    @GetMapping("/deleteG/{idGuia}")
    public String eliminar(@PathVariable Integer idGuia,Model m){
    if(idGuia>0){
    guiachi.delete(idGuia);
    }
    return "redirect:../listar";
    }

}