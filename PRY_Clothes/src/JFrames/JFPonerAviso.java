package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPPonerAviso;
import bbdd.BD_Aviso;
import exceptions.DatosIntroducidosException;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFPonerAviso extends JFrame {

	private JPanel contentPane;
	private JFAdmin jfa = new JFAdmin();
	
	public JFPonerAviso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFPonerAviso.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Poner aviso");
		setBounds(100, 100, 278, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		initialize();
	}
	
	public void initialize() {
		contentPane.setLayout(null);
		//Añadimos el panel
		JPPonerAviso jpp = new JPPonerAviso();
		jpp.setBounds(0, 0, 256, 192);
		getContentPane().add(jpp);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				BD_Aviso bda = new BD_Aviso();
				try {
					if(bda.anotarAviso(jpp.getDatos()) == 1) {
						JOptionPane.showMessageDialog(null, "Aviso añadido", "EXITO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						jfa.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (DatosIntroducidosException e) {
					JOptionPane.showMessageDialog(null, "Error en la BBDD", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(24, 205, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfa.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(134, 205, 97, 25);
		contentPane.add(btnSalir);
		
		
	}
}
