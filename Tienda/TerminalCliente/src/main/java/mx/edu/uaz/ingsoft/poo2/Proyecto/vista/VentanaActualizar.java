/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.Proyecto.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mx.edu.uaz.ingsoft.poo2.Proyecto.constantes.Constantes;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ClienteService;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ProductoService;

/**
 *
 * @author jesus
 */
public class VentanaActualizar extends JFrame{
    static ProductoService productos;
    static ClienteService cliente;
    static{
        productos = new ProductoService();
        cliente = new ClienteService();
    }
    
    public VentanaActualizar(String nombre, Long id){
        super("Actualizar "+nombre);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        pnlSuperior = new JPanel();
        pnlSuperior2 = new JPanel();
        pnlCentral = new JPanel();
        pnlCentral2 = new JPanel();
        pnlInferior = new JPanel();
        
        cristal.add(pnlSuperior,BorderLayout.PAGE_START);
        cristal.add(pnlCentral,BorderLayout.CENTER);
        cristal.add(pnlInferior,BorderLayout.PAGE_END);
        pnlCentral.add(pnlSuperior2,BorderLayout.PAGE_START);
        pnlCentral.add(pnlCentral2,BorderLayout.PAGE_END);
        
        btnActualizar = new JButton("Actualizar");
        btnCancelar = new JButton("Cancelar");
        lbNombre = new JLabel("Nombre producto: ");
        tfNombre = new JTextField();
        tfNombre.setColumns(10);
        lbPrecio = new JLabel("Precio del Producto: ");
        tfPrecio = new JTextField();
        tfPrecio.setColumns(5);
        lbInventario = new JLabel("Cantidad de inventario: ");
        tfInventario = new JTextField();
        tfInventario.setColumns(3);
        Productos p;
        Cliente c;
        if("Productos".equals(nombre)){
            p = productos.findByID(id);
            tfNombre.setText(p.getNombre());
            tfPrecio.setText(""+p.getPrecio());
            tfInventario.setText(""+p.getCantidad());
        }else if("Clientes".equals(nombre)){
            c = cliente.findByID(id);
            lbNombre.setText("Nombre del Cliente: ");
            tfNombre.setText(c.getNombre());
        }
        
        btnActualizar.addActionListener((ActionEvent e)->{
            String camposVacios = Constantes.CAMPOS_VACIOS;
            String camposInvalidos = Constantes.CAMPOS_INCORRECTOS;
            if("Productos".equals(nombre)){
                if("".equals(tfNombre.getText())){
                    error(camposVacios);
                }else if(isDouble(tfPrecio.getText()) == false && isNumeric(tfPrecio.getText()) == false){
                    error(camposInvalidos);
                }else if(isNumeric(tfInventario.getText()) == false){
                    error(camposInvalidos);
                }else{
                    Productos unProducto = productos.findByID(id);
                    unProducto.setNombre(tfNombre.getText());
                    unProducto.setPrecio(Double.parseDouble(tfPrecio.getText()));
                    unProducto.setCantidad(Integer.parseInt(tfInventario.getText()));
                    unProducto = productos.update(unProducto);
                    JOptionPane.showMessageDialog(null, "Producto Actualizado \n"+unProducto.toString());
                    dispose();
                }
            }else if("Clientes".equals(nombre)){
                if("".equals(tfNombre.getText())){
                    error(camposVacios);
                }else{
                    Cliente unCliente = cliente.findByID(id);
                    unCliente.setNombre(tfNombre.getText());
                    unCliente = cliente.update(unCliente);
                    JOptionPane.showMessageDialog(null, "Producto Actualizado \n"+unCliente.toString());
                    dispose();
                }
            }
            
        });
        
        btnCancelar.addActionListener((ActionEvent e)->{
            dispose();
        });
        if("Clientes".equals(nombre)){
            pnlSuperior.add(lbNombre);
            pnlSuperior.add(tfNombre);
            pnlInferior.add(btnActualizar);
            pnlInferior.add(btnCancelar);
        }else{
            pnlSuperior.add(lbNombre);
            pnlSuperior.add(tfNombre);
            pnlSuperior2.add(lbPrecio);
            pnlSuperior2.add(tfPrecio);
            pnlCentral2.add(lbInventario);
            pnlCentral2.add(tfInventario);
            pnlInferior.add(btnActualizar);
            pnlInferior.add(btnCancelar);
        }
        
    }
    
    Container cristal;
    private final JPanel pnlSuperior;
    private final JPanel pnlSuperior2;
    private final JPanel pnlCentral;
    private final JPanel pnlCentral2;
    private final JPanel pnlInferior;
    private final JButton btnActualizar;
    private final JButton btnCancelar;
    private final JLabel lbNombre;
    private final JLabel lbPrecio;
    private final JLabel lbInventario;
    private final JTextField tfNombre;
    private final JTextField tfPrecio;
    private final JTextField tfInventario;
    
    public boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return Integer.parseInt(cadena) > 0;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public boolean isDouble(String cadena){
	try {
		Double.parseDouble(cadena);
                return Double.parseDouble(cadena) > 0;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public void error(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
