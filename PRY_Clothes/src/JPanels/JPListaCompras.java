package JPanels;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
public class JPListaCompras extends JPanel{

	public JPListaCompras() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturas y Fechas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 263, 244);
		
	}
	
}
