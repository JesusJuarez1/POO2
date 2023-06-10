package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces;

import java.util.List;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;



public interface IProductoDao {
    Productos add(Productos unTodo);
    void delete(Productos unTodo);
    Productos update(Productos unTodo);
    Productos findById(Long id);
    List<Productos> findAll();
}
