package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces;

import java.util.List;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;



public interface ITicketDao {
    Ticket add(Ticket unTodo);
    void delete(Ticket unTodo);
    Ticket findById(Long id);
    List<Ticket> findAll();
}
