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
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ProductoService;

public class VentanaAgregar extends JFrame {
    static ProductoService productos;
    static{
        productos = new ProductoService();
    }
    
    public VentanaAgregar(){
        super("Agregar Productos");
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
        
        btnAgregar = new JButton("Agregar");
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
        
        btnAgregar.addActionListener((ActionEvent e)->{
            String camposVacios = Constantes.CAMPOS_VACIOS;
            String camposInvalidos = Constantes.CAMPOS_INCORRECTOS;
            if("".equals(tfNombre.getText())){
                error("No dejes campos vacios");
            }else if(isDouble(tfPrecio.getText()) == false && isNumeric(tfPrecio.getText()) == false){
                error("El precio tiene que ser un numero entero o un numero con decimales");
            }else if(isNumeric(tfInventario.getText()) == false){
                error("Incerta valores validos");
            }else{
                Productos unProducto = crearProducto(tfNombre.getText(), tfPrecio.getText(), tfInventario.getText());
                Productos p = productos.add(unProducto);
                JOptionPane.showMessageDialog(null, "Prodcuto agregado \n"+p.toString());
                dispose();
            }
        });
        
        btnCancelar.addActionListener((ActionEvent e)->{
            dispose();
        });
        
        pnlSuperior.add(lbNombre);
        pnlSuperior.add(tfNombre);
        pnlSuperior2.add(lbPrecio);
        pnlSuperior2.add(tfPrecio);
        pnlCentral2.add(lbInventario);
        pnlCentral2.add(tfInventario);
        pnlInferior.add(btnAgregar);
        pnlInferior.add(btnCancelar);
        
    }
    
    Container cristal;
    private final JPanel pnlSuperior;
    private final JPanel pnlSuperior2;
    private final JPanel pnlCentral;
    private final JPanel pnlCentral2;
    private final JPanel pnlInferior;
    private final JButton btnAgregar;
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
    
    public Productos crearProducto(String nombre, String precio, String inventario){
        Productos unProducto = new Productos();
        unProducto.setNombre(nombre);
        unProducto.setPrecio(Double.parseDouble(precio));
        unProducto.setCantidad(Integer.parseInt(inventario));
        return unProducto;
    }
    
    public void error(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
                tfNombre.setText("");
                tfPrecio.setText("");
                tfInventario.setText("");
    }
}
