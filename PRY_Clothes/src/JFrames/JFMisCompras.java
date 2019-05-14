package JFrames;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPDatosCompra;
import JPanels.JPListaCompras;
import JPanels.JPListaReclamaciones;
import bbdd.BD_Compras;
import modelos.Reclamacion;
import modelos.Compra;

import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFMisCompras extends JFrame {
	private BD_Compras bdc = new BD_Compras();
	private JPanel contentPane;
	private JList <Compra> list;
	public JFMisCompras(String cod_cliente) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Mis Compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPDatosCompra jDatos=new JPDatosCompra();
		jDatos.setBounds(315, 13, 451, 244);
		contentPane.add(jDatos);
		
		JPListaCompras jLista=new JPListaCompras();
		jLista.setLocation(12, 13);
		getContentPane().add(jLista);
		
		list = new JList <Compra> (bdc.listadoCompras(cod_cliente));
		list.setBounds(12, 24, 239, 207);
		jLista.add(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				jDatos.setDatos(list.getSelectedValue());
			}
		});
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(241, 270, 97, 21);
		contentPane.add(btnSalir);
		
		
		
		
	}
}
