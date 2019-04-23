package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modelos.Diseño;



public class BD_Diseño extends BD_Conector {
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Diseño(){
		super();
	}
	
	public  int añadir_Diseño( Diseño diseños) {
		String cadenaSQL="INSERT INTO diseños VALUES('"+diseños.getFecha_salida()+"','"+
			   diseños.getDescripcion()+"','"+diseños.getPrecio()+"','"+diseños.getCategoria()+"','"+diseños.getCodDiseño()+"','"+diseños.getCantidad()+"')";
		try {
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
			
		}catch(SQLException e) {
			return -1;
		}
	}
	
	public Vector<String> listadoCod_diseño(){
		String cadenaSQL="SELECT cod_diseño from diseños";
		Vector<String> listadoCod_diseño=new Vector<String>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
					listadoCod_diseño.add(reg.getString(1));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoCod_diseño;
	
	}
	
	 public int borraDiseño(String cod_diseñoBorrar ) {
		 String cadenaSQL="DELETE FROM diseños Where cod_diseño='"+cod_diseñoBorrar+"'";
		 String tipo="";
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
}
