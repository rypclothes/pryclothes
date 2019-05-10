package JPanels;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelos.Empleado;

public class JPContratarEmple extends JPanel {
	private JTextField JTFNombre;
	private JTextField JTFTelefono;
	private JTextField JTFFuncion;
	private JLabel lblContrasena;
	private JTextField JTFContrasena;
	private JLabel lblRol;
	private JTextField JTFRol;
	private JLabel lblSalario;
	private JTextField JTFSalario;


	public JPContratarEmple() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contratar Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 334, 220);
		initialize();
	}
			
	public void initialize() {
					JLabel lblNombre = new JLabel("Nombre");
					lblNombre.setBounds(30, 30, 120, 25);
					add(lblNombre);
					
					JTFNombre = new JTextField();
					JTFNombre.setBounds(150, 30, 147, 25);
					add(JTFNombre);
					JTFNombre.setColumns(10);
					
					lblContrasena = new JLabel("Contrase\u00F1a");
					lblContrasena.setBounds(30, 60, 100, 25);
					add(lblContrasena);
					
					JTFContrasena = new JTextField();
					JTFContrasena.setBounds(150, 60, 147, 25);
					add(JTFContrasena);
					JTFContrasena.setColumns(10);
					
					JLabel lblTelfono = new JLabel("Tel\u00E9fono");
					lblTelfono.setBounds(30, 90, 100, 25);
					add(lblTelfono);
					
					JTFTelefono = new JTextField();
					JTFTelefono.setBounds(150, 90, 147, 25);
					add(JTFTelefono);
					JTFTelefono.setColumns(10);
					
					JLabel lblFuncin = new JLabel("Funci\u00F3n");
					lblFuncin.setBounds(30, 150, 100, 25);
					add(lblFuncin);
					
					JTFFuncion = new JTextField();
					JTFFuncion.setBounds(150, 150, 147, 25);
					add(JTFFuncion);
					JTFFuncion.setColumns(10);
					
					lblRol = new JLabel("Rol");
					lblRol.setBounds(30, 120, 100, 25);
					add(lblRol);
					
					JTFRol = new JTextField();
					JTFRol.setBounds(150, 120, 147, 25);
					add(JTFRol);
					JTFRol.setColumns(10);
					
					lblSalario = new JLabel("Salario");
					lblSalario.setBounds(30, 180, 100, 25);
					add(lblSalario);
					
					JTFSalario = new JTextField();
					JTFSalario.setBounds(150, 180, 147, 25);
					add(JTFSalario);
			JTFSalario.setColumns(10);
	}
			
	public Empleado getDatos() {
		return new Empleado(JTFContrasena.getText(), JTFNombre.getText(), JTFTelefono.getText(), JTFRol.getText(), JTFFuncion.getText(), Double.parseDouble(JTFSalario.getText()));
	}
}
