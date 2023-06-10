package mx.edu.uaz.ingsoft.poo2.Proyecto.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame{
    
    public VentanaPrincipal(){
        super("La Tiendita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        pnlSuperior = new JPanel();
        pnlCentral = new JPanel();
        
        cristal.add(pnlSuperior,BorderLayout.PAGE_START);
        cristal.add(pnlCentral,BorderLayout.CENTER);
        
        btnAgregar = new JButton("Agregar Producto");
        btnEliminar = new JButton("Eliminar Registro");
        btnActualizar = new JButton("Actualizar Registro");
        btnHacerCompra = new JButton("Hacer Compra");
        btnConsultar = new JButton("Consultas");
        btnSalir = new JButton("Salir");
        JButton[] botones = {btnAgregar, btnEliminar, btnActualizar, btnHacerCompra, btnConsultar, btnSalir};
        sizeBotones(botones);
        
        btnAgregar.addActionListener((ActionEvent e)->{
            VentanaAgregar vAgregar;
            vAgregar = new VentanaAgregar();
            vAgregar.setVisible(true);
            vAgregar.setSize(300,200);
            
        });
        
        btnEliminar.addActionListener((ActionEvent e)->{
            VentanaPCT pct;
            pct= new VentanaPCT("Eliminar");
            pct.setVisible(true);
            pct.setSize(500,200);
        });
        
        btnActualizar.addActionListener((ActionEvent e)->{
            VentanaPCT pct;
            pct= new VentanaPCT("Actualizar");
            pct.setVisible(true);
            pct.setSize(500,200);
        });
        
        btnHacerCompra.addActionListener((ActionEvent e)->{
            VentanaCompra vCompra;
            vCompra = new VentanaCompra();
            vCompra.setVisible(true);
            //vCompra.pack();
            vCompra.setSize(700, 150);
        });
        
        btnConsultar.addActionListener((ActionEvent e)->{
            VentanaPCT pct;
            pct= new VentanaPCT("Consultas");
            pct.setVisible(true);
            pct.setSize(500,200);
        });
        
        btnSalir.addActionListener(
            (e)->{System.exit(0);}
        );
        
        pnlSuperior.add(btnAgregar);
        pnlSuperior.add(btnEliminar);
        pnlSuperior.add(btnActualizar);
        pnlCentral.add(btnHacerCompra);
        pnlCentral.add(btnConsultar);
        pnlCentral.add(btnSalir);
    }
    
    Container cristal;
    private final JPanel pnlSuperior;
    private final JPanel pnlCentral;
    private final JButton btnAgregar;
    private final JButton btnEliminar;
    private final JButton btnActualizar;
    private final JButton btnHacerCompra;
    private final JButton btnConsultar;
    private final JButton btnSalir;

    private void sizeBotones(JButton[] botones) {
        for(JButton b: botones){
            b.setMinimumSize(new Dimension(20,20));
            b.setMaximumSize(new Dimension(180,90));
            b.setPreferredSize(new Dimension(140, 70));
        }
    }
    
    
}
