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

import com.sena.ragozsport.model.envio.Envio;
import com.sena.ragozsport.model.service.envio.EnvioServiceImpl;
import com.sena.ragozsport.model.service.pago.PagoServiceImpl;

@Controller
//---------------------------------RUTA PRINCIPAL----------------------------//
@SessionAttributes("envio")
@RequestMapping("/envio")

//---------------------------------HANDLERS----------------------------//
public class envioController {

    @Autowired
    private EnvioServiceImpl enviD;
    @Autowired
    private PagoServiceImpl pagD;

//-------------------------------------------------------------LISTAR----------------------------------------------------//
    @GetMapping(value="/envio")
    public String envio(Model m) {

        m.addAttribute("envio", enviD.findAll());
        

        return "views/envio/ver-envio";
    }
//-------------------------------------------------------------AÑADIR----------------------------------------------------//
    @GetMapping(value="/addEn")
    public String addEn(Model m) {
        Envio envio=new Envio();

        m.addAttribute("fkpago", pagD.findAll());
        m.addAttribute("envio", envio);
        return "views/envio/envio";
    }        

    @PostMapping("/addEn")
    public String addEn(@Valid Envio envio,BindingResult br, Model m, SessionStatus status){
        if(br.hasErrors()){
            return "views/envio/envio";
            }
        enviD.save(envio);
        status.setComplete();
        return "redirect:ver-envio";
    }
//----------------------------------------------------------ACTUALIZAR----------------------------------------------------//   
    @GetMapping("/editarEn/{idEnvio}")
    public String editar (@PathVariable Integer idEnvio,  Model m){
        Envio envio=null;
        if (idEnvio>0){
            envio=enviD.findOne(idEnvio);

        } else {
            return "redirect:envio";
        }
        m.addAttribute("fkpago", pagD.findAll());
        m.addAttribute("envio",envio);
        
        return "views/envio/envio";
    }  
//------------------------------------------------------------BORRAR------------------------------------------------------------// 
    @GetMapping("/deleteEn/{idEnvio}")  
    public String delete(@PathVariable Integer idEnvio){
        if (idEnvio > 0) {
            enviD.delete(idEnvio);
        }
        
            return "redirect:/envio";
        
    }  

//-------------------------------------------------------------REDIRECCIONAR----------------------------------------------------//
    @GetMapping("/index")
    public String index(){
    return "redirect:/index";
    }
}
