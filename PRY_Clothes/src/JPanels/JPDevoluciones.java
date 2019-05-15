package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class JPDevoluciones extends JPanel{
	
	public JPDevoluciones(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Compras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 451, 244); 
		
	}

}
