package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPLogin;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFEmpleadoDise�o extends JFrame {

	private JPanel contentPane;
	JFLogin jfl = new JFLogin();
	String tipo;

	public JFEmpleadoDise�o() {
		this.tipo = tipo;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Dise�o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {		
		JButton BTNCrearDise�o = new JButton("Crear dise\u00F1o");
		BTNCrearDise�o.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFCrearDise�o newDise�o = new JFCrearDise�o(tipo);
				newDise�o.setVisible(true);
				setVisible(false);
			}
		});
		BTNCrearDise�o.setBounds(41, 46, 142, 25);
		contentPane.add(BTNCrearDise�o);
		
		JButton BTNCrearIncidencia = new JButton("Crear incidencia");
		BTNCrearIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfci = new JFCrearIncidencia();
				jfci.setVisible(true);
			}
		});
		BTNCrearIncidencia.setBounds(41, 122, 142, 25);
		contentPane.add(BTNCrearIncidencia);
		
		JLabel LBLSaludo = new JLabel("Bienvenido!");
		LBLSaludo.setBounds(12, 13, 142, 25);
		contentPane.add(LBLSaludo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(41, 160, 142, 25);
		contentPane.add(btnSalir);
		
		JButton btnBorrarDiseo = new JButton("Borrar dise\u00F1o");
		btnBorrarDiseo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFBorrarDise�o jfb = new JFBorrarDise�o();
				jfb.setVisible(true);
				setVisible(false);
			}
		});
		btnBorrarDiseo.setBounds(41, 84, 142, 25);
		contentPane.add(btnBorrarDiseo);
	}
}
