package com.sena.ragozsport.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.ragozsport.model.pago.Pago;
import com.sena.ragozsport.model.service.pago.IPagoService;
import com.sena.ragozsport.model.service.pago.PagoServiceImpl;

@Controller
//----------------------------RUTA PRINCIPAL------------------------//
    @SessionAttributes("pago")
    @RequestMapping("/pago")

//----------------------------HANDLERS------------------------//    
public class pagoController {
    @Autowired 
     PagoServiceImpl pagoD;
     @Autowired
     IPagoService ipagoD;
    



   

    
//-------------------------------------------------------------VER----------------------------------------------------//
    @GetMapping(value = "/pago")
    public String pago(Model m){

        m.addAttribute("pago",pagoD.findAll());
        
     return "views/pago/ver-pago";
 }

//-------------------------------------------------------------REGISTRAR----------------------------------------------------//
    @GetMapping(value = "/pagoAgregar")
    public String pagoAgragar(Model m){

        Pago pago=new Pago();
        m.addAttribute("pago",pago);

        
    return "views/pago/pagos";
    }
//-------------------------------------------------------------POST DE AGREGAR Y ACTUALIZAR----------------------------------------------------//
    @PostMapping("/pagoAgregar")
    public String pagoAgregar(@Valid Pago pago,BindingResult br, Model m, SessionStatus status, ModelMap model){
    
        if(br.hasErrors()){
            model.addAttribute("metodoPago", pago);
            
            }
            else {
                try {
                    pagoD.save(pago);
                    status.setComplete();
                    
                    
                } catch (Exception e) {
                    model.addAttribute("errorMessage",e.getMessage());
                    model.addAttribute("metodoPago", pago);
                    return "views/pago/pago";
                }
               
            }
            return "redirect:pago";
            
       
        
    }

    //-------------------------------------------------------------ELIMINAR DATO POR ID ----------------------------------------------------//
     @GetMapping("/deleteP/{idPago}")  
     public String deleteP(@PathVariable Integer idPago){
         if (idPago > 0) {
             pagoD.delete(idPago);
         }
         
             return "redirect:/pago/pago";
         
     }

    //-------------------------------------------------------------ACTUALIZAR----------------------------------------------------//
    @GetMapping(value = "/editarP/{idPago}")
    public String editarP(Model m, @PathVariable Integer idPago){
        Pago pago=new Pago();
        if (idPago>0) {
            pago=pagoD.findOne(idPago);
        }else{
            return("views/pago/pago");
        }
        m.addAttribute("pago", pago);
        m.addAttribute("accion","editarPago()");
        m.addAttribute("titulo","EDITAR");

    
        return "views/pago/pago";
    } 

//-------------------------------------------------------------VOLVER----------------------------------------------------//
 @GetMapping(value = "/index")
 public String index(){
  return "index";
}


}
