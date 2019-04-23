package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modelos.Empleado;

//Daniel Cirtog y Pablo Martin
public class BD_Empleado extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	private Vector <Empleado> empleados = new <Empleado> Vector();
	
	public BD_Empleado() {
		super();
	}
	
	public int darAltaEmpleado(Empleado em) {
		cadenaSQL = "INSERT INTO empleados VALUES('" +em.getCodEmple() + "','" + em.getFuncion() + "','" + em.getSalario() + "','" + em.getNumAvisos() +"')";
		int filas;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			return -1;
		}
			
	}

	public int darBajaEmpleado(String codigo) {
		cadenaSQL = "DELETE FROM empleados WHERE codigo ='" + codigo + "'";
		int filas;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			return -1;
		}
	}

	public Vector <Empleado> buscarEmple(String codigo){
		cadenaSQL = "SELECT * FROM empleados WHERE cod_emple ='" + codigo + "'";
		
		try {
			this.abrir();
			
			s = c.createStatement();
			s.executeQuery(cadenaSQL);
			s.close();
			
			this.cerrar();
		}catch(SQLException e) {
			this.cerrar();
			return null;
		}
		
		return empleados;
	}

	
}
