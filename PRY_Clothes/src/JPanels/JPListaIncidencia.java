package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class JPListaIncidencia extends JPanel {

	public JPListaIncidencia() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hacer pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 213, 94);
	}

}
