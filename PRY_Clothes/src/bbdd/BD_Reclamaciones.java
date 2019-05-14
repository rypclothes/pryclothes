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

public class BD_Reclamaciones extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Reclamaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Este metodo inserta una reclamaciones 
	public int a�adir_Reclamacion(Reclamacion re) {
		String cadenaSQL = "INSERT INTO reclamaciones VALUES('" + re.getCod_cliente() + "','" + re.getFecha_Rec()
				+ "','" + re.getDescripcion() + "','" + re.getRespuesta() + "')";
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

	// Este metodo es para modificar uno o varios campos en la tabla reclamaciones
	// buscando por cod_cliente y la fecha hora
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

	
	// Crea un vector en el que se lista todos los campos de la tabla reclamaciones
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

	// Devuelve un vector con todas las reclamaciones para luego en el date utilizar
	// dicho vector
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
