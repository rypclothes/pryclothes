package JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JPanels.JPBotones;
import JPanels.JPLogin;
import bbdd.BD_Conector;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;
import modelos.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class JFLogin extends JFrame{
	private JPLogin panelAlumnos;
	private JPBotones panelBotones;
	private BD_Usuario bdu = new BD_Usuario();
	
	public JFLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFLogin.class.getResource("/imagenes/rypclothes.png")));
		setTitle("PRY CLOTHES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 172);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		initialize();
	}
	
	public void initialize() {
		//Panel introduccion de datos
		panelAlumnos = new JPLogin();
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
								if(tipo.equals("Administrativo")) {
									JFEmpleadoAdministracion jempleA = new JFEmpleadoAdministracion(tipo);
									jempleA.setVisible(true);
								}else {
									if(tipo.equals("Diseño")) {
										JFEmpleadoDiseño jempleD = new JFEmpleadoDiseño(tipo);
										jempleD.setVisible(true);
									}else {
										if(tipo.equals("Logistica")) {
											JFEmpleadoLogistica jempleL = new JFEmpleadoLogistica(tipo);
											jempleL.setVisible(true);
										}
									}
								}
							}
						dispose();			
					}		
				}catch(DatosIntroducidosException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		BTNAceptar.setBounds(25, 107, 120, 23);
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
		BTNRegistrarse.setBounds(160, 107, 120, 23);
		getContentPane().add(BTNRegistrarse);
	}
}

