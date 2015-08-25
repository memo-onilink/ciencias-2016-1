/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.unam.fciencias.model.UsuarioModel;



/**
 *
 * @author Memo
 */

@ManagedBean
@SessionScoped
public class UsuarioController {
    
    private UsuarioModel usuario=new UsuarioModel();
    private List<UsuarioModel> usuarios=new ArrayList<>();
    
    private String cadena="Hola Mundo... <String>";
    
    
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
    
    
    
    
}
