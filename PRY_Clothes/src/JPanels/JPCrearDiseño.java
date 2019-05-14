package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Diseño;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Pablo
 *
 */

public class JPCrearDiseño extends JPanel {
	private JTextField JTFDescripcion;
	private JTextField JTFPrecio;
	private JTextField JTFCategoria;
	private JTextField JTFCantidad;

	public JPCrearDiseño() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear diseño", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(0, 0, 259, 146);
		setLayout(null);
		initialize();
	}
	
	public void initialize() {
		JLabel LBLDescripcion = new JLabel("Descripcion");
		LBLDescripcion.setBounds(23, 27, 72, 16);
		add(LBLDescripcion);
		
		JTFDescripcion = new JTextField();
		JTFDescripcion.setBounds(131, 24, 116, 22);
		add(JTFDescripcion);
		JTFDescripcion.setColumns(10);
		
		JLabel LBLPrecio = new JLabel("Precio");
		LBLPrecio.setBounds(23, 69, 56, 16);
		add(LBLPrecio);
		
		JLabel LBLCategoria = new JLabel("Categoria");
		LBLCategoria.setBounds(23, 111, 56, 16);
		add(LBLCategoria);
		
		JTFPrecio = new JTextField();
		JTFPrecio.setBounds(131, 66, 116, 22);
		add(JTFPrecio);
		JTFPrecio.setColumns(10);
		
		JTFCategoria = new JTextField();
		JTFCategoria.setBounds(131, 108, 116, 22);
		add(JTFCategoria);
		JTFCategoria.setColumns(10);
		

	}
	
	public Diseño getDatos() {
		return new Diseño(JTFDescripcion.getText(), Double.parseDouble(JTFPrecio.getText()), JTFCategoria.getText());
	}
	
	public void limpiarDatos() {
		JTFDescripcion.setText("");
		JTFPrecio.setText("");
		JTFCategoria.setText("");
	}
	
	public boolean validarDatos() {
		if (JTFDescripcion.getText().equals("") || JTFPrecio.getText().equals("") || JTFCategoria.getText().equals(""))
			return false;
		return true;
	}
}
