package com.sena.ragozsport.model.service.producto;

import java.util.List;

import com.sena.ragozsport.model.producto.Producto;

public interface IProductoService {
    //------------- Metodo de listar ------------//
    public List<Producto>findAll();
    //------------- Metodo de registar ------------//
    public void save(Producto producto);
    //------------- Metodo de Editar ------------//
    public Producto findOne(Integer idProducto);

    public void delete(Integer idProducto);


    //Para la duplicidad
    public Producto createProducto(Producto producto) throws Exception;
    
}
    
    



