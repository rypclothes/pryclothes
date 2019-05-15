package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPMenuCliente;
import bbdd.BD_Clientes;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;
import modelos.Cliente;
import modelos.Usuario;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author Rober
 *
 */
public class JFCliente extends JFrame {

	private JPanel contentPane;
	private JPMenuCliente pMenuCliente;
	private Usuario u;
	private Cliente cli;
	private BD_Usuario bdu = new BD_Usuario();
	private BD_Clientes bdc = new BD_Clientes();
	
	public JFCliente(Usuario u) throws DatosIntroducidosException {
		
		this.u=u;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
		
		
	}
	
	public void initialize() throws DatosIntroducidosException {
		
		cli=bdu.buscarClienteDatos(u.getNombre());
		
		pMenuCliente= new JPMenuCliente(cli.getCodigo());
		pMenuCliente.setSize(206, 141);
		pMenuCliente.setLocation(0, 25);
		getContentPane().add(pMenuCliente);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 71, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu(u.getNombre());
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mi Perfil");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFInfoCliente JFInfocliente = null;
				try {
					JFInfocliente = new JFInfoCliente(cli.getNombre());
				} catch (DatosIntroducidosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFInfocliente.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmMisCompras = new JMenuItem("Mis Compras");
		mntmMisCompras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFMisCompras jfm=new JFMisCompras(cli.getCodigo());
				jfm.setVisible(true);
			}
		});
		mnNewMenu.add(mntmMisCompras);
		
		JMenuItem mntmMisReclamaciones = new JMenuItem("Mis Reclamaciones");
		mntmMisReclamaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFMisReclamaciones jfmis=new JFMisReclamaciones(cli.getCodigo());
				jfmis.setVisible(true);
			}
		});
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
