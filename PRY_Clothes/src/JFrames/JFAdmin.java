package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFAdmin extends JFrame {

	private JPanel contentPane;

	
	public JFAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFAdmin.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Perfil Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 253, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
	}
	
	public void initialize() {
		JButton BTNSolIncid = new JButton("Solucionar incidencia");
		BTNSolIncid.setBounds(35, 24, 168, 25);
		contentPane.add(BTNSolIncid);
		
		JButton btnNewButton = new JButton("Poner aviso");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFPonerAviso jpf = new JFPonerAviso();
				jpf.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(35, 60, 168, 25);
		contentPane.add(btnNewButton);
		
		JButton btnMostrarAvisos = new JButton("Mostrar avisos");
		btnMostrarAvisos.setBounds(35, 98, 168, 25);
		contentPane.add(btnMostrarAvisos);
	}
}
