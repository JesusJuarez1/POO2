package mx.edu.uaz.ingsoft.poo2.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="tabla_pendientes")
public class ToDo implements Serializable{
    
    private final static long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Integer prioridad;
    @Column
    private String clase;
    @Column
    private String descripcion;
    
    public ToDo(){
        descripcion = "";
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", prioridad=" + prioridad + ", clase=" + clase + ", descripcion=" + descripcion + '}';
    }
    
}
