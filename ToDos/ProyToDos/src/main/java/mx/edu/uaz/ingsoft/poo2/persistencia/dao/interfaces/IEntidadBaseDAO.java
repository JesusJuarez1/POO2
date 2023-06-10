package mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces;

import java.util.List;

public interface IEntidadBaseDAO<T> {
    T findByID(Long id);
    T add(T entidad);
    T update(T entidad);
    List<T> findAll();
    void delete(T entidad);
}
