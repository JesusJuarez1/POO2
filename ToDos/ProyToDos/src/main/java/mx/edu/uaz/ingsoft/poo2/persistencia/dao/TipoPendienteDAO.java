/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.persistencia.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.TipoPendiente;
import mx.edu.uaz.ingsoft.poo2.persistencia.jpacontrollers.exceptions.NonexistentEntityException;
import mx.edu.uaz.ingsoft.poo2.persistencia.jpacontrollers.exceptions.PreexistingEntityException;

/**
 *
 * @author jaime
 */
public class TipoPendienteDAO extends EntidadBaseDAO<TipoPendiente>  {

      public TipoPendienteDAO( EntityManager em) {
        super(TipoPendiente.class, em);
    }
    
}
