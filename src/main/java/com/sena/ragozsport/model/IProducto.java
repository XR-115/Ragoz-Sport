package com.sena.ragozsport.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sena.ragozsport.model.producto.Producto;

public interface IProducto extends CrudRepository<Producto,Integer>{
    //Para la duplicidad
    public Optional <Producto> findByReferenciaProd(String referenciaProd);
}

