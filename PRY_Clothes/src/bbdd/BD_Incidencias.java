package bbdd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import modelos.Incidencia;


public class BD_Incidencias<incidencia> extends BD_Conector {
	private static Statement s;		
	private static ResultSet reg;
	
	public BD_Incidencias(String file) {
		super();
		// TODO Auto-generated constructor stub
	}
	public  int añadir_Incidencia(Incidencia in) {
		String cadenaSQL="INSERT INTO reporte_incidencias VALUES('" + in.getTipoIncidencia()+ "','" +
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
	public int borrar_Incidencias(String cod_emple,Date fecha_error ){
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

	public  Vector <Incidencia> listadoIncidencias(String cod_emple){
		String cadenaSQL="SELECT * from reporte_incidencias WHERE cod_emple='"+cod_emple+"'";
		Vector<Incidencia> listaIncidencias=new Vector<Incidencia>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				
				listaIncidencias.add(new Incidencia(reg.getDate(3), reg.getString(2), reg.getString(1)));
				
			}
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
}



