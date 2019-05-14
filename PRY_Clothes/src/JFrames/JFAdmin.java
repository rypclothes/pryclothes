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
	private JFLogin jfl = new JFLogin();
	private JFMostrarAvisos jfm = new JFMostrarAvisos();
	
	public JFAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFAdmin.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 253, 191);
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
		BTNSolIncid.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFSolucionarIncidencias jfs = new JFSolucionarIncidencias();
				jfs.setVisible(true);
				dispose();
			}
		});
		BTNSolIncid.setBounds(41, 13, 168, 25);
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
		btnNewButton.setBounds(41, 49, 168, 25);
		contentPane.add(btnNewButton);
		
		JButton btnMostrarAvisos = new JButton("Mostrar avisos");
		btnMostrarAvisos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfm.setVisible(true);
				dispose();
			}
		});
		btnMostrarAvisos.setBounds(41, 87, 168, 25);
		contentPane.add(btnMostrarAvisos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(41, 125, 168, 25);
		contentPane.add(btnSalir);
	}
}
