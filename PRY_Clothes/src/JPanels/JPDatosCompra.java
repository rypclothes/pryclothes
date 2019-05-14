package JPanels;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bbdd.BD_Ventas;
import modelos.Compra;
import modelos.Venta;
import modelos.Reclamacion;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
public class JPDatosCompra extends JPanel{
	private BD_Ventas bdv = new BD_Ventas();
	private JTextField TXFInfo;
	
	public JPDatosCompra() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 263, 244);
		
		TXFInfo = new JTextField();
		TXFInfo.setBounds(12, 23, 239, 208);
		add(TXFInfo);
		TXFInfo.setColumns(10);
	}
	public void setDatos(Compra co) {
		Vector<Venta>listaventas=bdv.listadoVentas(co.getFactura());
		TXFInfo.setText(String.valueOf(listaventas.toString()));
	}
}
