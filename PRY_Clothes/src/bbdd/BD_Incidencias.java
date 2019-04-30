package bbdd;

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
	public  int a�adir_Incidencia(Incidencia incidencia) {
		String cadenaSQL="INSERT INTO reporte_incidencias VALUES('" + incidencia.getCodEmple() + "','" + incidencia.getTipoIncidencia() + "','" + incidencia.getFechaError() + "','" + incidencia.getNum_incidencia() + "')"; 	
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
	
	public int borrar_Incidencias(String cod_emple, String num_incidencia ){
		String cadena="DELETE FROM reporte_incidencias WHERE cod_emple='" + cod_emple + "' AND num_incidencia= "+ num_incidencia;	
		
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
		String cadenaSQL="SELECT * FROM reporte_incidencias";
		Vector <Incidencia> listaIncidencias=new Vector <Incidencia>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				java.sql.Date f=reg.getDate("fecha_error");
				LocalDate fBuena=f.toLocalDate();
				listaIncidencias.add(new Incidencia(fBuena, reg.getString("cod_emple"), reg.getString("tipo_incidencia"),0));
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
	
	public int consultaNumIncidencia() {
		String cadenaSQL = "SELECT MAX(num_incidencia) FROM reporte_incidencias";
		int resultado = 0;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if(reg.next()) {
				resultado = reg.getInt(1);
			}
			s.close();
			
			this.cerrar();
			return resultado;
		}catch(SQLException e) {
			this.cerrar();
			return -1;
		}
	}

}



