package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao;

import javax.persistence.EntityManager;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.ITicketDao;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;

/**
 *
 * @author jesus
 */
public class TicketDAO extends EntidadBaseDAO<Ticket>{
    public TicketDAO(EntityManager em){
        super(Ticket.class, em);
    }
}
