/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import mx.unam.fciencias.model.UsuarioModel;
import mx.unam.fciencias.repository.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Memo
 */
@Controller("usuarioController")
@Scope("session")
public class UsuarioController implements Serializable{  
    
    private UsuarioModel usuario;
    private List<UsuarioModel> usuarios;
    
    @Autowired
    private UsuarioRespository usuarioRespository;

    @PostConstruct
    public void init(){
        usuarios=usuarioRespository.findAll();
        usuario=new UsuarioModel();
    }
    
    public void guardaUsuario(){
        usuarioRespository.save(usuario);
        init();
    }
    

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }
    
    

}
