package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.BD_Aviso;
import bbdd.BD_Empleado;
import exceptions.DatosIntroducidosException;
import modelos.Aviso;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 * @author Pablo
 *
 */

public class JFEmpleadoAdministracion extends JFrame {
	
	private BD_Aviso bda=new BD_Aviso();
	private BD_Empleado bde=new BD_Empleado();
	private Vector<Aviso> avisos=new Vector<Aviso>();
	private JPanel contentPane;
	JFLogin jfl = new JFLogin();
	String tipo,cod_emple;

	public JFEmpleadoAdministracion(String cod_emple) {
		this.tipo = tipo;
		this.cod_emple=cod_emple;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministracion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Administración");
		setBounds(100, 100, 269, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			avisos=bda.contarAvisos(cod_emple);
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
		
		if(avisos.size()==1) {
			
			JOptionPane.showMessageDialog(null, "Tiene un aviso por: \n "+avisos.get(0).getMotivo(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
			
		}else
			if(avisos.size()==2) {
				JOptionPane.showMessageDialog(null, "Tiene dos avisoa por: \n 1."+avisos.get(0).getMotivo()+"\n2. "+avisos.get(1).getMotivo(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				if(avisos.size()>=3) {
					
					JOptionPane.showMessageDialog(null, "Debido a los avisos consecutivos que ha recibido esta despedido", "AVISO", JOptionPane.INFORMATION_MESSAGE);
					
					try {
						bde.darBajaEmpleado(cod_emple);
					} catch (DatosIntroducidosException e) {
						e.printStackTrace();
					}
				}
		
		
		try {
			initialize();
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
	}

	public JFEmpleadoAdministracion() {
		this.tipo = tipo;
		this.cod_emple=cod_emple;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministracion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Administración");
		setBounds(100, 100, 269, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			initialize();
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
	}

	public void initialize() throws DatosIntroducidosException {
		
		
		
		JButton BTNContratarEmpleado = new JButton("Contratar empleado");
		BTNContratarEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFContratarEmple jfc = new JFContratarEmple(cod_emple);
				jfc.setVisible(true);
				dispose();
			}
		});
		BTNContratarEmpleado.setBounds(42, 50, 182, 25);
		contentPane.add(BTNContratarEmpleado);
		
		JButton BTNDespedirEmpleado = new JButton("Despedir empleado");
		BTNDespedirEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFDespedirEmple jfde = new JFDespedirEmple();
				jfde.setVisible(true);
				dispose();
			}
		});
		BTNDespedirEmpleado.setBounds(42, 88, 182, 25);
		contentPane.add(BTNDespedirEmpleado);
		
		JButton BTNResponderReclamacion = new JButton("Responder reclamacion");
		BTNResponderReclamacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFResponderReclamacion jfr = new JFResponderReclamacion();
				jfr.setVisible(true);
				dispose();
			}
		});
		BTNResponderReclamacion.setBounds(42, 126, 182, 25);
		contentPane.add(BTNResponderReclamacion);
		
		JButton BTNSalir = new JButton("Salir");
		BTNSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BTNSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfl.setVisible(true);
				dispose();
			}
		});
		BTNSalir.setBounds(42, 202, 182, 25);
		contentPane.add(BTNSalir);
		
		JButton BTNReportarIncidencia = new JButton("Reportar incidencia");
		BTNReportarIncidencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFCrearIncidencia jfc = new JFCrearIncidencia(cod_emple);
				jfc.setVisible(true);
			}
		});
		BTNReportarIncidencia.setBounds(42, 164, 182, 25);
		contentPane.add(BTNReportarIncidencia);
		
		JLabel LBLSaludo = new JLabel("Bienvenido!");
		LBLSaludo.setBounds(10, 11, 131, 14);
		contentPane.add(LBLSaludo);
		
		
		
	}
}
