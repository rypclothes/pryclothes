package JFrames;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Pablo
 *
 */

public class JFInformacion extends JFrame {

	private JPanel contentPane;
	private JFLogin jfl = new JFLogin();

	public JFInformacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFInformacion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Información");
		setBounds(100, 100, 511, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
	}
	
	public void initialize() {
		contentPane.setLayout(null);
		JLabel lblLaEmpresaPry = new JLabel("Nuestra empresa est\u00E1 en contacto con otra marca de ropa, la cual est\u00E1 en auge en la");
		lblLaEmpresaPry.setBounds(10, 11, 557, 33);
		contentPane.add(lblLaEmpresaPry);
		
		JLabel lblActualidadYCon = new JLabel("actualidad, y con la que no se descarta una posible colaboracio\u00F3n en un futuro.");
		lblActualidadYCon.setBounds(10, 35, 557, 14);
		contentPane.add(lblActualidadYCon);
		
		JLabel lblSiDeseaMas = new JLabel("Si desea mas informaci\u00F3n sobre esta marca, puede acceder a su original p\u00E1gina web");
		lblSiDeseaMas.setBounds(10, 68, 557, 14);
		contentPane.add(lblSiDeseaMas);
		
		JLabel lblPinchandoEnEl = new JLabel("pinchando en el siguiente bot\u00F3n:");
		lblPinchandoEnEl.setBounds(10, 83, 202, 14);
		contentPane.add(lblPinchandoEnEl);
		
		JButton BTNInformacion = new JButton("Juacas Jaus");
		//BTNInformacion.setIcon(new ImageIcon(JFInformacion.class.getResource("/imagenes/logo.png")));
		BTNInformacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				goTo_navegador("https://juacasjaus.000webhostapp.com/");
			}
		});
		BTNInformacion.setBounds(10, 102, 109, 23);
		contentPane.add(BTNInformacion);
		
		JLabel lblAutoresYandryPablo = new JLabel("Autores: Yandry, Pablo, Roberto, Daniel, Mario");
		lblAutoresYandryPablo.setBounds(236, 115, 320, 14);
		contentPane.add(lblAutoresYandryPablo);
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2019  Version Beta");
		lblCopyright.setBounds(316, 140, 272, 14);
		contentPane.add(lblCopyright);
		
		JButton BTNSalir = new JButton("Salir");
		BTNSalir.setBounds(10, 136, 109, 23);
		BTNSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		contentPane.add(BTNSalir);
	}
	
	private void goTo_navegador(String URL)   {
		try {
			java.net.URI uri = new java.net.URI(URL);
			Desktop d=Desktop.getDesktop();
	        d.browse(uri);
		}catch (URISyntaxException e) {
			
		}catch (IOException e) {
			
		}
	}
}
