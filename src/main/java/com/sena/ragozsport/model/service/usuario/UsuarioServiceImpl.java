package com.sena.ragozsport.model.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IUsuario;
import com.sena.ragozsport.model.usuario.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuario interfazUsu;

    @Override
    public Usuario findByNumeroDocumento(String numeroDocumento) {
        return interfazUsu.findByNumeroDocumento(numeroDocumento);
    };

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) interfazUsu.findAll();
    }

    
    
    
    
    
    private boolean checkMetodoUsuarioAvailable(Usuario usuario) throws Exception {
        Usuario UsuarioFound = interfazUsu.findByNumeroDocumento(usuario.getNumeroDocumento());
        if (UsuarioFound!=null) {
            throw new Exception("Este número de documento ha sido registrado");
        }
        return true;
    }





    // -----------------REGISTAR------------- //
    @Override
    public Usuario save(Usuario usuario) throws Exception {
        if (!checkMetodoUsuarioAvailable(usuario)) {

            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            Usuario createdUsuario = interfazUsu.save(usuario);

            return createdUsuario;
        }
        return usuario;
    }

    // ----------------EDITAR-------------
    @Override
    public Usuario findOne(Integer idUsuario) {
        return interfazUsu.findById(idUsuario).orElse(null);
    }

    // ----------------ELIMINAR-------------
    @Override
    public void delete(Integer idUsuario) {
        interfazUsu.deleteById(idUsuario);
    }

}