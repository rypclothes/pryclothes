package bbdd;
//Daniel Cirtog y Pablo Martin

//Se ha borrado exception problemas tecnicos y error en DatosIntroducidosException

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Usuario;
import exceptions.DatosIntroducidosException;

public class BD_Usuario extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
	public BD_Usuario() {
		super();
	}
	
	public int darAltaUsuario(Usuario usu) throws DatosIntroducidosException {
		String cadena="INSERT INTO usuarios VALUES('" + usu.getNombre() + "','" + usu.getContraseña()+"','"+ usu.getFechaAlta() + "','" + usu.getRol() + "','" + usu.getCodigo() + "','" + usu.getTelefono() + "')"; 	
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
			throw new DatosIntroducidosException("Los datos introducidos son incorrectos");
		}
	}

	public int darBajaUsuario(String codigo) throws DatosIntroducidosException {
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
			throw new DatosIntroducidosException("Algun dato no esta bien introducido");
			
		}
	}

	
}
