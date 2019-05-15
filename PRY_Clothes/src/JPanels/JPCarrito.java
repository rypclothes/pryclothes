package JPanels;

import java.awt.Color;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelos.Diseño;
import modelos.Venta;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
public class JPCarrito extends JPanel{
	public JPCarrito(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carro Compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(0, 0, 327, 342);
		setLayout(null);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(68, 303, 85, 26);
		add(lblTotal);
		
	}
	
}
