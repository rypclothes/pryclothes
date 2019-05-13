package principal;

import java.awt.EventQueue;
import java.util.*;
import JFrames.JFLogin;
import bbdd.BD_Conector;

/**
 * 
 * Interfaz grafica: Pablo, Roberto, Daniel
 * Main de repuesto: Yandry, Mario
 *
 */
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BD_Conector.BD_Ini("ryp_clothes");
					JFLogin window = new JFLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

