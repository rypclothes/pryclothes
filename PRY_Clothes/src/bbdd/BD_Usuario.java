package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

import modelos.Cliente;
import modelos.Usuario;
import exceptions.DatosIntroducidosException;

/**
 * 
 * @author Pablo y Daniel
 *
 */
public class BD_Usuario extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
	public BD_Usuario() {
		super();
	}

	/**
	 * Modifica cualquier campo de un usuario
	 * @param cod
	 * @param campo
	 * @param valor
	 * @return verdadero si se ha podido aplicar sin errores o falso
	 */
	public boolean modificarCampoUsuario(String cod, String campo, String valor) {
		cadenaSQL="UPDATE USUARIOS SET " + campo + " = '" + valor + "' where cod ='" + cod + "'";
		
		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return true;

		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
	}
	
	/**
	 * Añade un usuario a la base de datos
	 * @param usu
	 * @return 1 si se ha añadido con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
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

	/**
	 * Eliminar un usuario de la base de datos a traves de su codigo
	 * @param codigo
	 * @return 1 si se ha borrado con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
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

	/**
	 * Consulta del maximo numero de clientes para la gestion de los codigos de los mismos
	 * @return Maximo numero obtenido
	 */
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

	/**
	 * Consulta del maximo numero de empleados para la gestion de los codigos de los mismos
	 * @return Maximo numero obtenido
	 */
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
	
	/**
	 * Busca a un usuario por nombre
	 * @param nombre
	 * @return Usuario encontrado
	 * @throws DatosIntroducidosException
	 */
	public Usuario buscarUsuarioDatos(String nombre) throws DatosIntroducidosException {
		cadenaSQL="SELECT * FROM USUARIOS WHERE nombre ='" + nombre + "'";
		Usuario u=null;
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				java.sql.Date f=reg.getDate("fecha_alt");
				LocalDate fBuena=f.toLocalDate();
				u =new Usuario(reg.getString("cod"),reg.getString("contraseña"),reg.getString("nombre"),reg.getString("telefono"),fBuena);
			}
			s.close();
			
			this.cerrar();
			return u;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un error en la bbdd");
		}		
	}
	
	/**
	 * Busca un cliente por nombre
	 * @param nombre
	 * @return Cliente
	 * @throws DatosIntroducidosException
	 */
	public Cliente buscarClienteDatos(String nombre) throws DatosIntroducidosException {
		cadenaSQL="SELECT * FROM USUARIOS WHERE nombre ='" + nombre + "'";
		Usuario u=null;
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				java.sql.Date f=reg.getDate("fecha_alt");
				LocalDate fBuena=f.toLocalDate();
				u =new Usuario(reg.getString("cod"),reg.getString("contraseña"),reg.getString("nombre"),reg.getString("telefono"),fBuena);
			}
			s.close();
			
			this.cerrar();
			
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un error en la bbdd");
		}
		
		cadenaSQL="SELECT * FROM Clientes WHERE cod_cliente ='" + u.getCodigo() + "'";
		Cliente cli=null;
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				
				cli =new Cliente(u.getCodigo(),u.getContraseña(),u.getNombre(),u.getTelefono(),u.getFechaAlta(),reg.getLong("num_tarjeta"),reg.getString("direccion"));
			}
			s.close();
			
			this.cerrar();
			return cli;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un error en la bbdd");
		}
		
		
	}

	/**
	 * Metodo para iniciar sesion a traves de nombre de usuario y contraseña
	 * @param usu
	 * @return Tipo de usuario que encuentra con los datos recibidos
	 * @throws DatosIntroducidosException
	 */
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