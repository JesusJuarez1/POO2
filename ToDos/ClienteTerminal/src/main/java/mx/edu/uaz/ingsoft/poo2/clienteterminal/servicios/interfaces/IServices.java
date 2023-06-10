/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.clienteterminal.servicios.interfaces;

import java.util.List;

/**
 *
 * @author jaime
 */
public interface IServices<T> {
    T findByID(Long id);
    T add(T entidad);
    T update(T entidad);
    List<T> findAll();
    void delete(T entidad);
}
