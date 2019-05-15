package JPanels;
import javax.swing.JPanel;

import javax.swing.JTextField;

import bbdd.BD_Ventas;
import modelos.Compra;
import modelos.Venta;

import java.awt.Color;
import java.util.Vector;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Font;
public class JPDatosCompra extends JPanel{
	private BD_Ventas bdv = new BD_Ventas();
	private JTextField TXFInfo;
	
	public JPDatosCompra() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 451, 244); 
		
		TXFInfo = new JTextField();
		TXFInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TXFInfo.setBounds(12, 23, 427, 208);
		add(TXFInfo);
		TXFInfo.setColumns(10);
	}
	public void setDatos(Compra co) {
		Vector<Venta>listaventas=bdv.listadoVentas(co.getFactura());
		String lista ="";
		for(int i=0;i<listaventas.size();i++) {
			
			lista+="Venta "+i+": "+listaventas.get(i).toString()+"\n";
			
		}
		
		TXFInfo.setText(lista);
	}
}
