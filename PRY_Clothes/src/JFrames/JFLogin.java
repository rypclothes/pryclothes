package JFrames;

import javax.swing.*;

import JPanels.*;
import java.awt.*;

public class JFLogin extends JFrame{
	private PNLDatosUsuLogin panelLogin;
	
	public JFLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFLogin.class.getResource("/imagenes/rypclothes.png")));
		setTitle("PRY_CLOTHES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 214);
		setLocationRelativeTo(null);
		setResizable(true);
		getContentPane().setLayout(null);
		initialize();
	}
	
	
	private void initialize() {
		panelLogin = new PNLDatosUsuLogin();
		getContentPane().add(panelLogin);
	}
}
