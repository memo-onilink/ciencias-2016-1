/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Memo
 */
@Controller("libroController")
@Scope("session")
public class LibroController implements Serializable{
    
    @PostConstruct
    public void init(){
    }
    
}
