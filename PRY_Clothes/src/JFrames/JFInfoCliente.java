package JFrames;

import java.awt.Toolkit;

import javax.swing.JFrame;

import modelos.Cliente;
import modelos.Usuario;
import javax.swing.JTextPane;

import bbdd.BD_Clientes;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class JFInfoCliente extends JFrame{
	private BD_Usuario bdu = new BD_Usuario();
	private BD_Clientes bdc = new BD_Clientes();
	private Cliente cli;
	
	public JFInfoCliente(String nombre) throws DatosIntroducidosException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Mi Perfil");
		setBounds(506, 100, 338, 316);
		getContentPane().setLayout(null);
		
		
		
		cli=bdu.buscarClienteDatos(nombre);
		
		JLabel lblNombre = new JLabel("Nombre: "+cli.getNombre());
		lblNombre.setBounds(12, 22, 173, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: "+cli.getContraseña());
		lblContrasea.setBounds(12, 57, 173, 16);
		getContentPane().add(lblContrasea);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono: "+cli.getTelefono());
		lblTelfono.setBounds(12, 92, 173, 16);
		getContentPane().add(lblTelfono);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta:"+cli.getFechaAlta());
		lblFechaDeAlta.setBounds(12, 127, 194, 16);
		getContentPane().add(lblFechaDeAlta);
		
		JLabel lblNumeroDeTarjeta = new JLabel("Numero de Tarjeta:"+cli.getNumTarjeta());
		lblNumeroDeTarjeta.setBounds(8, 160, 194, 16);
		getContentPane().add(lblNumeroDeTarjeta);
		
		JLabel lblDireccion = new JLabel("Direccion: "+cli.getDireccion());
		lblDireccion.setBounds(8, 195, 173, 16);
		getContentPane().add(lblDireccion);
	
		
		
		JButton button = new JButton("Cambiar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				clickCambiar(cli.getCodigo(),"contraseña");
				
			}
		});
		button.setBounds(197, 50, 97, 25);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cambiar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				clickCambiar(cli.getCodigo(),"telefono");
				
			}
		});
		button_1.setBounds(197, 85, 97, 25);
		getContentPane().add(button_1);
		
		JButton button_3 = new JButton("Cambiar");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				clickCambiar(cli.getCodigo(),"num_tarjeta");
				
			}
		});
		button_3.setBounds(197, 156, 97, 25);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Cambiar");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				clickCambiar(cli.getCodigo(),"direccion");
				repaint();
			}
		});
		button_4.setBounds(197, 191, 97, 25);
		getContentPane().add(button_4);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				dispose();
				
			}
		});
		btnSalir.setBounds(105, 231, 97, 25);
		getContentPane().add(btnSalir);
		
		
		
	}
	
	public JFInfoCliente() {
		// TODO Auto-generated constructor stub
	}

	public void clickCambiar(String cod, String campo) {
		
		
		JFCambiarDatosCliente JFCmbDClientes=new JFCambiarDatosCliente(cod,campo,cli.getNombre());
		JFCmbDClientes.setVisible(true);
		dispose();
		
	}
}
