package com.sena.ragozsport.model.service.guia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IGuia;
import com.sena.ragozsport.model.guia.guia;

@Service
public class GuiaServiceImpl implements IGuiaService{
    
    @Autowired
    private IGuia guiachi;

        //---------------------------------------MÉTODO PARA LISTAR LOS DATOS-------------------------------------------//
    @Override
    public List<guia> findAll(){
        return (List<guia>) guiachi.findAll();
    }


    //---------------------------------------MÉTODO PARA ACTUALIZAR SIN AFECTAR LA GUIA-------------------------------------------//
    @Override
    public void save(guia guia) {
        guiachi.save(guia);        
    }

    //---------------------------------------MÉTODO PARA TOMAR SOLO UN DATO-------------------------------------------//
    @Override
    public guia findOne(Integer idGuia) {

        return guiachi.findById(idGuia).orElse(null);
    }

    //---------------------------------------MÉTODO PARA BORRAR UN DATO-------------------------------------------//
    @Override
    public void delete(Integer idGuia) {
        guiachi.deleteById(idGuia);        
    }
}
