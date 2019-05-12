package JPanels;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Diseño;

/**
 * 
 * @author Pablo
 *
 */

public class JPRealizarPedido extends JPanel {
	private JTextField JTFCodDiseño;
	private JTextField JTFCantidad;

	public JPRealizarPedido() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hacer pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 213, 94);
		initialize();
	}
	
	public void initialize() {
		JLabel LBLCodDiseño = new JLabel("Codigo dise\u00F1o");
		LBLCodDiseño.setBounds(24, 27, 82, 14);
		add(LBLCodDiseño);
		
		JLabel LBLCantidad = new JLabel("Cantidad");
		LBLCantidad.setBounds(24, 66, 60, 14);
		add(LBLCantidad);
		
		JTFCodDiseño = new JTextField();
		JTFCodDiseño.setBounds(116, 24, 86, 20);
		add(JTFCodDiseño);
		JTFCodDiseño.setColumns(10);
		
		JTFCantidad = new JTextField();
		JTFCantidad.setBounds(116, 63, 86, 20);
		add(JTFCantidad);
		JTFCantidad.setColumns(10);
	}
	
	public Diseño getDatos() {
		return new Diseño(Integer.parseInt(JTFCantidad.getText()), JTFCodDiseño.getText());
	}
}
