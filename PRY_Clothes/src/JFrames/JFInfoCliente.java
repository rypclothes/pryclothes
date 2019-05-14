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

public class JFInfoCliente extends JFrame{
	private BD_Usuario bdu = new BD_Usuario();
	private BD_Clientes bdc = new BD_Clientes();
	private JTextField txtNombre;
	private JTextField txtContrasea;
	private JTextField txtTelefono;
	private Cliente cli;
	
	public JFInfoCliente(String nombre) throws DatosIntroducidosException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Mi Perfil");
		setBounds(506, 100, 338, 316);
		getContentPane().setLayout(null);
		
		cli=bdu.buscarClienteDatos(nombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre: "+cli.getNombre());
		txtNombre.setBounds(12, 13, 153, 22);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("Contrase\u00F1a: "+cli.getContraseña());
		txtContrasea.setBounds(12, 51, 153, 22);
		getContentPane().add(txtContrasea);
		txtContrasea.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono: "+cli.getTelefono());
		txtTelefono.setBounds(12, 86, 153, 22);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JTextPane txtpnFechaDeAlta = new JTextPane();
		txtpnFechaDeAlta.setText("Fecha de Alta: "+cli.getFechaAlta());
		txtpnFechaDeAlta.setBounds(12, 121, 153, 22);
		getContentPane().add(txtpnFechaDeAlta);
		
		JTextPane txtpnNumeroDeTarjeta = new JTextPane();
		txtpnNumeroDeTarjeta.setText("Numero de Tarjeta: "+cli.getNumTarjeta());
		txtpnNumeroDeTarjeta.setBounds(12, 156, 153, 22);
		getContentPane().add(txtpnNumeroDeTarjeta);
		
		JTextPane txtpnDireccion = new JTextPane();
		txtpnDireccion.setText("Direccion: "+cli.getDireccion());
		txtpnDireccion.setBounds(12, 191, 153, 22);
		getContentPane().add(txtpnDireccion);
		
		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				clickCambiar(cli.getCodigo(),"nombre");
				
			}
		});
		btnNewButton.setBounds(197, 12, 97, 25);
		getContentPane().add(btnNewButton);
		
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
	
	public static void clickCambiar(String cod, String campo) {
		
		JFCambiarDatosCliente JFCmbDClientes=new JFCambiarDatosCliente(cod,campo);
		
	}
	
}
