/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.clienteterminal.vista;

import java.util.List;
import java.util.Scanner;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;
import static mx.edu.uaz.ingsoft.poo2.clienteterminal.constantes.ConstantesPrograma.*;
/**
 *
 * @author jaime
 */
public class PantallaTexto {
    private static Scanner teclado;
     static{
         teclado = new Scanner(System.in);
     } 
    public static void listarRegistros(List<Pendiente> listado){
        
        for(Pendiente registro:listado){
            System.out.println(registro.toString());
        }
    }
    
    public static Pendiente pedirPendiente(){
        Pendiente registro = new Pendiente();
        String descripcion;
        do{
            System.out.println("Ingresa la descripción del Pendiente:");
            registro.setDescripcion(teclado.nextLine());
                    
        }while(registro.getDescripcion().trim().isEmpty());
        return registro;
    }
    
    public static int pedirOpcion(){
        int respuesta=OPCION_INVALIDA;
        while(respuesta == OPCION_INVALIDA){
            mostrar_opciones_menu();
            try{
                respuesta = teclado.nextInt();
                if(respuesta < OPCION_SALIR || respuesta > OPCION_LISTAR){
                    System.out.println("Opción inválida");
                    respuesta = OPCION_INVALIDA;
                }
            }catch(Exception e){
                System.out.println("Error al ingresar la opción");
                respuesta = OPCION_INVALIDA;
            }
        }
        teclado.nextLine();//Para limpiar el buffer del teclado
        return respuesta;
    }
    
    public static void mostrar_opciones_menu(){
        System.out.println(OPCION_AGREGAR+"-Listar registros");
        System.out.println(OPCION_LISTAR+"-Ingresar nuevo registro");
        System.out.println(OPCION_SALIR+"-Salir");
    }
}
