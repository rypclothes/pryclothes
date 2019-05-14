package JFrames;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPListaPrendas;
import bbdd.BD_Diseño;
import modelos.Diseño;
import modelos.Reclamacion;
import modelos.Venta;
public class JFMenuCatalogoCompras extends JFrame{
	private JList <Diseño> list;
	private BD_Diseño bdd=new BD_Diseño();
	public JFMenuCatalogoCompras(String factura,String cod_cliente,String categoria,Vector<Venta>carrito) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle(categoria);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 415);
		getContentPane().setLayout(null);
		
		JPListaPrendas jplista=new JPListaPrendas(categoria);
		jplista.setBounds(12, 13, 441, 342);
		getContentPane().add(jplista);
		
		list = new JList <Diseño> (bdd.listadoPrendasCat(categoria));
		list.setBounds(12, 13, 441, 342);
		jplista.add(list);
		
		
	}
	
}
