package mx.edu.uaz.ingsoft.poo2.Proyecto.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mx.edu.uaz.ingsoft.poo2.Proyecto.constantes.Constantes;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ClienteService;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ProductoService;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.TicketService;

public class VentanaPCT extends JFrame{
    
    public VentanaPCT(String nombre){
        super(nombre);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        pnlCentral = new JPanel();
        pnlInferior = new JPanel();
        
        cristal.add(pnlCentral,BorderLayout.CENTER);
        cristal.add(pnlInferior,BorderLayout.PAGE_END);
        
        btnProductos = new JButton("Productos");
        btnClientes = new JButton("Clientes");
        btnTickets = new JButton("registros de compra");
        btnCancelar = new JButton("Cancelar");
        JButton[] b = {btnProductos, btnClientes, btnTickets, btnCancelar};
        sizeBotones(b);
        
        btnProductos.addActionListener((ActionEvent e)->{
            if(null != nombre)
                switch (nombre) {
                    case "Consultas":
                        crearVentanaConsultas("Productos");
                        dispose();
                        break;
                    case "Eliminar":
                        crearVentanaEA("Productos", "Eliminar");
                        dispose();
                        break;
                    case "Actualizar":
                        crearVentanaEA("Productos", "Actualizar");
                        dispose();
                        break;
            }
        });
        
        btnClientes.addActionListener((ActionEvent e)->{
            switch (nombre) {
                case "Consultas":
                    crearVentanaConsultas("Clientes");
                    dispose();
                    break;
                case "Eliminar":
                    crearVentanaEA("Clientes", "Eliminar");
                    dispose();
                    break;
                case "Actualizar":
                    crearVentanaEA("Clientes", "Actualizar");
                    dispose();
                    break;
            }
        });
        
        btnTickets.addActionListener((ActionEvent e)->{
            switch (nombre) {
                case "Consultas":
                    crearVentanaConsultas("Tickets");
                    
                    dispose();
                    break;
                case "Eliminar":
                    crearVentanaEA("Tickets", "Eliminar");
                    dispose();
                    break;
            }
        });
        
        btnCancelar.addActionListener((ActionEvent e)->{
            dispose();
        });
        
        pnlCentral.add(btnProductos);
        pnlCentral.add(btnClientes);
        if(!"Actualizar".equals(nombre)){
            pnlCentral.add(btnTickets);
        }
        pnlCentral.add(btnCancelar);
        
    }
    
    Container cristal;
    private final JPanel pnlCentral;
    private final JPanel pnlInferior;
    private final JButton btnProductos;
    private final JButton btnClientes;
    private final JButton btnTickets;
    private final JButton btnCancelar;
    
    private void sizeBotones(JButton[] botones) {
        for(JButton b: botones){
            b.setMinimumSize(new Dimension(20,20));
            b.setMaximumSize(new Dimension(180,90));
            b.setPreferredSize(new Dimension(140, 70));
        }
    }
    
    public void crearVentanaEA(String nombre, String accion){
        EliminarActualizar ventanaEA;
        ventanaEA = new EliminarActualizar(nombre,accion);
        ventanaEA.setVisible(true);
        ventanaEA.setSize(200,150);
    }
    
    public void crearVentanaConsultas(String nombre){
        VentanaConsultas consulta;
        consulta = new VentanaConsultas(nombre);
        consulta.setVisible(true);
        consulta.setSize(300, 150);
    }
}



class EliminarActualizar extends JFrame{
    static ProductoService productos;
    static ClienteService cliente;
    static TicketService ticket;
    static{
        productos = new ProductoService();
        cliente = new ClienteService();
        ticket = new TicketService();
    }
    
