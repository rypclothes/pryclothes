package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private BD_Incidencias bdi=new BD_Incidencias();
	String tipo;

	public JFCrearIncidencia(String tipo) {
		this.tipo = tipo;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Crear incidencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 183);
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
				int res = bdi.añadir_Incidencia(in);
				
				if(res == 1) {
					JOptionPane.showMessageDialog(null, "Incidencia dada de alta correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "Algun dato no es correcto", "AVISO", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Error en la BBDD", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAceptar.setBounds(72, 102, 97, 25);
		jpci.add(btnAceptar);
	}
}
