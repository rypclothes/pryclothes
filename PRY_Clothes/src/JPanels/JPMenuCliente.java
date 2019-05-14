package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import JFrames.JFEscribirReclamacion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPMenuCliente extends JPanel{
	private String cod_cliente;
	public JPMenuCliente(String cod_cliente) {
		this.cod_cliente=cod_cliente;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(0, 0, 388, 210);
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
		btnNewButton.setBounds(128, 25, 150, 50);
		add(btnNewButton);
		
		JButton btnVerCatalogo = new JButton("Ver Catalogo");
		btnVerCatalogo.setBounds(128, 84, 150, 50);
		add(btnVerCatalogo);
		
		JButton btnHacerDevolucion = new JButton("Hacer Devolucion");
		btnHacerDevolucion.setBounds(128,147, 150, 50);
		add(btnHacerDevolucion);
		
	}
}
