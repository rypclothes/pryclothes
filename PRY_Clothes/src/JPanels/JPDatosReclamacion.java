package JPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.TextArea;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.sun.org.apache.xml.internal.serializer.ToXMLSAXHandler;

import modelos.Reclamacion;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Pablo
 *
 */

public class JPDatosReclamacion extends JPanel {
	private JTextField TXFFecha;
	JTextArea TXTADescripcion = new JTextArea();
	JTextArea TXTARespuesta = new JTextArea();

	public JPDatosReclamacion() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion reclamacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setBounds(0, 0, 263, 244);
		initialize();
	}
	
	public void initialize() {
		TXTADescripcion.setBounds(10, 72, 243, 59);
		add(TXTADescripcion);
		
		JLabel LBLDescripcion = new JLabel("Descripci\u00F3n");
		LBLDescripcion.setBounds(10, 51, 97, 14);
		add(LBLDescripcion);
		
		JLabel LBLFecha = new JLabel("Fecha");
		LBLFecha.setBounds(66, 26, 61, 14);
		add(LBLFecha);
		
		TXFFecha = new JTextField();
		TXFFecha.setBounds(107, 23, 86, 20);
		add(TXFFecha);
		TXFFecha.setColumns(10);
		
		JLabel LBLRespuesta = new JLabel("Respuesta");
		LBLRespuesta.setBounds(10, 142, 107, 14);
		add(LBLRespuesta);
		
		TXTARespuesta.setBounds(10, 158, 243, 75);
		add(TXTARespuesta);
	}
	
	public void setDatos(Reclamacion re) {
		TXFFecha.setText(String.valueOf(re.getFecha_Rec()));
		TXTADescripcion.setText(re.getDescripcion());
	}
	
	public void setInhabilitado() {
		TXFFecha.setEnabled(false);
		TXTADescripcion.setEnabled(false);
	}
	
	public Reclamacion getDatos(String cod) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaBuena = LocalDate.parse(TXFFecha.getText(), formato);
		String descripcion = TXTADescripcion.getText();
		return new Reclamacion(fechaBuena,cod,TXTARespuesta.getText(),descripcion);
	}
	
	public void limpiarRespuesta() {
		TXTARespuesta.setText("");
	}
}
