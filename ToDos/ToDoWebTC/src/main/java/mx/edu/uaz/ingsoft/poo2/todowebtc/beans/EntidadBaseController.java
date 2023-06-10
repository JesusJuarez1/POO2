
package mx.edu.uaz.ingsoft.poo2.todowebtc.beans;

import mx.edu.uaz.ingsoft.poo2.todowebtc.beans.interfaces.IEntidadBaseController;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mtzso
 */
public abstract class EntidadBaseController<T> implements IEntidadBaseController<T>{

    //private static final long serialVersionUID = 1L;
    
    private final EntityManagerFactory emf;
    protected final EntityManager em; 
    
    private T entidadLocal;
    private List<T> listaEntidades;
    
    public EntidadBaseController(){
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaProyectoToDos");
        em=emf.createEntityManager();
    }
    
    /**
     * @return the entidadLocal
     */
    public T getEntidadLocal() {
        return entidadLocal;
    }

    /**
     * @param entidadLocal the entidadLocal to set
     */
    public void setEntidadLocal(T entidadLocal) {
        this.entidadLocal = entidadLocal;
    }

    /**
     * @return the listaEntidades
     */
    public List<T> getListaEntidades() {
        return listaEntidades;
    }

    /**
     * @param listaEntidades the listaEntidades to set
     */
    public void setListaEntidades(List<T> listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
 
}
