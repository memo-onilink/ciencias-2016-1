/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.repository;

import java.io.Serializable;
import java.util.List;
import mx.unam.fciencias.model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Memo
 */
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    
    @Override
    List<UsuarioModel> findAll();

    @Query("SELECT u FROM UsuarioModel u WHERE u.usuario=? ")
    public UsuarioModel findByUsuario(String usuario);
    
}
