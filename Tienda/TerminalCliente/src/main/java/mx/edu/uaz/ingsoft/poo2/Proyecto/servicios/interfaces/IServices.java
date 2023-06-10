package mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.interfaces;

import java.util.List;

public interface IServices<T> {
    T findByID(Long id);
    T add(T entidad);
    T update(T entidad);
    List<T> findAll();
    void delete(T entidad);
}
