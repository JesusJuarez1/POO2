
package mx.edu.uaz.ingsoft.poo2.todowebtc.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import mx.edu.uaz.ingsoft.poo2.persistencia.dao.PendienteDAO;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;
import mx.edu.uaz.ingsoft.poo2.todowebtc.beans.utils.MensajesPrograma;

/**
 *
 * @author jaime
 */
@Named("pendienteController")
@SessionScoped
public class PendientesController extends EntidadBaseController<Pendiente> implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private  PendienteDAO dao;
    private  String mensajeError;
    
    
    @PostConstruct
    public void initPendientesController(){
        dao = new PendienteDAO(em);
        setEntidadLocal(new Pendiente());
        setListaEntidades(dao.findAll());
        mensajeError=MensajesPrograma.MSG_VACIO;
        
    }
    
    public List<Pendiente> getListadoPendientes(){
        return getListaEntidades();
    }
    
    @Override
    public int getTotalRegistros(){
        return  dao.findAll().size();
    }

    @Override
    public String create() {
        if(getEntidadLocal().getDescripcion().trim().isEmpty()){
            mensajeError=MensajesPrograma.MSG_DATOS_INCOMPLETOS;
            return "";
        }
        setEntidadLocal(dao.add(getEntidadLocal()));
        setListaEntidades(dao.findAll());
        mensajeError=MensajesPrograma.MSG_VACIO;
        return "listado";
    }
        
    @Override
    public void findAll() {
        setListaEntidades(dao.findAll());
    }

    @Override
    public String update() {
        if(getEntidadLocal().getDescripcion().trim().isEmpty()){
            mensajeError=MensajesPrograma.MSG_DATOS_INCOMPLETOS;
            return "";
        }
        setEntidadLocal(dao.update(getEntidadLocal()));
        mensajeError=MensajesPrograma.MSG_VACIO;
        return "listado";
    }

    @Override
    public String delete() {
        dao.delete(getEntidadLocal());
        setEntidadLocal(new Pendiente());
        mensajeError=MensajesPrograma.MSG_VACIO;
        return "listado";
    }
     /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }
    public String regresarListado(){
        setListaEntidades(dao.findAll());
        return "listado";
    }
}
