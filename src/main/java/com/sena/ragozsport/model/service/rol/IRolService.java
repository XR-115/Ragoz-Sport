package com.sena.ragozsport.model.service.rol;

import java.util.List;

import com.sena.ragozsport.model.usuario.Roles;

public interface IRolService {

    // ------------- Metodo de listar ------------//
    public List<Roles> findAll();
}
