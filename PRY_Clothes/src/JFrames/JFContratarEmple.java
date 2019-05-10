package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import JPanels.JPContratarEmple;
import bbdd.BD_Empleado;
import exceptions.DatosIntroducidosException;
import modelos.Empleado;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFContratarEmple extends JFrame {
	
	private BD_Empleado bdea=new BD_Empleado();
	private JPanel contentPane;

	public JFContratarEmple() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Registro Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 308);
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
		JPContratarEmple jpmea= new JPContratarEmple();
		jpmea.setBounds(0, 0, 316, 220);
		getContentPane().add(jpmea);
				
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent arg0)  {
			Empleado em = jpmea.getDatos();
			try {
				if(bdea.darAltaEmpleado(em) == 1) {
					JOptionPane.showMessageDialog(null, "Dado de alta correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					jpmea.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.ERROR_MESSAGE);
				}
			}catch (DatosIntroducidosException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		btnEnviar.setBounds(122, 233, 89, 23);
		contentPane.add(btnEnviar);	
	}
}
