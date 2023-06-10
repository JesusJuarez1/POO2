package mx.edu.uaz.ingsoft.poo2.Proyecto.logica;

import java.util.List;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.ProductoDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ProductoService;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.TicketService;

public class Compra {
    static TicketService servicioTicket;
    static ProductoService servicioProducto; 
    
    static {
        servicioTicket = new TicketService();
        servicioProducto = new ProductoService();
    }
    public Ticket hacerComprar(List<Productos> productos){
        Ticket unTicket = new Ticket();
        unTicket.setTotal(calcularTotal(productos));
        unTicket.setLista(obtenerLista(productos));
        restarInventario(productos);
        servicioTicket.add(unTicket);
        return unTicket;
    }
    
    public double calcularTotal(List<Productos> listaCompra){
        double totalCompra = 0.0;
        for(Productos p: listaCompra){
            totalCompra += p.getPrecio();
        }
        return totalCompra;
    }
    
    public String obtenerLista(List<Productos> listaCompra){
        String listaSalida = "";
        for(Productos p: listaCompra){
            listaSalida += p.toString()+"\n";
        }
        return listaSalida;
    }
    
    public void restarInventario(List<Productos> compra){
        ProductoDAO dao = null;
        for(Productos p: compra){
            p.setCantidad(p.getCantidad()-1);
            servicioProducto.update(p);
        }
    }
}
