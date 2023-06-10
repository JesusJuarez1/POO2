package mx.edu.uaz.ingsoft.poo2.Proyecto.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import mx.edu.uaz.ingsoft.poo2.Proyecto.constantes.Constantes;
import mx.edu.uaz.ingsoft.poo2.Proyecto.logica.Compra;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ClienteService;
import mx.edu.uaz.ingsoft.poo2.Proyecto.servicios.ProductoService;

public class VentanaCompra extends JFrame {
    static ProductoService productos;
    static ClienteService clientes;
    static{
        productos = new ProductoService();
        clientes = new ClienteService();
    }
    public VentanaCompra(){
        super("Hacer Compra");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        String[] colum ={"Nombre","Precio","seleccion"};
        DefaultTableModel modelo = new DefaultTableModel(null,colum);
        scroll = new JScrollPane();
        
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        pnlISeparacion = new JPanel();
        pnlISeparacion.setLayout(new BorderLayout());
        pnlDSeparacion = new JPanel();
        pnlDSeparacion.setLayout(new BorderLayout());
        pnlSuperior = new JPanel();
        pnlSuperior.setLayout(new BorderLayout());
        pnlInferior = new JPanel();
        pnlInferior.setLayout(new GridLayout(1,2));
        
        cristal.add(pnlDSeparacion, BorderLayout.EAST);
        cristal.add(pnlISeparacion, BorderLayout.WEST);
        
        lbProductos = new JLabel("Selecciona los productos");
        lbCliente = new JLabel("Nombre del Cliente: ");
        tfCNombre = new JTextField();
        tfCNombre.setColumns(10);
        btnComprar = new JButton("Comprar");
        btnCancelar = new JButton("Cancelar");
        
        tabla = new JTable();
        
        tabla.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        scroll.setViewportView(tabla);
        
        crearTabla(tabla,modelo,listaValida());
        
        btnComprar.addActionListener((ActionEvent e)->{
            String camposVacios = Constantes.CAMPOS_VACIOS;
            if(tfCNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, camposVacios);
            }else{
                List<Productos> prod = obtenerListaCompra(tabla);
                Cliente c = new Cliente();
                c.setNombre(tfCNombre.getText());
                c = clientes.add(c);
                Compra compra = new Compra();
                Ticket unTicket = compra.hacerComprar(prod);
                JOptionPane.showMessageDialog(null,"Compra realizada \n"+unTicket.toString()+"Cliente: "+c.getNombre());
                dispose();
            }
            
        });
        
        btnCancelar.addActionListener((ActionEvent e)->{
            dispose();
        });
        
        pnlISeparacion.add(lbProductos, BorderLayout.PAGE_START);
        pnlISeparacion.add(scroll, BorderLayout.CENTER);
        pnlDSeparacion.add(pnlSuperior, BorderLayout.PAGE_START);
        pnlSuperior.add(lbCliente, BorderLayout.WEST);
        pnlSuperior.add(tfCNombre, BorderLayout.EAST);
        pnlDSeparacion.add(pnlInferior, BorderLayout.CENTER);
        pnlInferior.add(btnCancelar);
        pnlInferior.add(btnComprar);
        
    }
    
    Container cristal;
    private final JPanel pnlISeparacion;
    private final JPanel pnlDSeparacion;
    private final JPanel pnlSuperior;
    private final JPanel pnlInferior;
    private final JButton btnComprar;
    private final JButton btnCancelar;
    private final JLabel lbProductos;
    private final JLabel lbCliente;
    private final JTextField tfCNombre;
    private final JTable tabla;
    private final JScrollPane scroll;
    
    public void crearTabla(JTable tabla,DefaultTableModel modelo,List<Productos> listaProduc){
        //Object[][] matriz = new Object[listaBox.size()][2];
        Object[] o = new Object[2];
        for(int i=0; i < listaProduc.size(); i++){
            o[0] = listaProduc.get(i).getNombre();
            o[1] = ""+listaProduc.get(i).getPrecio();
            modelo.addRow(o);
        }
        tabla.setModel(modelo);
        addCheckBox(2, tabla);
    }
    
    public void addCheckBox(int column, JTable table){
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }
    
    public boolean IsSelected(int row, int column, JTable table){    
        return table.getValueAt(row, column) != null;                       
    }
    
    public List<Productos> obtenerListaCompra(JTable tabla){
        List<Productos> l = listaValida();
        List<Productos> lista = new ArrayList<Productos>();
        for(int i=0; i<tabla.getRowCount(); i++){
            if(IsSelected(i, 2, tabla)){
                lista.add(l.get(i));
            }
        }
        if(lista.isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Selecciona almenos un producto");
            removeAll();
        }
        return lista;
    }
    
    public List<Productos> listaValida(){
        List<Productos> listaProduc= productos.findAll();
        for(int i=0; i<listaProduc.size(); i++){
            if(listaProduc.get(i).getCantidad() < 1){
                listaProduc.remove(i);
            }
        }
        if(listaProduc.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay productos, o tienen un inventario de 0!!! \n"+"Agrega inventario modificando los productos");
            dispose();
        }
        return listaProduc;
    }
}
