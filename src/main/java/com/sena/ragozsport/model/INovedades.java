package com.sena.ragozsport.model;

import org.springframework.data.repository.CrudRepository;

import com.sena.ragozsport.model.novedades.Novedades;

public interface INovedades extends CrudRepository<Novedades,Integer> {
    
}
