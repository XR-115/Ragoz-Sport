package com.sena.ragozsport.model.service.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IRol;
import com.sena.ragozsport.model.usuario.Roles;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {
    
    @Autowired
    private IRol interfazRol;
    
    @Override
    public List<Roles> findAll() {
        return (List<Roles>) interfazRol.findAll();
    }
}
