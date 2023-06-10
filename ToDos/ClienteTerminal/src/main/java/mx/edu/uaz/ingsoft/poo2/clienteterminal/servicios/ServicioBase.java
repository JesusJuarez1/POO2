/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.clienteterminal.servicios;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.edu.uaz.ingsoft.poo2.clienteterminal.servicios.interfaces.IServices;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.PendienteDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.IEntidadBaseDAO;

/**
 *
 * @author jaime
 */
public abstract class ServicioBase<T> implements IServices<T>{
    
    static Logger logger = Logger.getLogger("ServicioBase");
    
    private  EntityManagerFactory emf;
    private  EntityManager em;  
    protected IEntidadBaseDAO dao;
    
    public ServicioBase(){
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaProyectoToDos");
        em=emf.createEntityManager();
    }
    @Override
    public T findByID(Long id) {
        return (T)dao.findByID(id);
    }

    @Override
    public T add(T entidad) {
        return (T)dao.add(entidad);
    }

    @Override
    public T update(T entidad) {
        return (T)update(entidad);
    }

    @Override
    public List<T> findAll() {
        return (List<T>)dao.findAll();
    }

    @Override
    public void delete(T entidad) {
        dao.delete(entidad);
    }
    public EntityManager getEntidadManager(){
        return em;
    }
    
}
