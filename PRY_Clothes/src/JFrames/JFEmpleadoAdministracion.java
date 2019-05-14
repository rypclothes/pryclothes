package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.DatosIntroducidosException;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * 
 * @author Pablo
 *
 */

public class JFEmpleadoAdministracion extends JFrame {

	private JPanel contentPane;
	JFLogin jfl = new JFLogin();
	String tipo;

	public JFEmpleadoAdministracion() {
		this.tipo = tipo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministracion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Administración");
		setBounds(100, 100, 269, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
	}
	
	public void initialize() {
		JButton BTNContratarEmpleado = new JButton("Contratar empleado");
		BTNContratarEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFContratarEmple jfc = new JFContratarEmple();
				jfc.setVisible(true);
				dispose();
			}
		});
		BTNContratarEmpleado.setBounds(42, 50, 182, 25);
		contentPane.add(BTNContratarEmpleado);
		
		JButton BTNDespedirEmpleado = new JButton("Despedir empleado");
		BTNDespedirEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFDespedirEmple jfde = new JFDespedirEmple();
				jfde.setVisible(true);
				dispose();
			}
		});
		BTNDespedirEmpleado.setBounds(42, 88, 182, 25);
		contentPane.add(BTNDespedirEmpleado);
		
		JButton BTNResponderReclamacion = new JButton("Responder reclamacion");
		BTNResponderReclamacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFResponderReclamacion jfr = new JFResponderReclamacion();
				jfr.setVisible(true);
				dispose();
			}
		});
		BTNResponderReclamacion.setBounds(42, 126, 182, 25);
		contentPane.add(BTNResponderReclamacion);
		
		JButton BTNSalir = new JButton("Salir");
		BTNSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BTNSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		BTNSalir.setBounds(42, 202, 182, 25);
		contentPane.add(BTNSalir);
		
		JButton BTNReportarIncidencia = new JButton("Reportar incidencia");
		BTNReportarIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfc = new JFCrearIncidencia();
				jfc.setVisible(true);
			}
		});
		BTNReportarIncidencia.setBounds(42, 164, 182, 25);
		contentPane.add(BTNReportarIncidencia);
		
		JLabel LBLSaludo = new JLabel("Bienvenido!");
		LBLSaludo.setBounds(10, 11, 131, 14);
		contentPane.add(LBLSaludo);
	}
}
