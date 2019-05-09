package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPCrearIncidencia;
import bbdd.BD_Incidencias;
import modelos.Diseño;
import modelos.Incidencia;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFCrearIncidencia extends JFrame {

	private JPanel contentPane;
	private BD_Incidencias bdi;

	public JFCrearIncidencia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministrativo.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Crear incidencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {
		//Añadimos panel
		JPCrearIncidencia jpci = new JPCrearIncidencia();
		getContentPane().add(jpci);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Incidencia in = jpci.getDatos();
				bdi.añadir_Incidencia(in);
			}
		});
		btnAceptar.setBounds(73, 112, 97, 25);
		jpci.add(btnAceptar);
	}
}
