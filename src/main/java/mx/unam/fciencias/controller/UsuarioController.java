/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mx.unam.fciencias.model.LibroModel;
import mx.unam.fciencias.model.UsuarioModel;
import mx.unam.fciencias.repository.LibroRepository;
import mx.unam.fciencias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
    private List<LibroModel> libros;
    
    @Autowired
    JavaMailSenderImpl mailSender;
    
    private String busqueda;
    
    @Autowired
    private UsuarioRepository usuarioRespository;
    
    @Autowired
    private LibroRepository libroRepository;

    @PostConstruct
    public void init(){
        usuarios=usuarioRespository.findAll();       
        libros=libroRepository.findAll();
        usuario=new UsuarioModel();
         usuario.setLibros(new ArrayList<LibroModel>());
    }
    
    public void busquedaLibros(String query){
        if(busqueda!=null){
            this.libros=libroRepository.findByParametro(query);
        }
    }

    public List<LibroModel> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroModel> libros) {
        this.libros = libros;
    }
    
    public void guardaUsuario(){
        usuarioRespository.save(usuario);
        init();
    }
    
    public void otroMetodo(){
        System.out.println("Mensaje");
       SimpleMailMessage message = new SimpleMailMessage();
       UsuarioModel user=new UsuarioModel();
       user.setCorreo("erewfwe@ffde.com");
       user.setRol("ADMIN");
       user.setUsuario("usuarioPrueba");
       user.setPassword("AFADFASAFAFASF");
       usuarioRespository.save(user);
		
		message.setFrom("memo.onilink@gmail.com");
		message.setTo("memo.onilink@gmail.com");
		message.setSubject("EJEMPLO MAIL");
		message.setText("prueba...\nusuario:usuarioPrueba password:AFADFASAFAFASF");
		mailSender.send(message);	
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

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }
    
    

}
