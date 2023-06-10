
package mx.edu.uaz.ingsoft.poo2.todowebtc.beans.interfaces;

/**
 *
 * @author jaime
 */
public interface IEntidadBaseController<T> {
     String create();
     void findAll();
     String update();
     String delete();
     int getTotalRegistros();
}
