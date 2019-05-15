package JFrames;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPCarrito;
import JPanels.JPListaPrendas;
import bbdd.BD_Compras;
import bbdd.BD_Diseño;
import bbdd.BD_Ventas;
import exceptions.DatosIntroducidosException;
import modelos.Compra;
import modelos.Diseño;
import modelos.Reclamacion;
import modelos.Venta;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class JFMenuCatalogoCompras extends JFrame{
	private JList <Diseño> list;
	private JList <Venta> lista;
	private Venta producto;
	private JComboBox comboBox; 
	private BD_Diseño bdd=new BD_Diseño();
	private Vector<Venta>tcarrito=new Vector<Venta>();
	private BD_Ventas bdv=new BD_Ventas();
	private BD_Compras bdc=new BD_Compras();
	private int precioT;
	private String[]cantidades={"1","2","3","4","5","6","7","8","9","10"};
	public JFMenuCatalogoCompras(String factura,String cod_cliente,String categoria,Vector<Venta>carrito) {
		tcarrito=carrito;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle(categoria);
		setBounds(100, 100, 843, 511);
		getContentPane().setLayout(null);
		
		JPListaPrendas jplista=new JPListaPrendas(categoria);
		jplista.setBounds(12, 13, 441, 342);
		getContentPane().add(jplista);
		
		DefaultListModel<Venta> modelo = new DefaultListModel();
		
		
		list = new JList <Diseño> (bdd.listadoPrendasCat(categoria));
		list.setBounds(10, 20, 420, 310);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				producto=new Venta(list.getSelectedValue().getCodDiseño(),factura,1,(int)list.getSelectedValue().getPrecio());
			}
		});
		jplista.add(list);
		
		JPCarrito listaCarrito=new JPCarrito();
		listaCarrito.setSize(327, 342);
		listaCarrito.setLocation(486, 13);
		getContentPane().add(listaCarrito);
		
		
		lista = new JList<Venta> (modelo);
		lista.setBounds(12, 26, 303, 264);
		listaCarrito.add(lista);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(136, 303, 63, 26);
		listaCarrito.add(textPane);
		
		if(tcarrito!=null) {
			for(int i=0;i<tcarrito.size();i++) {
			precioT+=tcarrito.get(i).getPrecio_venta();	
			modelo.addElement(tcarrito.get(i));
		}
			textPane.setText(precioT+" euros");
		}
		
		JButton btnAadirAlCarrito = new JButton("A\u00F1adir al carrito");
		btnAadirAlCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				producto=new Venta(list.getSelectedValue().getCodDiseño(),factura,Integer.parseInt((String) comboBox.getSelectedItem()),(int)list.getSelectedValue().getPrecio());
				modelo.addElement(producto);
				precioT+=producto.getPrecio_venta();
				textPane.setText(precioT+" euros");
			
			}
		});
		btnAadirAlCarrito.setBounds(60, 415, 145, 25);
		getContentPane().add(btnAadirAlCarrito);
		
		JButton btnRealizarCompra = new JButton("Realizar Compra");
		btnRealizarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int contPrendas=0;
				Vector<Venta>ncarrito=new Vector<Venta>();
				for(int i=0;i<modelo.size();i++) {
					contPrendas+=modelo.get(i).getCantidad();
					ncarrito.add(modelo.get(i));
				}
				
				Compra co=new Compra(precioT,contPrendas,cod_cliente);
				try {
					if(bdc.darAltaCompra(co)!=-1)
						JOptionPane.showMessageDialog(null, "Compra realizada con exito", "EXITO", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				} catch (HeadlessException | DatosIntroducidosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0;i<ncarrito.size();i++) {
					try {
						Venta ve=new Venta(ncarrito.get(i).getCod_diseño(),factura, ncarrito.get(i).getCantidad(), (ncarrito.get(i).getPrecio_venta()/ncarrito.get(i).getCantidad()));
						bdv.añadirVenta(ve);
					} catch (DatosIntroducidosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						dispose();
					}
				}
				
				
				dispose();
			}
		});
		btnRealizarCompra.setBounds(578, 415, 136, 25);
		getContentPane().add(btnRealizarCompra);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Vector<Venta>ncarrito=new Vector<Venta>();
				for(int i=0;i<modelo.size();i++) {
					ncarrito.add(modelo.get(i));
				}
				
				JFMenuCatalogo jfme=new JFMenuCatalogo(cod_cliente,factura);
				jfme.setVisible(true);
				jfme.actualizarCarrito(ncarrito);
				dispose();
			}
		});
		btnAtras.setBounds(325, 415, 97, 25);
		getContentPane().add(btnAtras);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(12, 386, 97, 16);
		getContentPane().add(lblCantidad);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(cantidades));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(78, 380, 88, 22);
		getContentPane().add(comboBox);
		
		
	}
}
