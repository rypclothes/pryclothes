package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Aviso;
import modelos.Diseño;

/**
 * 
 * @author Daniel
 *
 */

public class BD_Aviso extends BD_Conector{
	private static Statement s;	  
	private static ResultSet reg;
	
	/**
	 * Genera un aviso en la base de datos
	 * @param av
	 * @return 1 si se ha añadido con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
	public int anotarAviso(Aviso av) throws DatosIntroducidosException {
		
		String cadenaSQL = "INSERT INTO avisos VALUES('" + av.getCodEmple() + "','" + av.getMotivo() + "','" + av.getFecha() + "')";
		
		try {
			this.abrir();
			
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Los datos introducidos son incorrectos");
		}
	}
	
	/**
	 * Muestra todos los avisos de la base de datos
	 * @return Vector de Avisos
	 * @throws DatosIntroducidosException
	 */
	public Vector<Aviso> mostrarAvisos() throws DatosIntroducidosException{
		String cadenaSQL = "SELECT * FROM avisos";
		Vector<Aviso> avisos=new Vector<Aviso>();
		
		try {
			this.abrir();
			
			s=c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				java.sql.Date fecha = reg.getDate("fecha_aviso");
				LocalDate fechaBuena = fecha.toLocalDate();
				avisos.add(new Aviso(reg.getString("cod_emple"), fechaBuena, reg.getString("motivo")));
			}
			s.close();
			return avisos;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("No se pueden mostrar los datos en este momento.");
		}
	}
	
	/**
	 * Muestra los avisos de un cliente en concreto
	 * @param cod_emple
	 * @return Vector de avisos
	 * @throws DatosIntroducidosException
	 */
	public Vector<Aviso> contarAvisos(String cod_emple) throws DatosIntroducidosException {
		String cadenaSQL="SELECT * FROM AVISOS WHERE COD_EMPLE ='"+cod_emple+"'";
		Vector<Aviso>avisos=new Vector<Aviso>();
		try {
			this.abrir();
			
			s=c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if(reg.next()) {
				java.sql.Date f=reg.getDate("fecha_aviso");
				LocalDate fBuena=f.toLocalDate();
				avisos.add(new Aviso(reg.getString("cod_emple"),fBuena,reg.getString("motivo")));
			}
			s.close();
			return avisos;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("No se pueden mostrar los datos en este momento.");
		}
		
	}

	/**
	 * Borra los avisos que haya en una fecha en concreto
	 * @param fecha
	 * @return 1 si se ha borrado con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
	public int borrarAviso(LocalDate fecha) throws DatosIntroducidosException {
		String cadenaSQL= "DELETE FROM avisos WHERE fecha_aviso = '" + fecha +"'";
		
		try {
			this.abrir();
			
			s= c.createStatement();
			int filas= s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("No se puede borrar ningun aviso en este momento.");
		}
	}
}