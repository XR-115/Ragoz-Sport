package com.sena.ragozsport.model.service.guia;

import java.util.List;

import com.sena.ragozsport.model.guia.guia;

public interface IGuiaService {
    
    public List<guia> findAll();
    public void save(guia guia);
    public guia findOne(Integer idGuia);
    public void delete(Integer idGuia);
}