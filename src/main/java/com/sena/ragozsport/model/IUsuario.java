package com.sena.ragozsport.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sena.ragozsport.model.usuario.Usuario;




public interface IUsuario extends CrudRepository<Usuario,Integer>{

    public Optional<Usuario> findByNumeroDocumento(String NumeroDocumento);
    public Usuario findByUsername(String username);

}
