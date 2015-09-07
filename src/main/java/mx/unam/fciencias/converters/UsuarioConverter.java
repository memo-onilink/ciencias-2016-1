/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import mx.unam.fciencias.model.UsuarioModel;

/**
 *
 * @author Memo
 */
@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        UsuarioModel usuario=new UsuarioModel();
        String cadenas[]=value.split("|");
        usuario.setUsuario(cadenas[0]);
        usuario.setPassword(cadenas[1]);
        usuario.setCorreo(cadenas[2]);
       return usuario;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        UsuarioModel usuario=(UsuarioModel)value;
        return usuario.getUsuario()+"|"
                +usuario.getPassword()+"|"+
                usuario.getCorreo();
    }
    
}
