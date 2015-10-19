/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.unam.fciencias.model.UsuarioModel;
import mx.unam.fciencias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Memo
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService,Serializable {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        UsuarioModel user;
        List<GrantedAuthority> autoridades = new ArrayList<>();

        user = usuarioRepository.findByUsuario(username);
        if (user != null) {
            
            autoridades.add(new SimpleGrantedAuthority(user.getRol()));

            return new User(user.getUsuario(), user.getPassword(), true, true, true, true, autoridades);
        } else {
            throw new UsernameNotFoundException("User " + username + " no se encontro");
        }
    }
    
 }