package mx.edu.uaz.ingsoft.poo2.Proyecto.servicios;

import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.ClienteDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;

public class ClienteService extends ServicioBase<Cliente> {
    public ClienteService(){
        super();
        dao= new ClienteDAO(getEntidadManager());
    }
}
