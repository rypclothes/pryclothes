package JFrames;

import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelos.Venta;
import java.awt.Font;
import javax.swing.JTextField;

import bbdd.BD_Reclamaciones;
import modelos.Reclamacion;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFEscribirReclamacion extends JFrame{
	private JTextField textField;
	private BD_Reclamaciones bdr=new BD_Reclamaciones();
	public JFEscribirReclamacion(String cod_cliente) {
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFCliente.class.getResource("/imagenes/rypclothes.png")));
		setBounds(100, 100, 406, 280);
		setTitle("Escribir Reclamacion");
		JLabel lblEsteEsEl = new JLabel("A continuacion escriba una descripcion de la reclamacion");
		lblEsteEsEl.setBounds(33, 13, 329, 39);
		getContentPane().add(lblEsteEsEl);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescripcion.setBounds(134, 65, 106, 24);
		getContentPane().add(lblDescripcion);
		
		textField = new JTextField();
		textField.setBounds(12, 95, 364, 82);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Reclamacion rec=new Reclamacion(cod_cliente,textField.getText());
				
				if(bdr.añadir_Reclamacion(rec)!=-1) {
					
					JOptionPane.showMessageDialog(null, "Reclamacion enviada correctamente", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Algún dato no se ha introducido correctamente!", "AVISO", JOptionPane.ERROR_MESSAGE);
				dispose();
			}
		});
		btnEnviar.setBounds(33, 190, 127, 30);
		getContentPane().add(btnEnviar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(222, 190, 127, 30);
		getContentPane().add(btnCancelar);
		
		
		
	}
}
