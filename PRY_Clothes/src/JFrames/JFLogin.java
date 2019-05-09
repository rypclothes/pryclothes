package JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JPanels.JPBotones;
import JPanels.JPDatos;
import bbdd.BD_Conector;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;
import modelos.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFLogin extends JFrame{
	private JPDatos panelAlumnos;
	private JPBotones panelBotones;
	private BD_Usuario bdu = new BD_Usuario();
	
	public JFLogin() {
		setTitle("PRY CLOTHES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 183);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		initialize();
	}
	
	public void initialize() {
		//Panel introduccion de datos
		panelAlumnos = new JPDatos();
		getContentPane().add(panelAlumnos);
		
		//Panel botones
		panelBotones = new JPBotones();	
		JButton BTNAceptar = new JButton("Inicia Sesi\u00F3n");
		BTNAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Usuario u=panelAlumnos.getDatos();
				String tipo;
				try {
					tipo=bdu.inicioSesion(u);
					if (tipo==null) {
						JOptionPane.showMessageDialog(null, "Credenciales inválidas", "ERROR", JOptionPane.ERROR_MESSAGE);			
					}else {
						if (tipo.equals("Cliente")) {
							JFCliente JFcliente=new JFCliente();
							JFcliente.setVisible(true);
						}else
							if (tipo.equals("Administrador")) {
								JFAdmin JFadmin=new JFAdmin();
								JFadmin.setVisible(true);
							}
							else {
								JFEmpleado JFemple=new JFEmpleado();
								JFemple.setVisible(true);
							}
						dispose();			
					}		
				}catch(DatosIntroducidosException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		BTNAceptar.setBounds(28, 116, 120, 23);
		getContentPane().add(BTNAceptar);
		
		JButton BTNRegistrarse = new JButton("Reg\u00EDstrate");
		BTNRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFRegistro JFreg = new JFRegistro();
				JFreg.setVisible(true);
				dispose();
			}
		});
		BTNRegistrarse.setBounds(160, 116, 120, 23);
		getContentPane().add(BTNRegistrarse);
	}
}

