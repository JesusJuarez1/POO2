/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.clienteterminal.servicios;

import java.util.List;
import mx.edu.uaz.ingsoft.poo2.clienteterminal.servicios.interfaces.IUsuario;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.PendienteDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.UsuarioDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.IEntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Usuario;

/**
 *
 * @author jaime
 */
public class PendienteService extends ServicioBase<Pendiente>{
    public PendienteService(){
        super();
        dao= new PendienteDAO(getEntidadManager());
    }
}
