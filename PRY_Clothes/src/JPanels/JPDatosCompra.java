package JPanels;
import javax.swing.JPanel;

import bbdd.BD_Ventas;
import modelos.Compra;
import modelos.Venta;
import modelos.Reclamacion;
import javax.swing.JList;
public class JPDatosCompra extends JPanel{
	private BD_Ventas bdv = new BD_Ventas();
	
	public JPDatosCompra() {
		
		setLayout(null);
		setBounds(209, 13, 262, 255);
		
	
		
	}
	public void setDatos(Compra co) {
		JList<Venta> list = new JList<Venta>(bdv.listadoVentas(co.getFactura()));
		list.setBounds(0, 0, 262, 255);
		add(list);
	}
}
