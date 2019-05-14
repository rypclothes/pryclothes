package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class JPListaPrendas extends JPanel{
	
	public JPListaPrendas(String categoria) {
		switch(categoria) {
		
		case "camiseta":
			
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Camisetas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

			setLayout(null);
			setBounds(0, 0, 263, 244);
			
			break;
		
		case "sudadera":
			
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sudaderas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

			setLayout(null);
			setBounds(0, 0, 263, 244);
			
			break;
			
		case "pantalon":
			
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pantalones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

			setLayout(null);
			setBounds(0, 0, 263, 244);
			
			break;	
		
		case "abrigo":
			
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Abrigos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

			setLayout(null);
			setBounds(0, 0, 263, 244); 
			
			break;
		
		}
		
	}

}
