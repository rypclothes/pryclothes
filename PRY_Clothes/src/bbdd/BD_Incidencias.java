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
	public  int añadir_Incidencia(Incidencia in) {
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
	public int borrar_Incidencias(String cod_emple,LocalDate fecha_error ){
		String cadena="DELETE FROM reporte_incidencias WHERE cod_emple='" + cod_emple + "' AND fecha_error' "+ fecha_error;	
		
		try{
		this.abrir();
		s=c.createStatement();
		int filas=s.executeUpdate(cadena);	
		s.close();
		this.cerrar();
		return filas;
		
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}

	public  Vector <Incidencia> listadoIncidencias(){
		String cadenaSQL="SELECT * from reporte_incidencias WHERE solucionado = 0";
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
	
	public int solucionarIncidencia(int numIncidencia) throws DatosIntroducidosException {
		String cadenaSQL = "UPDATE reporte_incidencias SET solucionado = 1 WHERE num_incidencia='" + numIncidencia +"'";
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



