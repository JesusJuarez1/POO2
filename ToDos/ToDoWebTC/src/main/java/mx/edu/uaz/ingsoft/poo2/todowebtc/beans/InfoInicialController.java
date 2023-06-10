
package mx.edu.uaz.ingsoft.poo2.todowebtc.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author mtzso
 */
@Named(value = "infoInicialController")
@SessionScoped
public class InfoInicialController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    PendientesController pendientesController;
    public InfoInicialController(){
        
    }
    public Integer totalPendientes(){
        return pendientesController.getTotalRegistros();
    }  
}
