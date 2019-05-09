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

public class JFCrearDise�o extends JFrame {
	private JPanel contentPane;
	private BD_Dise�o bdd = new BD_Dise�o();

	public JFCrearDise�o() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministrativo.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Creacion de dise�os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {
		//A�adimos el panel
		JPCrearDise�o jpc = new JPCrearDise�o();
		getContentPane().add(jpc);
		
		//A�adimos el boton
		JButton btnCrear = new JButton("CREAR");
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
		btnCrear.setBounds(12, 200, 97, 25);
		jpc.add(btnCrear);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jpc.limpiarDatos();
			}
		});
		btnLimpiar.setBounds(130, 200, 97, 25);
		jpc.add(btnLimpiar);
	}
}
