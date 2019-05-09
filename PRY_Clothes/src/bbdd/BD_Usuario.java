package bbdd;
//Daniel Cirtog y Pablo Martin

//Se ha borrado exception problemas tecnicos y error en DatosIntroducidosException

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

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

	public int consultaNumeroSecuencialCliente() {
		cadenaSQL = "SELECT MAX(SUBSTRING(cod_cliente,3)) FROM clientes WHERE SUBSTRING(cod_cliente,1,1) = 'C'";
		int filas = 0;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if(reg.next()){
				filas = reg.getInt(1);
			}
			
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			return -1;
		}
	}

	public int consultaNumeroSecuencialEmpleado() {
		cadenaSQL = "SELECT MAX(SUBSTRING(cod_emple,3)) FROM empleados WHERE SUBSTRING(cod_emple,1,1) = 'E'";
		int filas = 0;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if(reg.next()){
				filas = reg.getInt(1);
			}
			
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			return -1;
		}
	}

	public String inicioSesion(Usuario usu) throws DatosIntroducidosException {
		cadenaSQL = "SELECT rol FROM usuarios WHERE nombre ='" + usu.getNombre() + "' AND contraseña ='" + usu.getContraseña() + "'";
		String resultado = null;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				resultado = reg.getString("rol");
			}
			s.close();
			
			this.cerrar();
			return resultado;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un error en la bbdd");
		}
	}
}