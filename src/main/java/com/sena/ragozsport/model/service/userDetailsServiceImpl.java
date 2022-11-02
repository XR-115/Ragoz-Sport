package com.sena.ragozsport.model.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.IUsuario;
import com.sena.ragozsport.model.usuario.Usuario;

@Service
public class userDetailsServiceImpl implements UserDetailsService{

    @Autowired 
    private IUsuario usuarioDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        UserBuilder builder = null;

        if (usuario != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usuario.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }
        else{
            throw new UsernameNotFoundException("No hemos encontrado el usuario");
        }
        return builder.build();
    }
    
}
