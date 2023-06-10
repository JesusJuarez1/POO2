/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.persistencia.dao;

import javax.persistence.EntityManager;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.TipoPendiente;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Usuario;

/**
 *
 * @author jaime
 */
public class UsuarioDAO extends EntidadBaseDAO<Usuario>  {

    public UsuarioDAO( EntityManager em) {
        super(Usuario.class, em);
    }
    
}
