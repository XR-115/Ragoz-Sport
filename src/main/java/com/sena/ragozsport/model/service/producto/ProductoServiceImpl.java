package com.sena.ragozsport.model.service.producto;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.ragozsport.model.IProducto;
import com.sena.ragozsport.model.producto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private IProducto interfazPro;
    
    //----------------LISTAR-------------
    @Override
    public List<Producto > findAll() {
        return (List<Producto >) interfazPro.findAll();
    }
    
    //-----------------REGISTAR-------------
    @Override
    public void save(Producto producto) {
        interfazPro.save(producto); 
        
    }

    //----------------EDITAR-------------
    @Override
    public Producto findOne(Integer idProducto) {
        return interfazPro.findById(idProducto).orElse(null);
    }

    //----------------ELIMINAR-------------
    @Override
    public void delete(Integer idProducto) {
       interfazPro.deleteById(idProducto);
    }


    //metodo de la duplicidad
    private boolean checkreferenciaProdAvailable(Producto producto) throws Exception{
        Optional<Producto> referencesfound = interfazPro.findByReferenciaProd(producto.getReferenciaProd());
        
        if(referencesfound.isPresent()){
            throw new Exception("La referencia ya esta registrada");
        }
        return true;
    }
    
    @Override
    public Producto createProducto(Producto producto) throws Exception {
        
        
        if(checkreferenciaProdAvailable(producto)){
            producto = interfazPro.save(producto);
        }
        return producto;
    }
}