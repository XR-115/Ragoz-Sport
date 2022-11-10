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

import com.sena.ragozsport.model.novedades.Novedades;
import com.sena.ragozsport.model.service.envio.EnvioServiceImpl;
import com.sena.ragozsport.model.service.novedades.INovedadesService;

@Controller

@SessionAttributes("novedades")
@RequestMapping("/novedades")
public class novedadesController {
    @Autowired
    INovedadesService interfazNov;
    @Autowired
    private EnvioServiceImpl enviD;

//-------------------------------------------------------------LISTAR----------------------------------------------------//
@GetMapping(value="/novedades")
public String novedades(Model m) {

    m.addAttribute("novedades", interfazNov.findAll());
    

    return "views/novedades/novedades";
}

@GetMapping(value="/addNo")
public String addNo(Model m) {
    Novedades novedades=new Novedades();

     m.addAttribute("novedades", novedades);
    m.addAttribute("envio", enviD.findAll() );


    return "views/novedades/form-novedades";
}        


@PostMapping("/addNo")
    public String addNo(@Valid Novedades novedades,BindingResult br, Model m, SessionStatus status){
        if(br.hasErrors()){
            return "views/novedades/form-novedades";
            }
            else{
                try {
                    interfazNov.save(novedades);
                status.setComplete();

                } catch (Exception e) {
                    m.addAttribute("errorMessage",e.getMessage());
                    m.addAttribute("idEnvio", novedades);
                    return "views/novedades/form-novedades";
                }
                
            }
      
        return "redirect:novedades";
    }

     //---------------------------------------------------------- POST PARA ACTUALIZAR----------------------------------------------------//  
     @PostMapping("/UpdateNo")
     public String UpdateEn(@Valid Novedades novedades,BindingResult br, Model m, SessionStatus status){
 
         if(br.hasErrors()){
             return "views/novedades/novedadesEditar";
         }
         interfazNov.save(novedades);
         m.addAttribute("novedades", novedades);
 
       
         return "redirect:novedades";
     }

     //----------------------------------------------------------ACTUALIZAR----------------------------------------------------//   
    @GetMapping("/editarNo/{idNovedades}")
    public String editar (@PathVariable Integer idNovedades,  Model m){
        Novedades novedades=null;
        if (idNovedades>0){
            novedades=interfazNov.findOne(idNovedades);

        } else {
            return "redirect:novedades";
        }
        m.addAttribute("accion","editarNovedades()");
        m.addAttribute("envio",enviD.findAll());
        m.addAttribute("novedades",novedades);

        
        return "views/novedades/novedades";

    }  
    

    @GetMapping("/delete/{idNovedades}")  
    public String delete(@PathVariable Integer idNovedades){
        if (idNovedades > 0) {
            interfazNov.delete(idNovedades);
        }
        
            return "views/novedades/novedades";
        
    }  

}
