package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFEmpleadoLogistica extends JFrame {

	private JPanel contentPane;
	String tipo;
	JFLogin jfl = new JFLogin();
	
	public JFEmpleadoLogistica() {
		this.tipo = tipo;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoLogistica.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Logística");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 241, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BTNVerAlmacen = new JButton("Ver Almac\u00E9n");
		BTNVerAlmacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFVerAlmacen jfv = new JFVerAlmacen();
				jfv.setVisible(true);
				dispose();
			}
		});
		BTNVerAlmacen.setBounds(48, 41, 137, 25);
		contentPane.add(BTNVerAlmacen);
		
		JButton BTNHacerPedido = new JButton("Hacer Pedido");
		BTNHacerPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFRealizarPedido jfer = new JFRealizarPedido();
				jfer.setVisible(true);
				dispose();
			}
		});
		BTNHacerPedido.setBounds(48, 79, 137, 25);		
		contentPane.add(BTNHacerPedido);
		
		JButton BTNIncidencia = new JButton("Crear Incidencia");
		BTNIncidencia.setBounds(48, 115, 137, 25);
		BTNIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfci = new JFCrearIncidencia(tipo);
				jfci.setVisible(true);
			}
		});
		contentPane.add(BTNIncidencia);
		
		JLabel LBLBienvenido = new JLabel("Bienvenido!");
		LBLBienvenido.setBounds(10, 16, 69, 14);
		contentPane.add(LBLBienvenido);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(48, 151, 137, 23);
		contentPane.add(btnSalir);
	}
}
