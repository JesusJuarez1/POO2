package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces;

import java.util.List;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;



public interface IClienteDao {
    Cliente add(Cliente unTodo);
    void delete(Cliente unTodo);
    Cliente update(Cliente unTodo);
    Cliente findById(Long id);
    List<Cliente> findAll();
}
