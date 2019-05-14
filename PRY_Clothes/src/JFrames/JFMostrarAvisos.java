package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.BD_Aviso;
import exceptions.DatosIntroducidosException;
import modelos.Aviso;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFMostrarAvisos extends JFrame {

	private JPanel contentPane;
	private JList <Aviso> list;
	private BD_Aviso bda = new BD_Aviso();

	public JFMostrarAvisos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFMostrarAvisos.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Avisos");
		setBounds(100, 100, 335, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		initialize();
	}
	
	public void initialize() {
		//Añadimos la lista
		try {
			contentPane.setLayout(null);
			list = new JList <Aviso> (bda.mostrarAvisos()) ;
			list.setBounds(5, 5, 317, 143);
			getContentPane().add(list);
			
			JButton btnSali = new JButton("Salir");
			btnSali.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					JFAdmin jfa = new JFAdmin();
					jfa.setVisible(true);
					dispose();
				}
			});
			btnSali.setBounds(111, 163, 97, 25);
			contentPane.add(btnSali);
			
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
	}
}
