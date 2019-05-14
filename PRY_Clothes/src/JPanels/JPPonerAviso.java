package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Aviso;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class JPPonerAviso extends JPanel {
	private JTextField textField;
	private JTextArea textArea = new JTextArea();

	public JPPonerAviso() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Aviso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 260, 188);
		initialize();
	}
	
	public void initialize() {		
		JLabel lblCodigoEmpleado = new JLabel("Codigo empleado");
		lblCodigoEmpleado.setBounds(12, 26, 122, 16);
		add(lblCodigoEmpleado);
		
		textField = new JTextField();
		textField.setBounds(129, 23, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Motivo");
		lblNewLabel.setBounds(12, 55, 56, 16);
		add(lblNewLabel);
		
		textArea.setBounds(12, 84, 233, 91);
		add(textArea);
	}
	
	public Aviso getDatos() {
		return new Aviso(textField.getText(), textArea.getText());
	}
}
