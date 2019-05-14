package JFrames;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPDatosCompra;
import JPanels.JPListaCompras;
import JPanels.JPListaReclamaciones;
import bbdd.BD_Compras;
import modelos.Reclamacion;
import modelos.Compra;
import javax.swing.JButton;

public class JFMisCompras extends JFrame {
	private BD_Compras bdc = new BD_Compras();
	
	public JFMisCompras(String cod_cliente) {
		JList<Compra> list;
		setTitle("Mis Compras");
		getContentPane().setLayout(null);
		
		
		//Panel lista de las compras
		JPListaCompras jpl = new JPListaCompras();
		jpl.setSize(176, 255);
		jpl.setLocation(12, 13);
		getContentPane().add(jpl);
		//Panel de datos de la compra
				JPDatosCompra jpd=new JPDatosCompra();
				jpd.setBounds(209, 13, 262, 255);
				getContentPane().add(jpd);
				//lista
				list = new JList <Compra> (bdc.listadoCompras(cod_cliente));
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						jpd.setDatos(list.getSelectedValue());
					}
				});
				list.setBounds(10, 21, 156, 223);
				jpl.add(list);
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(170, 279, 97, 25);
		getContentPane().add(btnSalir);
		
		
		
		
		
	}
}
