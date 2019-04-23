package bbdd;
//Daniel Cirtog y Pablo Martin

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Usuario;

public class BD_Usuario extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
	public BD_Usuario() {
		super();
	}
	
	public int darAltaUsuario(Usuario usu) {
		String cadena="INSERT INTO contactos VALUES('" + usu.getNombre() + "','" + usu.getContraseña()+"','"+ usu.getFechaAlta() +"','" + usu.getRol()+"')"; 	
		int filas;
		
		try{
			this.abrir();
			
			s=c.createStatement();
			filas = s.executeUpdate(cadena);
			s.close();
			
			this.cerrar();
			return filas;
		}catch (SQLException e){
			this.cerrar();
			return -1;
		}
	}

	public int darBajaUsuario(String codigo) {
		cadenaSQL = "DELETE FROM usuarios where cod = '" + codigo + "'";
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

	
}
