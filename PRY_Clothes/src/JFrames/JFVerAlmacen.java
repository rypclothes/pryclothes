package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPanels.JPCantidadAlmacen;
import JPanels.JPListaAlmacen;
import bbdd.BD_Dise�o;
import modelos.Dise�o;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Pablo
 *
 */

public class JFVerAlmacen extends JFrame {

	private JPanel contentPane;
	BD_Dise�o bdd = new BD_Dise�o();
	private JTextField textField;
	private JList <Dise�o> list;
	JPCantidadAlmacen jpc = new JPCantidadAlmacen();

	public JFVerAlmacen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFVerAlmacen.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Almac�n");
		setBounds(100, 100, 337, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initialize();
	}
	
	public void initialize() {
		//Panel cantidades
		JPCantidadAlmacen jpc = new JPCantidadAlmacen();
		jpc.setLocation(10, 11);
		getContentPane().add(jpc);
		
		//Panel lista
		JPListaAlmacen jpl = new JPListaAlmacen();
		jpl.setLocation(216, 11);
		jpl.setSize(102, 141);
		//DefaultListModel modelo = new DefaultListModel();
		Vector<Dise�o> v=bdd.consultar_Dise�os();
		
		//for(Dise�o s: v ) {
           // modelo.addElement(s);
       // }
		getContentPane().add(jpl);
		
		//Lista
		list = new JList <Dise�o>(bdd.consultar_Dise�os());
		//list.setModel(modelo);
		list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                            jpc.setDatos(list.getSelectedValue());
                    }
            });
		list.setBounds(20, 21, 61, 109);
		jpl.add(list);
		
		JButton btnHacerPedido = new JButton("Hacer pedido");
		btnHacerPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFRealizarPedido jfre = new JFRealizarPedido();
				jfre.setVisible(true);
				dispose();
			}
		});
		btnHacerPedido.setBounds(50, 90, 119, 23);
		contentPane.add(btnHacerPedido);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFEmpleadoLogistica jfel = new JFEmpleadoLogistica();
				jfel.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(50, 124, 119, 23);
		contentPane.add(btnSalir);
	}
}
