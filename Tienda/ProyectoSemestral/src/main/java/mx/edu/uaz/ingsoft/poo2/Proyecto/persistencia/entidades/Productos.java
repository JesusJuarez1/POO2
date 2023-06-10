package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="producto_table")
public class Productos implements Serializable{
    
    private final static long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private double precio;
    @Column
    private int cantidad;
    
    public Productos(){
        
    }
    
    public Productos(String nombre) {
        this.nombre = nombre;
    }

    public Productos(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double presio){
        this.precio = presio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
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
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombre + "\n"+"Precio: "+precio + "\n "+"Inventario: "+cantidad+"\n "+"ID: "+id;
    }
}
