package JFrames;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import bbdd.BD_Clientes;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFCambiarDatosCliente extends JFrame{
	private JTextField textField;
	private BD_Usuario bdu = new BD_Usuario();
	private BD_Clientes bdc = new BD_Clientes();
	
	public JFCambiarDatosCliente() {
		// TODO Auto-generated constructor stub
	}
	public JFCambiarDatosCliente(String cod,String campo,String nombre) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Cambiar "+campo);
		setBounds(506, 100, 454, 161);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(29, 52, 378, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblInserteElNuevo = new JLabel("Inserte el nuevo dato para modificar su "+campo);
		lblInserteElNuevo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserteElNuevo.setBounds(29, 13, 378, 26);
		getContentPane().add(lblInserteElNuevo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(campo.equalsIgnoreCase("num_tarjeta")||campo.equalsIgnoreCase("direccion")) {
					if(bdc.modificarCampoCliente(cod, campo, textField.getText())) {
						JOptionPane.showMessageDialog(null, "Datos cambiados correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					
					if(bdu.modificarCampoUsuario(cod, campo, textField.getText())) {
						JOptionPane.showMessageDialog(null, "Datos cambiados correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				JFInfoCliente jfinf;
				try {
					jfinf = new JFInfoCliente(nombre);
					jfinf.setVisible(true);
					dispose();
				} catch (DatosIntroducidosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
			}
		});
		btnAceptar.setBounds(68, 87, 97, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(258, 87, 97, 25);
		getContentPane().add(btnCancelar);
		
		
		
	}
	
}
