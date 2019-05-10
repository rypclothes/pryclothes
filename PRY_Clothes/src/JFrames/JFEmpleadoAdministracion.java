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

public class JFEmpleadoAdministracion extends JFrame {

	private JPanel contentPane;
	JFLogin jfl = new JFLogin();
	String tipo;

	public JFEmpleadoAdministracion(String tipo) {
		this.tipo = tipo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministracion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Administración");
		setBounds(100, 100, 269, 256);
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
		BTNContratarEmpleado.setBounds(39, 23, 182, 25);
		contentPane.add(BTNContratarEmpleado);
		
		JButton BTNDespedirEmpleado = new JButton("Despedir empleado");
		BTNDespedirEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFDespedirEmple jfde = new JFDespedirEmple(tipo);
				jfde.setVisible(true);
				dispose();
			}
		});
		BTNDespedirEmpleado.setBounds(39, 61, 182, 25);
		contentPane.add(BTNDespedirEmpleado);
		
		JButton BTNResponderReclamacion = new JButton("Responder reclamacion");
		BTNResponderReclamacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		BTNResponderReclamacion.setBounds(39, 99, 182, 25);
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
		BTNSalir.setBounds(39, 175, 182, 25);
		contentPane.add(BTNSalir);
		
		JButton BTNReportarIncidencia = new JButton("Reportar incidencia");
		BTNReportarIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfc = new JFCrearIncidencia(tipo);
				jfc.setVisible(true);
			}
		});
		BTNReportarIncidencia.setBounds(39, 137, 182, 25);
		contentPane.add(BTNReportarIncidencia);
	}
}
