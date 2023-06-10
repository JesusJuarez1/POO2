package mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces;


import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.util.IDBExecute;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.util.IDBJustExecute;

public class EntidadBaseDAO<T> implements IEntidadBaseDAO<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private final EntityManager em;
    private final Class claseEntidad;

    public EntidadBaseDAO(Class claseEntidad, EntityManager em){
        this.claseEntidad = claseEntidad;
        this.em = em;
    }

    @Override
    public T findByID(Long id) {
        return (T) em.find(claseEntidad, id);
    }

    @Override
    public T add(T entidad) {
        T resultado=null;
        resultado = executeTransactionWithResult(() -> {
            em.persist(entidad);
            return entidad;
        });
        return resultado;
    }

    @Override
    public T update(T entidad) {
        return executeTransactionWithResult(() -> em.merge(entidad));
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(claseEntidad);
        criteriaQuery.select(criteriaQuery.from(claseEntidad));
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void delete(T entidad) {
        executeTransaction(() -> em.remove(entidad) );
    }

    private T executeTransactionWithResult(IDBExecute<T> comando){
        try{
            em.getTransaction().begin();
            T salida = comando.executeDBCommand();
            em.getTransaction().commit();
            return salida;
        }catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.ALL, e.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }
    private Boolean executeTransaction(IDBJustExecute comando){
        try{
            em.getTransaction().begin();
            comando.executeDBCommand();
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.ALL, e.getMessage());
            em.getTransaction().rollback();
            return false;
        }
    }
}
