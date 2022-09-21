package com.sena.ragozsport.model.service.guia;

import java.util.List;

import com.sena.ragozsport.model.guia.guia;

public interface IGuiaService {
    
    public List<guia> findAll();
    public guia save(guia guia) throws Exception;
    public void saveU(guia guia);
    public guia findOne(Integer idGuia);
    public void delete(Integer idGuia);
}