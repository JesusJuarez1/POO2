package mx.edu.uaz.ingsoft.poo2.Proyecto.servicios;

import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.TicketDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;

public class TicketService extends ServicioBase<Ticket> {
    public TicketService(){
        super();
        dao= new TicketDAO(getEntidadManager());
    }
}
