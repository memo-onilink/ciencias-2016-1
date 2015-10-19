/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller.login;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Memo
 */
@Controller("loginController")
@Scope("request")
public class LoginController {
     public String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
}
