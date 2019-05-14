package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.BD_Diseño;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFBorrarDiseño extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private BD_Diseño bdd = new BD_Diseño();
	private JFEmpleadoDiseño jfd = new JFEmpleadoDiseño();

	public JFBorrarDiseño() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFBorrarDiseño.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Borrar diseño");
		setBounds(100, 100, 261, 126);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
	}
	
	public void initialize() {
		JLabel lblCodigoDiseo = new JLabel("Codigo dise\u00F1o");
		lblCodigoDiseo.setBounds(12, 23, 118, 16);
		contentPane.add(lblCodigoDiseo);
		
		textField = new JTextField();
		textField.setBounds(127, 20, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int filas = bdd.borraDiseño(textField.getText());
				
				if(filas == 1) {
					JOptionPane.showMessageDialog(null, "Diseño eliminado", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					jfd.setVisible(true);
					dispose();
				}else {
					if(filas == 0) {
						JOptionPane.showMessageDialog(null, "Datos mal introducidos", "AVSO", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Problema en la BBDD", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAceptar.setBounds(12, 55, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				jfd.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(146, 55, 97, 25);
		contentPane.add(btnSalir);
	}
}
