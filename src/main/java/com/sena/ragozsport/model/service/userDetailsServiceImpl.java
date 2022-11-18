package com.sena.ragozsport.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import com.sena.ragozsport.model.IUsuario;
import com.sena.ragozsport.model.usuario.Usuario;



import com.sena.ragozsport.model.usuario.Roles;

@Service
public class userDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuario usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Usuario usu = usuarioDao.findByUsername(username);
        if (usu == null) {
            throw new UsernameNotFoundException(username);
        }

        UserDetails user = User.withUsername(usu.getUsername())
                .password(usu.getPassword())
                .authorities(getAuthorities(usu)).build()
                ;

        return user;
    }

    private Collection<GrantedAuthority> getAuthorities(Usuario user){
        List <Roles> userGroups = user.getRoles();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for(Roles userGroup : userGroups){
            authorities.add(new SimpleGrantedAuthority(userGroup.getNombre().toUpperCase()));
        }

        return authorities;
    }
    // private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Roles> roles) {
    //     return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    // }

}
