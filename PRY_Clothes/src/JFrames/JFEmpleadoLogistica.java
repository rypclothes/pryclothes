package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class JFEmpleadoLogistica extends JFrame {

	private JPanel contentPane;
	String tipo;
	
	public JFEmpleadoLogistica(String tipo) {
		this.tipo = tipo;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoLogistica.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Logística");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 241, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BTNVerAlmacen = new JButton("Ver Almac\u00E9n");
		BTNVerAlmacen.setBounds(49, 13, 137, 25);
		contentPane.add(BTNVerAlmacen);
		
		JButton BTNHacerPedido = new JButton("Hacer Pedido");
		BTNHacerPedido.setBounds(49, 51, 137, 25);
		contentPane.add(BTNHacerPedido);
		
		JButton BTNIncidencia = new JButton("Crear Incidencia");
		BTNIncidencia.setBounds(49, 87, 137, 25);
		contentPane.add(BTNIncidencia);
	}
	
	
}
