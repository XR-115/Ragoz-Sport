package com.sena.ragozsport.model.service.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IUsuario;
import com.sena.ragozsport.model.usuario.Usuario;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuario interfazUsu;

    @Override
    public List<Usuario > findAll() {
        return (List<Usuario>) interfazUsu.findAll();
    }
    
     
    //-----------------REGISTAR-------------
    //---------------------------------------MÉTODO PARA GUARDAR UN DATO-------------------------------------------//
    @Override
    public Usuario save(Usuario usuario) throws Exception{
      if (!checkMetodoUsuarioAvailable(usuario)) {
          Usuario createdUsuario =interfazUsu.save(usuario);
      return createdUsuario; 
      } 
    return usuario;
        }

    private boolean checkMetodoUsuarioAvailable(Usuario usuario) throws Exception {
      Optional<Usuario> UsuarioFound = interfazUsu.findByNumeroDocumento(usuario.getNumeroDocumento());
      if (UsuarioFound.isPresent()) {
          throw new Exception("Este numero de documento ya fué registrado");
      }
      return false;
  }

  

    //----------------EDITAR-------------
    @Override
    public Usuario findOne(Integer idUsuario ) {
        return interfazUsu.findById(idUsuario).orElse(null);
    }

    //----------------ELIMINAR-------------
    @Override
    public void delete(Integer idUsuario) {
        interfazUsu.deleteById(idUsuario);
    }
}