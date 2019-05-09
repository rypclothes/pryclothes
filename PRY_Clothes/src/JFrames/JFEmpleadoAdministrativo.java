package JFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class JFEmpleadoAdministrativo extends JFrame {

	private JPanel contentPane;

	
	public JFEmpleadoAdministrativo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFEmpleadoAdministrativo.class.getResource("/imagenes/rypclothes.png")));
		setTitle("Perfil Empleado Administrativo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}

}
