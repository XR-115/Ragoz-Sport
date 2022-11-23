package com.sena.ragozsport.model;


import org.springframework.data.repository.CrudRepository;

import com.sena.ragozsport.model.usuario.Usuario;




public interface IUsuario extends CrudRepository<Usuario,Integer>{

    public Usuario findByCorreo(String correo);
    public Usuario findByNumeroDocumento(String NumeroDocumento);


}
