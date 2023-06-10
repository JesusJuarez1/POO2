package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ticket_table")
public class Ticket implements Serializable{
    private final static long serialVersionUID=1L;
    private final String nombreEmpresa = "LA TIENDITA";;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String lista;
    @Column
    private double total;
    
    public Ticket(){
        
    }
    
    public Ticket(double total) {
        this.total = total;
    }

    public Ticket(Long id, double total) {
        this.id = id;
        this.total = total;
    }

    public String getListaCompra() {
        return lista;
    }

    public double getTotal() {
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Corregir este metodo
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return nombreEmpresa+" \n"+lista+"\n"+"TOTAL: "+total+"\n"+"ID de compra: "+id+"\n";
    }
    
}
