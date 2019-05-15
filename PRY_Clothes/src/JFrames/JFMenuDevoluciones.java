package JFrames;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import JPanels.JPDevoluciones;
import bbdd.BD_Compras;
import bbdd.BD_Ventas;
import exceptions.DatosIntroducidosException;
import modelos.Compra;
import modelos.Venta;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFMenuDevoluciones extends JFrame{
	private BD_Ventas bdv=new BD_Ventas();
	private BD_Compras bdc=new BD_Compras();
	private String factura;
	public JFMenuDevoluciones(String cod_cliente) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Menu Devoluciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 362);
		
		
		JPDevoluciones jpdev=new JPDevoluciones();
		jpdev.setBounds(12, 13, 451, 244); 
		getContentPane().setLayout(null);
		getContentPane().add(jpdev);
		
		JList<Compra> list = new JList<Compra>(bdc.listadoCompras(cod_cliente));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				factura=list.getSelectedValue().getFactura();
			}
		});
		list.setBounds(12, 25, 427, 206);
		
		jpdev.add(list);
		
		JButton btnRealizarDevolucion = new JButton("Realizar Devolucion");
		btnRealizarDevolucion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					bdv.darBajaVenta(factura);
					bdc.darBajaCompra(factura);
				}catch(DatosIntroducidosException e1) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la devolucion", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				JOptionPane.showMessageDialog(null, "Devolucion hecha con exito", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				
				JFMenuDevoluciones jfmen=new JFMenuDevoluciones(cod_cliente);
				jfmen.setVisible(true);
				dispose();
				
			}
		});
		btnRealizarDevolucion.setBounds(51, 270, 156, 25);
		getContentPane().add(btnRealizarDevolucion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(265, 270, 156, 25);
		getContentPane().add(btnCancelar);
		
	}
	
	
}
