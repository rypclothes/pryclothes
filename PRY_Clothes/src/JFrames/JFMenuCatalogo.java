package JFrames;

import java.awt.Toolkit;

import javax.swing.JFrame;

import bbdd.BD_Compras;
import bbdd.BD_Ventas;
import modelos.Cliente;
import modelos.Venta;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class JFMenuCatalogo extends JFrame{
	private String factura;
	private String cod_cliente;
	private Vector<Venta> carrito;
	private BD_Ventas bdv=new BD_Ventas();
	public JFMenuCatalogo(String cod_cliente,Vector<Venta> carrito) {
		this.cod_cliente=cod_cliente;
		this.carrito=carrito;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Catalogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 280);
		getContentPane().setLayout(null);
		
		factura=bdv.crearFactura(cod_cliente);
		
		JButton btnCamisetas = new JButton("CAMISETAS");
		btnCamisetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				menuclick("camiseta");
				
			}
		});
		btnCamisetas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCamisetas.setBounds(39, 24, 142, 56);
		getContentPane().add(btnCamisetas);
		
		JButton button = new JButton("SUDADERAS");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				menuclick("sudadera");
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(206, 24, 142, 56);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("PANTALONES");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				menuclick("pantalon");
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_1.setBounds(39, 111, 142, 56);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("ABRIGOS");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				menuclick("abrigo");
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_2.setBounds(206, 111, 142, 56);
		getContentPane().add(button_2);
		
		JButton btnAtras = new JButton("Salir");
		btnAtras.setBounds(143, 195, 97, 25);
		getContentPane().add(btnAtras);
		
		
	}
	
	public void menuclick(String categoria) {
		
		JFMenuCatalogoCompras jfcom=new JFMenuCatalogoCompras(factura,cod_cliente,categoria,carrito);
		jfcom.setVisible(true);
		
	}
	
}
