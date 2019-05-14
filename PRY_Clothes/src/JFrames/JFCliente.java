package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPMenuCliente;
import exceptions.DatosIntroducidosException;
import modelos.Cliente;
import modelos.Usuario;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFCliente extends JFrame {

	private JPanel contentPane;
	private JPMenuCliente pMenuCliente;
	private Usuario u;
	
	public JFCliente(Usuario u) {
		
		this.u=u;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Perfil "+u.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
		
		
	}
	
	public void initialize() {
		
		pMenuCliente= new JPMenuCliente();
		pMenuCliente.setSize(388, 210);
		pMenuCliente.setLocation(0, 25);
		getContentPane().add(pMenuCliente);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 119, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu(u.getNombre());
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mi Perfil");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFInfoCliente JFInfocliente = null;
				try {
					JFInfocliente = new JFInfoCliente(u.getNombre());
				} catch (DatosIntroducidosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFInfocliente.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmMisCompras = new JMenuItem("Mis Compras");
		mnNewMenu.add(mntmMisCompras);
		
		JMenuItem mntmMisReclamaciones = new JMenuItem("Mis Reclamaciones");
		mnNewMenu.add(mntmMisReclamaciones);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
				JFLogin jfl = new JFLogin();
				jfl.setVisible(true);
			}
		});
		mnNewMenu.add(mntmCerrarSesion);
		
	}
}
