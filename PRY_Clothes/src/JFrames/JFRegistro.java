package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import JPanels.JPLogin;
import JPanels.JPRegistro;
import bbdd.BD_Clientes;
import exceptions.DatosIntroducidosException;
import modelos.Cliente;
import modelos.Usuario;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFRegistro extends JFrame {

	private JPanel contentPane;
	private JPRegistro panelRegistro;
	private BD_Clientes bdc = new BD_Clientes();
	private JFLogin login = new JFLogin();

	public JFRegistro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFRegistro.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Men\u00FA Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {
		//Panel de registro
		panelRegistro = new JPRegistro();
		panelRegistro.setBounds(0, 0, 263, 208);
		getContentPane().add(panelRegistro);
		
		//Boton de aceptar
		JButton BTNAceptar = new JButton("Aceptar");
		BTNAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Cliente cl = panelRegistro.getDatos();
				try {
					if(bdc.darAltaCliente(cl) == 1) {
						JOptionPane.showMessageDialog(null, "Dado de alta correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
						login.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.ERROR_MESSAGE);
					}
				} catch (DatosIntroducidosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		BTNAceptar.setBounds(82, 221, 97, 25);
		contentPane.add(BTNAceptar);
	}
}
