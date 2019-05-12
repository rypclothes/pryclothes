package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPRealizarPedido;
import bbdd.BD_Dise�o;
import exceptions.DatosIntroducidosException;
import modelos.Dise�o;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFRealizarPedido extends JFrame {

	private JPanel contentPane;
	private JFEmpleadoLogistica jfl = new JFEmpleadoLogistica();
	
	public JFRealizarPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		initialize();
	}
	
	public void initialize() {
		//A�adimos el panel
		JPRealizarPedido jpr = new JPRealizarPedido();
		contentPane.add(jpr);
		jpr.setLayout(null);
		
		//A�adimos el boton
		JButton BTNAceptar = new JButton("Aceptar");
		BTNAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BTNAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Dise�o dis = jpr.getDatos();
				BD_Dise�o bdd = new BD_Dise�o();
				try {
					if(bdd.hacerPedido(dis.getCodDise�o(), dis.getCantidad()) == 1) {
						JOptionPane.showMessageDialog(null, "Pedido realizado correctamente", "�XITO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						jfl.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Error en la BBDD", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (DatosIntroducidosException e) {
					JOptionPane.showMessageDialog(null, "Algun dato esta mal introducido", "AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		BTNAceptar.setBounds(10, 102, 89, 23);
		jpr.add(BTNAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFEmpleadoLogistica jfel = new JFEmpleadoLogistica();
				jfel.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(128, 102, 89, 23);
		jpr.add(btnSalir);
	}
}
