package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import JFrames.JFEscribirReclamacion;
import JFrames.JFMenuCatalogo;
import JFrames.JFMenuDevoluciones;
import bbdd.BD_Ventas;
import modelos.Venta;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPMenuCliente extends JPanel{
	private BD_Ventas bdv=new BD_Ventas();
	private String cod_cliente;
	public JPMenuCliente(String cod_cliente) {
		this.cod_cliente=cod_cliente;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(0, 0, 205, 140);
		setLayout(null);
		
		initialize();
	}
	
	public void initialize() {
		
		JButton btnNewButton = new JButton("Escribir Reclamacion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFEscribirReclamacion jescribir= new JFEscribirReclamacion(cod_cliente);
				jescribir.setVisible(true);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(22, 25, 165, 25);
		add(btnNewButton);
		
		JButton btnVerCatalogo = new JButton("Ver Catalogo");
		btnVerCatalogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Vector<Venta>carrito=null;
				String factura=bdv.crearFactura(cod_cliente);
				JFMenuCatalogo jmenu=new JFMenuCatalogo(cod_cliente,factura);
				jmenu.setVisible(true);
				
			}
		});
		btnVerCatalogo.setBounds(22, 61, 165, 25);
		add(btnVerCatalogo);
		
		JButton btnHacerDevolucion = new JButton("Hacer Devolucion");
		btnHacerDevolucion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFMenuDevoluciones jfdev=new JFMenuDevoluciones(cod_cliente);
				jfdev.setVisible(true);
				
			}
		});
		btnHacerDevolucion.setBounds(22,97, 165, 25);
		add(btnHacerDevolucion);
		
	}
}
