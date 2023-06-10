package mx.edu.uaz.ingsoft.poo2.Proyecto.servicios;

import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.ProductoDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.IProductoDao;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.EntidadBaseDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.interfaces.IEntidadBaseDAO;

public class ProductoService extends ServicioBase<Productos> {
    public ProductoService(){
        super();
        dao= new ProductoDAO(getEntidadManager());
    }
}
