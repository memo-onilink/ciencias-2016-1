/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.repository;

import java.io.Serializable;
import java.util.List;
import mx.unam.fciencias.model.LibroModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Memo
 */
public interface LibroRepository extends CrudRepository<LibroModel, Integer>{
    
    
    @Override
    List<LibroModel> findAll();
    
    @Query("SELECT l FROM LibroModel l WHERE l.titulo LIKE CONCAT('%',?1,'%') OR l.isbn LIKE CONCAT('%',?1,'%') ")
    List<LibroModel> findByParametro(String parametro);
    
}
