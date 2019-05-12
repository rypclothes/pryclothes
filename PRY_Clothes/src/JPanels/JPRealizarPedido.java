package JPanels;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Dise�o;

/**
 * 
 * @author Pablo
 *
 */

public class JPRealizarPedido extends JPanel {
	private JTextField JTFCodDise�o;
	private JTextField JTFCantidad;

	public JPRealizarPedido() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hacer pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 213, 94);
		initialize();
	}
	
	public void initialize() {
		JLabel LBLCodDise�o = new JLabel("Codigo dise\u00F1o");
		LBLCodDise�o.setBounds(24, 27, 82, 14);
		add(LBLCodDise�o);
		
		JLabel LBLCantidad = new JLabel("Cantidad");
		LBLCantidad.setBounds(24, 66, 60, 14);
		add(LBLCantidad);
		
		JTFCodDise�o = new JTextField();
		JTFCodDise�o.setBounds(116, 24, 86, 20);
		add(JTFCodDise�o);
		JTFCodDise�o.setColumns(10);
		
		JTFCantidad = new JTextField();
		JTFCantidad.setBounds(116, 63, 86, 20);
		add(JTFCantidad);
		JTFCantidad.setColumns(10);
	}
	
	public Dise�o getDatos() {
		return new Dise�o(Integer.parseInt(JTFCantidad.getText()), JTFCodDise�o.getText());
	}
}
