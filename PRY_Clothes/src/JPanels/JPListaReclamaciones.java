package JPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Rober
 *
 */

public class JPListaReclamaciones extends JPanel {

	public JPListaReclamaciones() {

		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reclamaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setLayout(null);
		setBounds(0, 0, 263, 244);

	}
}
