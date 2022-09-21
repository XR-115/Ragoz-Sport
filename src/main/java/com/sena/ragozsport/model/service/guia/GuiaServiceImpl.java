package com.sena.ragozsport.model.service.guia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IGuia;
import com.sena.ragozsport.model.guia.guia;

@Service
public class GuiaServiceImpl implements IGuiaService{
    
    @Autowired
    private IGuia guiachi;

    @Override
    public List<guia> findAll(){
        return (List<guia>) guiachi.findAll();
    }

    @Override
    public guia save(guia guia) throws Exception {
        if (!checkIdPedidoAvailable(guia)) {
            guia createdGuia = guiachi.save(guia);

            return createdGuia;
        }
        guiachi.save(guia);  
        return guia;
              
    }

    private boolean checkIdPedidoAvailable(guia guia) throws Exception {
        Optional guiaFound = guiachi.findByPedido(guia.getPedido());
        if (guiaFound.isPresent()) {
            throw new Exception("Esta pedido ya ha sido asociada a una guía");
        }
        return false;
    }

    //---------------------------------------MÉTODO PARA ACTUALIZAR SIN AFECTAR LA GUIA-------------------------------------------//
    @Override
    public void saveU(guia guia) {
        guiachi.save(guia);        
    }


    @Override
    public guia findOne(Integer idGuia) {

        return guiachi.findById(idGuia).orElse(null);
    }

    @Override
    public void delete(Integer idGuia) {
        guiachi.deleteById(idGuia);        
    }
}
