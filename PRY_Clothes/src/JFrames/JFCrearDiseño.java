package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPCrearDiseño;
import bbdd.BD_Diseño;
import modelos.Diseño;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFCrearDiseño extends JFrame {
	private JPanel contentPane;
	private BD_Diseño bdd = new BD_Diseño();

	public JFCrearDiseño() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministrativo.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Creacion de diseños");
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
		//Añadimos el panel
		JPCrearDiseño jpc = new JPCrearDiseño();
		getContentPane().add(jpc);
		
		//Añadimos el boton
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFEmpleadoDiseño crear = new JFEmpleadoDiseño();
				
				if(!jpc.validarDatos()) {
					JOptionPane.showMessageDialog(null, "Tienen que estar rellenos todos los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				Diseño d = jpc.getDatos();

				if(bdd.añadir_Diseño(d) == 1) {
					JOptionPane.showMessageDialog(null, "Dado de alta correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					crear.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
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
