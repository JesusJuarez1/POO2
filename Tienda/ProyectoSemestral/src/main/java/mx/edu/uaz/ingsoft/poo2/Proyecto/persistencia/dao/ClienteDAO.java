package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao;


import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.IClienteDao;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;

/**
 *
 * @author jesus
 */
public class ClienteDAO extends EntidadBaseDAO<Cliente>{
    public ClienteDAO(EntityManager em){
        super(Cliente.class, em);
    }
}
