/*
 * BD_Reclamaciones: Gestiona todos los movimientos en la base de datos relacionado con la tabla reclamaciones
 * @author Roberto_Saavedra
 */
package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Incidencia;
import modelos.Reclamacion;

/**
 * 
 * @author Roberto
 *
 */
public class BD_Reclamaciones extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Reclamaciones() {
		super();
	}
	
	/**
	 * Añade una reclamacion a la base de datos
	 * @param re
	 * @return 1 si se ha añadido con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
	public int añadir_Reclamacion(Reclamacion re) {
		String cadenaSQL = "INSERT INTO reclamaciones (cod_cliente,fecha_reclamacion,descripcion) VALUES('" + re.getCod_cliente() + "','" + re.getFecha_Rec()
				+ "','" + re.getDescripcion() + "')";
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * Elimina una reclamacion de la base de datos
	 * @param cod_cliente
	 * @param fecha_rec
	 * @return 1 si se ha borrado con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
	public int borrar_Reclamaciones(String cod_cliente, LocalDate fecha_rec) {
		String cadena = "DELETE FROM reclamaciones WHERE cod_cliente='" + cod_cliente + "' AND fecha_error ' "
				+ fecha_rec + "'";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return filas;

		} catch (SQLException e) {
			this.cerrar();
			return -1;
		}
	}
	
	/**
	 * Responde una reclamacion
	 * @param re
	 * @return un objeto Reclamacion relleno
	 * @throws DatosIntroducidosException
	 */
	public int responderReclamacion(Reclamacion re) throws DatosIntroducidosException {
		
		String cadenaSQL="UPDATE reclamaciones SET respuesta ='" + re.getRespuesta() + "' WHERE cod_cliente='" + re.getCod_cliente() + "' AND fecha_reclamacion='" + re.getFecha_Rec() + "' AND descripcion ='" + re.getDescripcion() + "'";
		int filas;
		try {
			this.abrir();
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un error en la BBDD");
		}
		
	}

	/**
	 * Modificar uno o varios campos en la tabla reclamaciones buscando por codigo de cliente y fecha
	 * @param cod
	 * @param fechaHora
	 * @param campos
	 * @param valor
	 * @return verdadero si se ha modificado o falso si se ha producido un error
	 */
	public boolean modificarCampoReclamaciones(String cod, LocalDate fechaHora, String campos[], String valor[]) {
		String cadenaSQL = "update reclamaciones ";
		for (int i = 0; i < campos.length; i++) {
			cadenaSQL += " SET '" + campos[i] + "' = '" + valor[i] + "'";
		}
		cadenaSQL += "WHERE cod_emple='" + cod + "' and fecha_reclamacion = '" + fechaHora + "'";

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
	 * Se listan todos los campos de la tabla reclamaciones
	 * @return Vector de reclamaciones
	 */
	public Vector<String> listadoCamposReclamaciones() {

		String cadenaSQL = "SHOW COLUMNS FROM RECLAMACIONES";
		Vector<String> listaReclamaciones = new Vector<String>();

		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			while (reg.next()) {
				listaReclamaciones.add(reg.getString(1));
			}
			s.close();
			this.cerrar();
			return listaReclamaciones;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/**
	 * Lista las reclamaciones con un codigo de cliente especificado
	 * @param cod
	 * @return Vector de Reclamaciones
	 */
	public Vector<Reclamacion> listadoMisReclamaciones(String cod) {

		String cadenaSQL = "SELECT * FROM reclamaciones WHERE cod_cliente ='"+cod+"'";
		Vector<Reclamacion> listaReclamaciones = new Vector<Reclamacion>();

		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaReclamaciones.add(new Reclamacion(reg.getString("cod_cliente"), reg.getString("descripcion"), reg.getString("respuesta")));
			}

			s.close();
			this.cerrar();
			return listaReclamaciones;

		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Devuelve las reclamaciones sin respuesta
	 * @return Vector de reclamaciones
	 */
	public Vector<Reclamacion> listadoReclamaciones() {

		String cadenaSQL = "SELECT * FROM reclamaciones WHERE respuesta is null";
		Vector<Reclamacion> listaReclamaciones = new Vector<Reclamacion>();

		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaReclamaciones.add(new Reclamacion(reg.getString("cod_cliente"), reg.getString("descripcion"), reg.getString("respuesta")));
			}

			s.close();
			this.cerrar();
			return listaReclamaciones;

		} catch (SQLException e) {
			return null;
		}
	}

}
