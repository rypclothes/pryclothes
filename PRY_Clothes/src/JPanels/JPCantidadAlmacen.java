package JPanels;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Diseño;

import javax.swing.JButton;

/**
 * 
 * @author Pablo
 *
 */

public class JPCantidadAlmacen extends JPanel {
	private JTextField textField;

	public JPCantidadAlmacen() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Numero de prendas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(0, 0, 206, 68);
		setLayout(null);
		initialize();
	}
	
	public void initialize() {
		JLabel LBLCantidad = new JLabel("Cantidad");
		LBLCantidad.setBounds(10, 29, 100, 14);
		add(LBLCantidad);
		
		textField = new JTextField();
		textField.setBounds(109, 26, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
	
	public void setDatos(Diseño d) {
		textField.setText(String.valueOf(d.getCantidad()));
	}
	
	public void setInhabilitado() {
		for (Component c :this.getComponents()) 
			c.setEnabled(false);
	}
}
