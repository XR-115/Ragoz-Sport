package com.sena.ragozsport.model;

import org.springframework.data.repository.CrudRepository;

import com.sena.ragozsport.model.pedido.Pedido;

public interface IPedido extends CrudRepository<Pedido,Integer>{
    
}
