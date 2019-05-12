package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Incidencia;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 * 
 * @author Pablo
 *
 */

public class JPCrearIncidencia extends JPanel {
	private JTextField JTFCodEmple;
	private JTextField JTFTipo;

	public JPCrearIncidencia() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear Incidencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(0, 0, 257, 100);
		setLayout(null);
		initialize();
	}
	
	public void initialize() {
		JLabel LBLCodEmple = new JLabel("Codigo empleado");
		LBLCodEmple.setBounds(12, 31, 108, 16);
		add(LBLCodEmple);
		
		JTFCodEmple = new JTextField();
		JTFCodEmple.setBounds(131, 28, 116, 22);
		add(JTFCodEmple);
		JTFCodEmple.setColumns(10);
		
		JLabel LBLTipo = new JLabel("Tipo incidencia");
		LBLTipo.setBounds(12, 69, 90, 16);
		add(LBLTipo);
		
		JTFTipo = new JTextField();
		JTFTipo.setBounds(131, 68, 116, 22);
		add(JTFTipo);
		JTFTipo.setColumns(10);
	}
	
	public Incidencia getDatos() {
		return new Incidencia(JTFCodEmple.getText(), JTFTipo.getText());
	}
}