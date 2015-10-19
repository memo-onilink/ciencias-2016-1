/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.unam.fciencias.model.LibroModel;
import mx.unam.fciencias.repository.LibroRepository;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Memo
 */
@Controller("libroController")
@Scope("session")
public class LibroController implements Serializable{
    
    @Autowired
    LibroRepository libroRepository;
    
    @PostConstruct
    public void init(){
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        
        LibroModel libro=new LibroModel();
        libro.setArchivo(event.getFile().getContents());
        libroRepository.save(libro);
        
        
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
