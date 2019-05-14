package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPCrearDise�o;
import bbdd.BD_Dise�o;
import modelos.Dise�o;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFCrearDise�o extends JFrame {
	private JPanel contentPane;
	private BD_Dise�o bdd = new BD_Dise�o();
	String tipo;

	public JFCrearDise�o(String tipo) {
		this.tipo = tipo;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Creaci�n dise�o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 272, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {
		contentPane.setLayout(null);
		//A�adimos el panel
		JPCrearDise�o jpc = new JPCrearDise�o();
		jpc.setBounds(0, 0, 266, 225);
		getContentPane().add(jpc);
		
		//A�adimos el boton
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFEmpleadoDise�o crear = new JFEmpleadoDise�o();
				
				if(!jpc.validarDatos()) {
					JOptionPane.showMessageDialog(null, "Tienen que estar rellenos todos los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				Dise�o d = jpc.getDatos();

				if(bdd.a�adir_Dise�o(d) == 1) {
					JOptionPane.showMessageDialog(null, "Dado de alta correctamente", "�XITO", JOptionPane.INFORMATION_MESSAGE);
					crear.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Alg�n dato no se ha introducido correctamente!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCrear.setBounds(24, 151, 97, 25);
		jpc.add(btnCrear);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jpc.limpiarDatos();
			}
		});
		btnLimpiar.setBounds(142, 151, 97, 25);
		jpc.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFEmpleadoDise�o jfed = new JFEmpleadoDise�o();
				jfed.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(84, 187, 97, 25);
		jpc.add(btnSalir);
	}
}
