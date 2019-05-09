package JPanels;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelos.Usuario;
import java.awt.Color;

public class JPLogin extends JPanel {
	private JTextField JTFNombreUsuario;
	private JTextField txtTelefono;
	private JPasswordField JTFContraseña;
	
	public JPLogin() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 305, 116);
		initialize();
	}
	
	public void initialize() {
		JLabel JLBLNombreUsu = new JLabel("Nombre Usuario");
		JLBLNombreUsu.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		JLBLNombreUsu.setBounds(20, 33, 91, 14);
		add(JLBLNombreUsu);
		
		JTFNombreUsuario = new JTextField();
		JTFNombreUsuario.setColumns(10);
		JTFNombreUsuario.setBounds(135, 28, 145, 25);
		add(JTFNombreUsuario);
		
		JLabel JLBLPassWD = new JLabel("Contrase\u00F1a");
		JLBLPassWD.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		JLBLPassWD.setBounds(20, 61, 68, 14);
		add(JLBLPassWD);
		
		JTFContraseña = new JPasswordField();
		JTFContraseña.setBounds(135, 56, 145, 25);
		add(JTFContraseña);
	}
	
	public void setDatos(Usuario usu) {
		JTFNombreUsuario.setText(usu.getNombre());
		JTFContraseña.setText(usu.getContraseña());
	}
	
	public Usuario getDatos() {
		return new Usuario(JTFContraseña.getText(),JTFNombreUsuario.getText());
	}
	
	public void setInhabilitado() {
		for (Component c :this.getComponents()) 
			c.setEnabled(false);
	}
}
