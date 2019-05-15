package JFrames;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPCarrito;
import JPanels.JPListaPrendas;
import bbdd.BD_Compras;
import bbdd.BD_Diseño;
import bbdd.BD_Ventas;
import modelos.Diseño;
import modelos.Reclamacion;
import modelos.Venta;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFMenuCatalogoCompras extends JFrame{
	private JList <Diseño> list;
	private JList <Venta> lista;
	private Venta producto;
	private BD_Diseño bdd=new BD_Diseño();
	private Vector<Venta>tcarrito=new Vector<Venta>();
	private BD_Ventas bdv=new BD_Ventas();
	private BD_Compras bdc=new BD_Compras();
	public JFMenuCatalogoCompras(String factura,String cod_cliente,String categoria,Vector<Venta>carrito) {
		tcarrito=carrito;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle(categoria);
		setBounds(100, 100, 843, 470);
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
		
		if(tcarrito!=null) {
			for(int i=0;i<tcarrito.size();i++) {
			modelo.addElement(tcarrito.get(i));
		}
			
		}
		JButton btnAadirAlCarrito = new JButton("A\u00F1adir al carrito");
		btnAadirAlCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				modelo.addElement(producto);
				tcarrito.add(producto);
				
			}
		});
		btnAadirAlCarrito.setBounds(60, 373, 145, 25);
		getContentPane().add(btnAadirAlCarrito);
		
		JButton btnRealizarCompra = new JButton("Realizar Compra");
		btnRealizarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				
			}
		});
		btnRealizarCompra.setBounds(578, 373, 136, 25);
		getContentPane().add(btnRealizarCompra);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFMenuCatalogo jfme=new JFMenuCatalogo(cod_cliente,factura);
				jfme.setVisible(true);
				jfme.actualizarCarrito(tcarrito);
				dispose();
			}
		});
		btnAtras.setBounds(323, 373, 97, 25);
		getContentPane().add(btnAtras);
		
		
	}
}
