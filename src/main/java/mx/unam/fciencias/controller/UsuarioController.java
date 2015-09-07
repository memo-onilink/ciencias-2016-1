/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import mx.unam.fciencias.model.UsuarioModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



/**
 *
 * @author Memo
 */

@Controller("usuarioController")
@Scope("session")
public class UsuarioController {
    
    private UsuarioModel usuario;
    private List<UsuarioModel> usuarios;
    private String cadena;
    private Date date;
    
    @PostConstruct
    public void init(){
        usuario=new UsuarioModel();
        usuarios=new ArrayList<>();
        cadena="Hola Mundo... <String>";
        System.out.println("Objecto creado");
        date=new Date();
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("Objecto Destruido");
    }
    
    public void guardausuario(){
        usuarios.add(usuario);
        usuario=new UsuarioModel();
        //this.usuario.setUsuario(this.usuario.getUsuario()+"***");
       //throw new RuntimeException("Error !!!");
    }
    
    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getSaludo() {
        return cadena;
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
}
