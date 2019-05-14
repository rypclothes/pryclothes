package JFrames;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPDatosReclamacion;
import JPanels.JPListaReclamaciones;
import bbdd.BD_Reclamaciones;
import exceptions.DatosIntroducidosException;
import modelos.Reclamacion;
public class JFMisReclamaciones extends JFrame{
	private JPanel contentPane;
	private BD_Reclamaciones bdr = new BD_Reclamaciones();
	private JList <Reclamacion> list;
	private JButton btnSalir;
	private String cod;
	public JFMisReclamaciones(String cod) {
		this.cod=cod;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 341);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFResponderReclamacion.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Mis Reclamaciones");
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
				
				list = new JList <Reclamacion> (bdr.listadoMisReclamaciones(cod));
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						jpd.setDatos1(list.getSelectedValue());
					}
				});
				list.setBounds(10, 21, 156, 223);
				jpl.add(list);
				
				
				btnSalir = new JButton("Salir");
				btnSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
			
						dispose();
					}
				});
				btnSalir.setBounds(175, 279, 103, 23);
				contentPane.add(btnSalir);
		
	}

}
