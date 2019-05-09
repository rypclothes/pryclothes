package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFEmpleadoDise�o extends JFrame {

	private JPanel contentPane;

	public JFEmpleadoDise�o() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministrativo.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Perfil Empleado Dise�o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		initialize();
	}
	
	public void initialize() {		
		JButton BTNCrearDise�o = new JButton("CREAR DISE\u00D1O");
		BTNCrearDise�o.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFCrearDise�o newDise�o = new JFCrearDise�o();
				newDise�o.setVisible(true);
			}
		});
		BTNCrearDise�o.setBounds(41, 56, 142, 25);
		contentPane.add(BTNCrearDise�o);
		
		JButton BTNCrearIncidencia = new JButton("CREAR INCIDENCIA");
		BTNCrearIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfci = new JFCrearIncidencia();
				jfci.setVisible(true);
			}
		});
		BTNCrearIncidencia.setBounds(41, 94, 142, 25);
		contentPane.add(BTNCrearIncidencia);
		
		JLabel LBLSaludo = new JLabel("Hola dise\u00F1ador!");
		LBLSaludo.setBounds(12, 13, 89, 16);
		contentPane.add(LBLSaludo);
	}
}
