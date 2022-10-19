package com.sena.ragozsport.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.sena.ragozsport.model.producto.Producto;
import com.sena.ragozsport.model.service.producto.IProductoService;

@Controller
@SessionAttributes("producto")
// ----RUTA PRINCIPAL
@RequestMapping("producto")
public class productoController {
    @Autowired IProductoService interfazPro;

    //------------  PRINCIPAL PRODUCTO -----------//
    @GetMapping(path={"/producto","/",""})
    public String principal(){
        return"views/Producto/Producto";
    }

    //------------------------- LISTAR -------------//
    @GetMapping("/listar")
    public String listar(Model m){
        m.addAttribute("Producto", interfazPro.findAll());
    
        //Aca se retorna a la vista
        return "views/producto/producto";
    }
    
    //------------------------- Ruta para Abrir Formulario -------------//
    @GetMapping("/abrirForm")
    public String abrirForm(Model m){
        Producto producto=new Producto(); //Para instanciar un objeto de la clase 
        m.addAttribute("Producto",producto);
        m.addAttribute("accion","Agregar Producto");
        //Aca se retorna a la vista
        return "views/producto/form-producto";
    }
    
    //------------------------- REGISTRAR -------------//
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("Producto") Producto producto,BindingResult resultado,Model m, SessionStatus status){
        if(resultado.hasErrors()){
            return "views/producto/form-producto";
        }
        
        try {
            interfazPro.createProducto(producto);
        } 
        catch (Exception e) {
            m.addAttribute("ErrorReferencia",e.getMessage());
            return "views/producto/form-producto";
        }

        // interfazPro.save(producto);
        status.setComplete();
        return "redirect:listar";
    }
    
    //------------------------- EDITAR -------------//
    @GetMapping("/editar/{idProducto}")
    public String editar(Model m,@PathVariable Integer idProducto){
        Producto producto = null;
        if(idProducto>0){
            producto = interfazPro.findOne(idProducto);
        }
        else{
            return "redirect:listar";
        }
        m.addAttribute("Producto",producto);
        m.addAttribute("accionPro","editarProducto()");
        m.addAttribute("accion","Actualizar Producto");
        return "views/producto/form-producto";
    }
    
    //------------------------- ELIMINAR -------------//
    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(@PathVariable Integer idProducto){
        if(idProducto>0){
            interfazPro.delete(idProducto);
        }
        return "redirect:/producto/listar";
     
    } 
}