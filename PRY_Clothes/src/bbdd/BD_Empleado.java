package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import exceptions.DatosIntroducidosException;
import modelos.Empleado;
import modelos.Usuario;

/**
 * 
 * @author Pablo y Dani
 *
 */
public class BD_Empleado extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	private Vector <Empleado> empleados = new <Empleado> Vector();
	BD_Usuario bdu = new BD_Usuario();
	
	public BD_Empleado() {
		super();
	}
	
	/**
	 * Metodo para agregar un empleado a la base de datos
	 * @param em
	 * @return 1 si se ha añadido con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
	public int darAltaEmpleado(Empleado em) throws DatosIntroducidosException {
		Usuario usu = new Usuario(em.getContraseña(),em.getNombre(),em.getTelefono(),em.getFuncion());
		bdu.darAltaUsuario(usu);
		
		cadenaSQL = "INSERT INTO empleados VALUES('" + em.getCodEmple() + "','" + em.getFuncion() + "','" + em.getSalario() + "','" + em.getNumAvisos() +"')";
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
	 * Elimina a un empleado
	 * @param codigo
	 * @return 1 si se ha eliminado con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
	public int darBajaEmpleado(String codigo) throws DatosIntroducidosException {
		cadenaSQL = "DELETE FROM empleados WHERE cod_emple ='" + codigo + "'";
		int filas;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			
			bdu.darBajaUsuario(codigo);
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Algun dato no esta bien introducido");
		}
	}

	/**
	 * Busca a un empleado por su codigo
	 * @param codEmple
	 * @return el empleado encontrado
	 */
	public Empleado buscarEmpleado(String codEmple){
		Empleado emp=null;
		
		String cadenaSQL = "SELECT * FROM empleados WHERE cod_emple = '" + codEmple + "'";
				
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next())
				emp=new Empleado(reg.getString("cod_emple"),reg.getString("funcion"),reg.getDouble("salario"));
			
			s.close();
			this.cerrar();
			
			return emp;
		}catch(SQLException e) {
			return null;
		} 
	}

	/**
	 * Muestra todos los empleados de la base de datos
	 * @return Vector de Empleados
	 * @throws DatosIntroducidosException
	 */
	public Vector <Empleado> mostrarEmpleados() throws DatosIntroducidosException{
		Vector <Empleado> empleados = new <Empleado> Vector();
		cadenaSQL = "SELECT * FROM empleados";
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				empleados.add(new Empleado(reg.getString("cod_emple"),reg.getString("funcion"),reg.getDouble("salario")));
			}
			s.close();
			
			this.cerrar();
			return empleados;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido problemas con la BBDD");
		}
	}
}
