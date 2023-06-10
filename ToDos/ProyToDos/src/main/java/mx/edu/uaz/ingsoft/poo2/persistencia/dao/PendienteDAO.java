
package mx.edu.uaz.ingsoft.poo2.persistencia.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.IPendienteDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;

/**
 *
 * @author jaime
 */
public class PendienteDAO extends EntidadBaseDAO<Pendiente> implements IPendienteDAO,Serializable{
    private static final long serialVersionUID = 1L;

    public PendienteDAO( EntityManager em) {
        super(Pendiente.class, em);
    }

}
