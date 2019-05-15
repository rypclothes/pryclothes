package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Incidencia;

/**
 * 
 * @author Mario, corregido por Pablo
 *
 */
public class BD_Incidencias<incidencia> extends BD_Conector {
	private static Statement s;		
	private static ResultSet reg;
	
	public BD_Incidencias() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * A�ade una incidencia a la base de datos
	 * @param in
	 * @return 1 si se ha a�adido con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
	public  int a�adir_Incidencia(Incidencia in) {
		String cadenaSQL="INSERT INTO reporte_incidencias (tipo_incidencia, cod_emple, fecha_error)VALUES('" + in.getTipoIncidencia()+ "','" +
				in.getCodEmple()+"','"+in.getFechaError()+"')"; 	
				try{
				this.abrir();
				s=c.createStatement();
				int filas=s.executeUpdate(cadenaSQL);
				s.close();
				this.cerrar();
				return filas; 
				}
				catch ( SQLException e){			
					return -1;
				}
			}

	/**
	 * Muestra todas las incidencias de la base de datos
	 * @return Vector de Incidencias
	 */
	public  Vector <Incidencia> listadoIncidencias(){
		String cadenaSQL="SELECT * from reporte_incidencias ";
		Vector<Incidencia> listaIncidencias=new Vector<Incidencia>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				java.sql.Date fecha = reg.getDate("fecha_error");
				LocalDate fechaBuena = fecha.toLocalDate();
				listaIncidencias.add(new Incidencia(fechaBuena, reg.getString("cod_emple"), reg.getString("tipo_incidencia"), reg.getInt("num_incidencia")));
			}
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	/**
	 * Soluciona una incidencia
	 * @param numIncidencia
	 * @return 1 si se ha modificado con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
	public int solucionarIncidencia(int numIncidencia) throws DatosIntroducidosException {
		String cadenaSQL = "delete from reporte_incidencias WHERE num_incidencia='" + numIncidencia +"'";
		int filas = 0;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Problemas con la BBDD");
		}
	}
	
}



