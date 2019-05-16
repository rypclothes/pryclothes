package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import JPanels.JPContratarEmple;
import bbdd.BD_Empleado;
import exceptions.DatosIntroducidosException;
import modelos.Empleado;
import modelos.Usuario;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFContratarEmple extends JFrame {
	
	private BD_Empleado bdea=new BD_Empleado();
	private JPanel contentPane;
	private Usuario u;
	private String cod_emple;

	public JFContratarEmple(String cod_emple) {
		this.u = u;
		this.cod_emple=cod_emple;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Registro Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {
		//Panel de registro
		JPContratarEmple jpmea= new JPContratarEmple();
		jpmea.setBounds(0, 0, 316, 220);
		getContentPane().add(jpmea);
				
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0)  {
				Empleado em = jpmea.getDatos();
				try {
					if(!jpmea.validarDatos()) {
						JOptionPane.showMessageDialog(null, "No estan introducidos todos los datos", "AVISO", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					if(bdea.darAltaEmpleado(em) == 1) {
						JOptionPane.showMessageDialog(null, "Dado de alta correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
						JFEmpleadoAdministracion jfea = new JFEmpleadoAdministracion();
						jfea.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.ERROR_MESSAGE);
					}
				}catch (DatosIntroducidosException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
				}
			});
		btnEnviar.setBounds(10, 231, 89, 23);
		contentPane.add(btnEnviar);	
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFEmpleadoAdministracion jfe = null;
				jfe = new JFEmpleadoAdministracion(cod_emple);
				jfe.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(119, 231, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				jpmea.limpiarDatos();
			}
		});
		btnLimpiar.setBounds(227, 231, 89, 23);
		contentPane.add(btnLimpiar);
	}
}