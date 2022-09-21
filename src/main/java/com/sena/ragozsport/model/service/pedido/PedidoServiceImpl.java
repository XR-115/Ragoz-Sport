package com.sena.ragozsport.model.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IPedido;
import com.sena.ragozsport.model.pedido.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService{
    @Autowired
    private IPedido interfazPed;
    
    //----------------LISTAR-------------
    @Override
    public List<Pedido > findAll() {
        return (List<Pedido>) interfazPed.findAll();
    }
    
    //-----------------REGISTAR-------------
    @Override
    public void save(Pedido pedido) {
        interfazPed.save(pedido); 
        
    }

    //----------------EDITAR-------------
    @Override
    public Pedido findOne(Integer idPedido) {
        return interfazPed.findById(idPedido).orElse(null);
    }

    //----------------ELIMINAR-------------
    @Override
    public void delete(Integer idPedido) {
       interfazPed.deleteById(idPedido);
    }
}
