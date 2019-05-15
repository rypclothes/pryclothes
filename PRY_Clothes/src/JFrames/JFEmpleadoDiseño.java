package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPLogin;
import bbdd.BD_Aviso;
import bbdd.BD_Empleado;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;
import modelos.Aviso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * 
 * @author Pablo
 *
 */

public class JFEmpleadoDise�o extends JFrame {
	private BD_Aviso bda=new BD_Aviso();
	private BD_Empleado bde=new BD_Empleado();
	private Vector<Aviso> avisos=new Vector<Aviso>();
	private JPanel contentPane;
	JFLogin jfl = new JFLogin();
	String tipo,cod_emple;
	
	
	public JFEmpleadoDise�o(String cod_emple) {
		this.tipo = tipo;
		this.cod_emple=cod_emple;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Dise�o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		try {
			initialize();
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
	}
	
	public JFEmpleadoDise�o() {
		this.tipo = tipo;
		this.cod_emple=cod_emple;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFContratarEmple.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Dise�o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		try {
			initialize();
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
	}

	public void initialize() throws DatosIntroducidosException {		
		JButton BTNCrearDise�o = new JButton("Crear dise\u00F1o");
		BTNCrearDise�o.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFCrearDise�o newDise�o = new JFCrearDise�o(tipo,cod_emple);
				newDise�o.setVisible(true);
				setVisible(false);
			}
		});
		BTNCrearDise�o.setBounds(41, 46, 142, 25);
		contentPane.add(BTNCrearDise�o);
		
		JButton BTNCrearIncidencia = new JButton("Crear incidencia");
		BTNCrearIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfci = new JFCrearIncidencia(cod_emple);
				jfci.setVisible(true);
			}
		});
		BTNCrearIncidencia.setBounds(41, 122, 142, 25);
		contentPane.add(BTNCrearIncidencia);
		
		JLabel LBLSaludo = new JLabel("Bienvenido!");
		LBLSaludo.setBounds(12, 13, 142, 25);
		contentPane.add(LBLSaludo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(41, 160, 142, 25);
		contentPane.add(btnSalir);
		
		JButton btnBorrarDiseo = new JButton("Borrar dise\u00F1o");
		btnBorrarDiseo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFBorrarDise�o jfb = new JFBorrarDise�o();
				jfb.setVisible(true);
				setVisible(false);
			}
		});
		btnBorrarDiseo.setBounds(41, 84, 142, 25);
		contentPane.add(btnBorrarDiseo);
		
		avisos=bda.contarAvisos(cod_emple);
		if(avisos.size()==1) {
			
			JOptionPane.showMessageDialog(null, "Tiene un aviso por: \n "+avisos.get(0).getMotivo(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
			
		}else
			if(avisos.size()==2) {
				JOptionPane.showMessageDialog(null, "Tiene dos avisoa por: \n 1."+avisos.get(0).getMotivo()+"\n2. "+avisos.get(1).getMotivo(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				if(avisos.size()>=3) {
					
					JOptionPane.showMessageDialog(null, "Debido a los avisos consecutivos que ha recibido esta despedido", "AVISO", JOptionPane.INFORMATION_MESSAGE);
					
					bde.darBajaEmpleado(cod_emple);
				}
		
	}
}
