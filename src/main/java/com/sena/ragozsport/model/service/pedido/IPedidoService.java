package com.sena.ragozsport.model.service.pedido;

import java.util.List;

import com.sena.ragozsport.model.pedido.Pedido;

public interface IPedidoService {
    //------------- Metodo de listar ------------//
    public List<Pedido>findAll();
    //------------- Metodo de registar ------------//
    public void save(Pedido pedido);
    //------------- Metodo de Editar ------------//
    public Pedido findOne(Integer idPedido);
    //------------- Metodo de eliminar ------------//
    public void delete(Integer idPedido);
}
