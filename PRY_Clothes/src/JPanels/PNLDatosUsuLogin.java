package JPanels;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PNLDatosUsuLogin extends JPanel {
	private JTextField TXFNombreUsuario;
	private JTextField TXFContraseña;
	private BD_Usuario bdu = new BD_Usuario();

	/**
	 * Create the panel.
	 */
	public PNLDatosUsuLogin() {
		setBorder(new TitledBorder(null, "DATOS CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		setBounds(0, 0, 304, 180);
		initialize();
	}
	
	private void initialize() {
		/*Login de usuario*/
		/*Etiqueta y JTF nombre usuario*/
		JLabel lblNombreUsuario = new JLabel("Nombre usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreUsuario.setBounds(24, 43, 145, 16);
		add(lblNombreUsuario);
		
		TXFNombreUsuario = new JTextField();
		TXFNombreUsuario.setBounds(170, 43, 116, 22);
		add(TXFNombreUsuario);
		TXFNombreUsuario.setColumns(10);
		
		/*Etiqueta y JTF contraseña*/
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraseña.setBounds(24, 65, 127, 34);
		add(lblContraseña);
		
		TXFContraseña = new JTextField();
		TXFContraseña.setBounds(170, 73, 116, 22);
		add(TXFContraseña);
		TXFContraseña.setColumns(10);
		
		/*Boton aceptar*/
		
		Panel PNLBotones = new Panel();
		PNLBotones.setBounds(13, 118, 273, 52);
		add(PNLBotones);
		PNLBotones.setLayout(null);
		JButton btnAceptar = new JButton("Aceptar");
		
		/*Inicio de sesion*/
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nomUsu = null;
				nomUsu = TXFNombreUsuario.getText();
				String contraseña = null;
				contraseña = TXFContraseña.getText();
				
				String rol = null;
				
				try {
					rol = bdu.inicioSesion(nomUsu, contraseña);
				} catch (DatosIntroducidosException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAceptar.setBounds(151, 13, 97, 25);
		PNLBotones.add(btnAceptar);
		
		
		JButton btnRegistrate = new JButton("Registrate!");
		btnRegistrate.setBounds(23, 13, 97, 25);
		PNLBotones.add(btnRegistrate);
	}
}
