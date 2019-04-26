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
	
	public BD_Incidencias(String bbdd) {
		super(bbdd);
		// TODO Auto-generated constructor stub
	}
	public  int añadir_Incidencia(Incidencia incidencia) {
		String cadenaSQL="INSERT INTO reporte_incidencias (tipo_incidencia,cod_emple,fecha_error) VALUES('" + incidencia.getTipoIncidencia()+ "','" +
				incidencia.getCodEmple()+"','"+incidencia.getFechaError()+"')"; 	
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
	public int borrar_Incidencias(String cod_emple, String num_incidencia,LocalDate fecha_error ){
		String cadena="DELETE FROM reporte_incidencias WHERE cod_emple='" + cod_emple + "' AND fecha_error' "+ fecha_error + "' AND num_incidencia=' "+ num_incidencia;	
		
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

	
	public  Vector<String> listadoIncidencias(){
		String cadenaSQL="SELECT * from reporte_incidencias";
		Vector<String> listaIncidencias=new Vector<String>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaIncidencias.add(reg.getString(1));
			}			
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			return null;
			
		}
	}
	
	

}



