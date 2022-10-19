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

import com.sena.ragozsport.model.IGuia;
import com.sena.ragozsport.model.IProducto;
import com.sena.ragozsport.model.pedido.Pedido;
import com.sena.ragozsport.model.service.pedido.IPedidoService;

@Controller
@SessionAttributes("pedido")
// ----RUTA PRINCIPAL
@RequestMapping("/pedido")
public class pedidoController {
    
    @Autowired IPedidoService interfazPed;
    @Autowired IProducto iProducto;
    @Autowired IGuia iGuia;

    //------------  PRINCIPAL PEDIDO -----------//
    @GetMapping(path={"/pedido","/",""})
    public String principal(){
        return"views/pedido/pedido";
    }

    //------------------------- LISTAR -------------//
    @GetMapping("/listar")
    public String listar(Model m){
        m.addAttribute("pedido", interfazPed.findAll());
    
        //Aca se retorna a la vista
        return "views/pedido/pedido";
    }
    
//------------------------- Ruta para Abrir Formulario -------------//
    @GetMapping("/abrirForm")
    public String abrirForm(Model m){
        Pedido pedido = new Pedido(); //Para instanciar un objeto de la clase 
        m.addAttribute("fkproducto", iProducto.findAll());
        m.addAttribute("fkguia", iGuia.findAll());
        m.addAttribute("pedido", pedido);
        m.addAttribute("accion","Agregar Pedido");
        //Aca se retorna a la vista
        return "views/pedido/form-pedido";
    }
    
//------------------------- REGISTRAR -------------//
@PostMapping("/add")
    public String add(@Valid Pedido pedido,BindingResult resultado,Model m, SessionStatus status){
        if(resultado.hasErrors()){
            return "views/pedido/form-pedido";
        }
        
        interfazPed.save(pedido);
        status.setComplete();
        return "redirect:listar";
    }
    
//------------------------- EDITAR -------------//
    @GetMapping("/editar/{idPedido}")
    public String editar(Model m,@PathVariable Integer idPedido){
        Pedido pedido = null;
        if(idPedido>0){
            pedido = interfazPed.findOne(idPedido);
        }
        else{
            return "redirect:listar";
        }
        m.addAttribute("fkproducto", iProducto.findAll());
        m.addAttribute("pedido",pedido);
        m.addAttribute("accionPedido","editarPedido()");
        m.addAttribute("accion","Actualizar Pedido");
        return "views/pedido/form-pedido";
    }
    
//------------------------- ELIMINAR -------------//
    @GetMapping("/eliminar/{idPedido}")
    public String eliminar(@PathVariable Integer idPedido){
        if(idPedido>0){
            interfazPed.delete(idPedido);
        }
        return "redirect:/pedido/listar";
     
    } 
}