package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPDatosReclamacion;
import JPanels.JPListaReclamaciones;
import bbdd.BD_Reclamaciones;
import exceptions.DatosIntroducidosException;
import modelos.Diseño;
import modelos.Reclamacion;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
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

public class JFResponderReclamacion extends JFrame {

	private JPanel contentPane;
	private BD_Reclamaciones bdr = new BD_Reclamaciones();
	private JList <Reclamacion> list;
	private JButton btnResponder;
	private JButton btnLimpiar;
	private JButton btnSalir;
	JFEmpleadoAdministracion jfea = new JFEmpleadoAdministracion();

	public JFResponderReclamacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 341);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFResponderReclamacion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Reclamaciones");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		initialize();
	}
	
	public void initialize() {
		//Panel con datos
		JPDatosReclamacion jpd = new JPDatosReclamacion();
		jpd.setBounds(5, 11, 262, 255);
		getContentPane().add(jpd);
		
		//Panel lista
		JPListaReclamaciones jpl = new JPListaReclamaciones();
		jpl.setSize(176, 255);
		jpl.setLocation(271, 11);
		getContentPane().add(jpl);
		
		list = new JList <Reclamacion> (bdr.listadoReclamaciones());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				jpd.setDatos(list.getSelectedValue());
			}
		});
		list.setBounds(10, 21, 156, 223);
		jpl.add(list);
		
		btnResponder = new JButton("Responder");
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnResponder.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Reclamacion rec = jpd.getDatos(list.getSelectedValue().getCod_cliente()); 
				try {
					if(bdr.responderReclamacion(rec) == 1) {
						JOptionPane.showMessageDialog(null, "La reclamacion se ha puesto con exito", "EXITO", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					jfea.setVisible(true);
					dispose();
				} catch (DatosIntroducidosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnResponder.setBounds(54, 277, 103, 23);
		contentPane.add(btnResponder);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jpd.limpiarRespuesta();
			}
		});
		btnLimpiar.setBounds(167, 277, 103, 23);
		contentPane.add(btnLimpiar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				jfea.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(281, 277, 103, 23);
		contentPane.add(btnSalir);
	}
}
