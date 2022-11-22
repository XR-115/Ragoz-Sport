package com.sena.ragozsport.model.service.usuario;

import java.util.List;


import com.sena.ragozsport.model.usuario.Usuario;



public interface IUsuarioService {
        
        public Usuario findByNumeroDocumento(String numeroDocumento);
        
        //------------- Metodo de listar ------------//
        public List<Usuario>findAll();
        //------------- Metodo de registar ------------//
        public Usuario save(Usuario usuario) throws Exception;
        //------------- Metodo de Editar ------------//
        public Usuario findOne(Integer idUsuario);
        //------------- Metodo de eliminar ------------//
        public void delete(Integer idUsuario);

       
}
