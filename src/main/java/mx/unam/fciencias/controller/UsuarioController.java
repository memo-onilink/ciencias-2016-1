/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

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
    
    private String cadena="Hola Mundo... <String>";
    

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getSaludo() {
        return cadena;
    }
    
    
    
    
}
