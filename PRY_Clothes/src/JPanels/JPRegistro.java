package JPanels;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Cliente;

import javax.swing.JPasswordField;

public class JPRegistro extends JPanel {
	private JTextField JTFNombreUsuario;
	private JPasswordField JTFContraseña;
	private JTextField JTFTelefono;
	private JTextField JTFNumTarjeta;
	private JLabel LBLDireccion;
	private JTextField JTFDireccion;

	public JPRegistro() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 263, 200);
		initialize();
	}
	
	public void initialize() {
		JLabel LBLNombreUsuario = new JLabel("Nombre Usuario");
		LBLNombreUsuario.setBounds(12, 25, 103, 16);
		add(LBLNombreUsuario);
		
		JTFNombreUsuario = new JTextField();
		JTFNombreUsuario.setBounds(127, 22, 116, 22);
		add(JTFNombreUsuario);
		JTFNombreUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(12, 63, 72, 16);
		add(lblContraseña);
		
		JTFContraseña = new JPasswordField();
		JTFContraseña.setBounds(127, 60, 116, 22);
		add(JTFContraseña);
		
		JLabel LBLTelfono = new JLabel("Tel\u00E9fono");
		LBLTelfono.setBounds(12, 98, 56, 16);
		add(LBLTelfono);
		
		JTFTelefono = new JTextField();
		JTFTelefono.setBounds(127, 95, 116, 22);
		add(JTFTelefono);
		JTFTelefono.setColumns(10);
		
		JLabel lblNmeroTarjeta = new JLabel("N\u00FAmero Tarjeta");
		lblNmeroTarjeta.setBounds(12, 135, 103, 16);
		add(lblNmeroTarjeta);
		
		JTFNumTarjeta = new JTextField();
		JTFNumTarjeta.setBounds(127, 132, 116, 22);
		add(JTFNumTarjeta);
		JTFNumTarjeta.setColumns(10);
		
		LBLDireccion = new JLabel("Direccion");
		LBLDireccion.setBounds(12, 171, 56, 16);
		add(LBLDireccion);
		
		JTFDireccion = new JTextField();
		JTFDireccion.setBounds(127, 167, 116, 22);
		add(JTFDireccion);
		JTFDireccion.setColumns(10);
	}
	
	public Cliente getDatos() {
		return new Cliente(JTFContraseña.getText(), JTFNombreUsuario.getText(), JTFTelefono.getText(), Long.parseLong(JTFNumTarjeta.getText()), JTFDireccion.getText());
	}
}
