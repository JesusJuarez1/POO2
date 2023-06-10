package mx.edu.uaz.ingsoft.poo2.Proyecto.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.List;
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

public class VentanaConsultas extends JFrame{
    static ProductoService produc;
    static ClienteService clien;
    static TicketService tick;
    
    static{
        produc = new ProductoService();
        clien = new ClienteService();
        tick = new TicketService();
        
    }
    public VentanaConsultas(String nombre){
        super("Consultar "+nombre);
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
        
        lId = new JLabel("Ingresa el id del "+nombre+": ");
        tfId = new JTextField();
        tfId.setColumns(3);
        btnId = new JButton("Buscar");
        lTodos = new JLabel("Buscar todos los "+nombre+": ");
        btnTodos = new JButton("Buscar Todos");
        btnCancelar = new JButton("Cancelar");
        
        btnId.addActionListener((ActionEvent e)->{
            String idInvalida = Constantes.ID_INVALIDA;
            String noEncontrado = Constantes.NO_ENCONTRADO;
            switch (nombre) {
                case "Productos":
                    if(isNumeric(tfId.getText()) == false){
                        JOptionPane.showMessageDialog(null, idInvalida);
                    } else{
                        Productos p = produc.findByID(Long.parseLong(tfId.getText()));
                        if(p == null){
                            JOptionPane.showMessageDialog(null, noEncontrado);
                        }else{
                            JOptionPane.showMessageDialog(null, p.toString());
                            dispose();
                        }
                        
                    }
                    break;
                case "Clientes":
                    if("".equals(tfId.getText()) || isNumeric(tfId.getText()) == false){
                        JOptionPane.showMessageDialog(null, idInvalida);
                        tfId.setText("");
                    } else{
                        Cliente c = clien.findByID(Long.parseLong(tfId.getText()));
                        if(c == null){
                            JOptionPane.showMessageDialog(null, noEncontrado);
                            tfId.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, c.toString());
                            dispose();
                        }
                    }
                    break;
                case "Tickets":
                    if("".equals(tfId.getText()) || isNumeric(tfId.getText()) == false){
                        JOptionPane.showMessageDialog(null, idInvalida);
                        tfId.setText("");
                    } else{
                        Ticket t = tick.findByID(Long.parseLong(tfId.getText()));
                        if(t == null){
                            JOptionPane.showMessageDialog(null, noEncontrado);
                            tfId.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, t.toString());
                            dispose();
                        }
                    }
                    break;
            }
        });
        
        btnTodos.addActionListener((ActionEvent e)->{
            String sinRegistros = Constantes.SIN_REGISTROS;
            String separador = Constantes.SEPARADOR;
            switch (nombre) {
                case "Productos":
                    List<Productos> lisProduc = produc.findAll();
                    if(lisProduc.isEmpty()== true){
                        JOptionPane.showMessageDialog(null, sinRegistros);
                        dispose();
                    }else{
                        String salida = "";
                        for(Productos p: lisProduc){
                            salida += p.toString()+separador;
                        }
                        JOptionPane.showMessageDialog(null, salida);
                        dispose();
                    }
                    break;
                    
                case "Clientes":
                    List<Cliente> lisClien = clien.findAll();
                    if(lisClien.isEmpty()== true){
                        JOptionPane.showMessageDialog(null, sinRegistros);
                        dispose();
                    }else{
                        String salida = "";
                        for(Cliente c: lisClien){
                            salida += c.toString()+separador;
                        }
                        JOptionPane.showMessageDialog(null, salida);
                        dispose();
                    }
                    break;
                    
                case "Tickets":
                    List<Ticket> lisTick = tick.findAll();
                    if(lisTick.isEmpty()== true){
                        JOptionPane.showMessageDialog(null, sinRegistros);
                        dispose();
                    }else{
                        String salida = "";
                        for(Ticket t: lisTick){
                            salida += t.toString()+separador;
                        }
                        JOptionPane.showMessageDialog(null, salida);
                        dispose();
                    }
                    break;
            }
        });
        
        btnCancelar.addActionListener((ActionEvent e)->{
            dispose();
        });
        
        pnlSuperior.add(lId);
        pnlSuperior.add(tfId);
        pnlSuperior.add(btnId);
        pnlCentral.add(lTodos);
        pnlCentral.add(btnTodos);
        pnlInferior.add(btnCancelar);
    }
    
    Container cristal;
    private final JPanel pnlSuperior;
    private final JPanel pnlCentral;
    private final JPanel pnlInferior;
    private final JButton btnTodos;
    private final JButton btnId;
    private final JButton btnCancelar;
    private final JLabel lId;
    private final JLabel lTodos;
    private final JTextField tfId;
    
    public boolean isNumeric(String cadena){
	try {
		Long.parseLong(cadena);
                return Long.parseLong(cadena) > 0;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
