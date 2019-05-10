package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPDespedirEmple;
import bbdd.BD_Empleado;
import exceptions.DatosIntroducidosException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFDespedirEmple extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private BD_Empleado bde = new BD_Empleado();
	String tipo;

	public JFDespedirEmple(String tipo) {
		this.tipo = tipo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFDespedirEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Despedir Empleado");
		setBounds(100, 100, 314, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
	}
	
	public void initialize() {
		//Añadimos el panel
		JPDespedirEmple jpd = new JPDespedirEmple();
		getContentPane().add(jpd);
		
		//Añadimos el boton
		JButton BTNAceptar = new JButton("Aceptar");
		BTNAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String codigo = jpd.getDatos();
				try {
					if(bde.darBajaEmpleado(codigo) == 1) {
						JOptionPane.showMessageDialog(null, "Empleado borrado con exito", "EXITO", JOptionPane.INFORMATION_MESSAGE);
						JFEmpleadoAdministracion jfe = new JFEmpleadoAdministracion(tipo);
						jfe.setVisible(true);
						dispose();
					}
				} catch (DatosIntroducidosException e1) {
					JOptionPane.showMessageDialog(null, "Error con la introduccion de los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		BTNAceptar.setBounds(99, 107, 97, 25);
		contentPane.add(BTNAceptar);
	}
}
