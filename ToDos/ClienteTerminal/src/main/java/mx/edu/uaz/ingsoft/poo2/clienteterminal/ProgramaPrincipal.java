package mx.edu.uaz.ingsoft.poo2.clienteterminal;

import java.util.List;
import java.util.Scanner;
import mx.edu.uaz.ingsoft.poo2.clienteterminal.servicios.PendienteService;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;
import static mx.edu.uaz.ingsoft.poo2.clienteterminal.constantes.ConstantesPrograma.*;
import mx.edu.uaz.ingsoft.poo2.clienteterminal.vista.PantallaTexto;

/**
 *
 * @author jaime
 */
public class ProgramaPrincipal {
/*
    static PendienteService servicio;
    

    
    static{
        servicio = new PendienteService();
        
    }
    */
    public static void main(String args[]){
        int accion;
        do{
            accion = PantallaTexto.pedirOpcion();
            switch(accion){
                case 1:
                    //List<Pendiente> listado = servicio.findAll();
                    //PantallaTexto.listarRegistros(listado);
                    break;
                case 2:
                    //Pendiente registro;
                    //registro = PantallaTexto.pedirPendiente();
                    //servicio.add(registro);
                    break;
            }
        }while(accion != OPCION_SALIR);
        
    }
}
