package com.sena.ragozsport.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sena.ragozsport.model.guia.guia;
import com.sena.ragozsport.model.pedido.Pedido;

public interface IGuia extends CrudRepository<guia, Integer>{
    
    public Optional <guia> findByPedido(Pedido pedido);
}
