package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.jpacontrollers.exeption;

public class PreexistingEntityException extends Exception{
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
