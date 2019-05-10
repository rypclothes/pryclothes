package JPanels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;

public class JPDespedirEmple extends JPanel {
	private JTextField JTFCodEmple;

	public JPDespedirEmple() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Despido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 294, 94);
		initialize();
	}
	
	public void initialize() {
		JLabel lblIntroduceCdigoDe = new JLabel("Introduce c\u00F3digo de empleado para despedir:");
		lblIntroduceCdigoDe.setBounds(26, 24, 276, 16);
		add(lblIntroduceCdigoDe);
		
		JLabel lblCdigoEmpleado = new JLabel("C\u00F3digo empleado");
		lblCdigoEmpleado.setBounds(26, 66, 115, 16);
		add(lblCdigoEmpleado);
		
		JTFCodEmple = new JTextField();
		JTFCodEmple.setBounds(145, 63, 116, 22);
		add(JTFCodEmple);
		JTFCodEmple.setColumns(10);
	}
	
	public String getDatos() {
		return JTFCodEmple.getText();
	}
}
