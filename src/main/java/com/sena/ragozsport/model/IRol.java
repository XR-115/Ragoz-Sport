package com.sena.ragozsport.model;

import org.springframework.data.repository.CrudRepository;

import com.sena.ragozsport.model.usuario.Roles;

public interface IRol extends CrudRepository<Roles, Integer>{
    
}