    public EliminarActualizar(String nombre,String accion){
        super(accion);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        pnlSuperior = new JPanel();
        pnlCentral = new JPanel();
        pnlInferior = new JPanel();
        
        cristal.add(pnlSuperior,BorderLayout.PAGE_START);
        cristal.add(pnlCentral,BorderLayout.CENTER);
        cristal.add(pnlInferior,BorderLayout.PAGE_END);
       
        lbTitulo = new JLabel("Ingresa el id del "+nombre);
        lbId = new JLabel("Id: ");
        tfId = new JTextField();
        tfId.setColumns(3);
        btnAccion = new JButton(accion);
        btnCancelar = new JButton("Cancelar");
        
        btnAccion.addActionListener((ActionEvent e)->{
            String idInvalido = Constantes.ID_INVALIDA;
            String confirmar = Constantes.CONFIRMACION_ELI;
            String eliminado = Constantes.ELIMINADO;
            String noEliminado = Constantes.NO_ELIMINADO;
            String noEncontrado = Constantes.NO_ENCONTRADO;
            if("Eliminar".equals(accion)){
                if(isNumeric(tfId.getText()) == false){
                    JOptionPane.showMessageDialog(null, idInvalido);
                    tfId.setText("");
                }else{
                    switch (nombre) {
                        case "Productos":
                            Productos unProducto;
                            unProducto = productos.findByID(Long.parseLong(tfId.getText()));
                            if(unProducto != null){
                                int confirmacion = JOptionPane.showConfirmDialog(null, 
                                    confirmar+"\n"+unProducto.toString());
                                if(JOptionPane.OK_OPTION == confirmacion){
                                    productos.delete(unProducto);
                                    JOptionPane.showMessageDialog(null, eliminado);
                                    dispose();
                                }else{
                                    JOptionPane.showMessageDialog(null,noEliminado );
                                    tfId.setText("");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, noEncontrado);
                                tfId.setText("");
                            }
                            break;
                        case "Clientes":
                            Cliente unCliente;
                            unCliente = cliente.findByID(Long.parseLong(tfId.getText()));
                            if(unCliente != null){
                                int confirmacion = JOptionPane.showConfirmDialog(null, 
                                    confirmar+"\n"+unCliente.toString());
                                if(JOptionPane.OK_OPTION == confirmacion){
                                    cliente.delete(unCliente);
                                    JOptionPane.showMessageDialog(null, eliminado);
                                    dispose();
                                }else
                                    JOptionPane.showMessageDialog(null, noEliminado);
                                tfId.setText("");
                            }else{
                                JOptionPane.showMessageDialog(null, noEncontrado);
                                dispose();
                            }
                            break;
                        case "Tickets":
                            Ticket unTicket;
                            unTicket = ticket.findByID(Long.parseLong(tfId.getText()));
                            if(unTicket != null){
                                int confirmacion = JOptionPane.showConfirmDialog(null, 
                                    confirmar+"\n"+unTicket.toString());
                                if(JOptionPane.OK_OPTION == confirmacion){
                                    ticket.delete(unTicket);
                                    JOptionPane.showMessageDialog(null, eliminado);
                                    dispose();
                                }else
                                    JOptionPane.showMessageDialog(null,noEliminado);
                                tfId.setText("");
                            }else{
                                JOptionPane.showMessageDialog(null, noEncontrado);
                                dispose();
                            }
                            break;
                    }
                }
            }else if("Actualizar".equals(accion)){
                if(isNumeric(tfId.getText()) == false){
                    JOptionPane.showMessageDialog(null, idInvalido);
                    tfId.setText("");
                }else{
                    switch (nombre) {
                        case "Productos":
                            Productos unProducto;
                            unProducto = productos.findByID(Long.parseLong(tfId.getText()));
                            if(unProducto != null){
                                crearVentanaActualizar("Productos");
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, noEncontrado);
                                tfId.setText("");
                            }
                            break;
                        case "Clientes":
                            Cliente unCliente;
                            unCliente = cliente.findByID(Long.parseLong(tfId.getText()));
                            if(unCliente != null){
                                crearVentanaActualizar("Clientes");
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, noEncontrado);
                                tfId.setText("");
                            }
                            break;
                    }
                }
            }
        });
        
        btnCancelar.addActionListener((ActionEvent e)->{
            dispose();
        });
        
        pnlSuperior.add(lbTitulo);
        pnlCentral.add(lbId);
        pnlCentral.add(tfId);
        pnlInferior.add(btnAccion);
        pnlInferior.add(btnCancelar);
    }
    
    Container cristal;
    private final JPanel pnlSuperior;
    private final JPanel pnlCentral;
    private final JPanel pnlInferior;
    private final JButton btnAccion;
    private final JButton btnCancelar;
    private final JLabel lbTitulo;
    private final JLabel lbId;
    private final JTextField tfId;
    
    public boolean isNumeric(String cadena){
	try {
            Long.parseLong(cadena);
            return Integer.parseInt(cadena) > 0;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public void crearVentanaActualizar(String nombre){
        VentanaActualizar ventanaA;
        ventanaA = new VentanaActualizar(nombre,Long.parseLong(tfId.getText()));
        ventanaA.setVisible(true);
        if("Productos".equals(nombre)){
            ventanaA.setSize(300, 175);
        }else if("Clientes".equals(nombre)){
            ventanaA.setSize(300, 100);
        }
        
    }
}
