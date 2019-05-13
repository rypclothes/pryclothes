package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPListaReclamaciones;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class JFSolucionarIncidencias extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public JFSolucionarIncidencias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFSolucionarIncidencias.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Incidencias");
		setBounds(100, 100, 421, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		initialize();
	}
	
	public void initialize() {
		contentPane.setLayout(null);
		//Panel lista
		JPListaReclamaciones jpl = new JPListaReclamaciones();
		jpl.setBounds(260, 13, 150, 134);
		getContentPane().add(jpl);
		
		JList list = new JList();
		list.setBounds(12, 25, 126, 96);
		jpl.add(list);
		
		JLabel lblCodigoEmpleado = new JLabel("Codigo empleado");
		lblCodigoEmpleado.setBounds(12, 13, 181, 16);
		contentPane.add(lblCodigoEmpleado);
		
		JLabel lblNewLabel = new JLabel("Tipo incidencia");
		lblNewLabel.setBounds(12, 45, 103, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha error");
		lblNewLabel_1.setBounds(12, 80, 103, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(132, 10, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 42, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 77, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(29, 122, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(132, 122, 97, 25);
		contentPane.add(btnSalir);
	}
}
