package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modelos.Dise�o;



public class BD_Dise�o extends BD_Conector {
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Dise�o(){
		super();
	}
	
	public  int a�adir_Dise�o( Dise�o dise�os) {
		String cadenaSQL="INSERT INTO dise�os VALUES('"+dise�os.getFecha_salida()+"','"+
			   dise�os.getDescripcion()+"','"+dise�os.getPrecio()+"','"+dise�os.getCategoria()+"','"+dise�os.getCodDise�o()+"','"+dise�os.getCantidad()+"')";
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
	
	public Vector<String> listadoCod_dise�o(){
		String cadenaSQL="SELECT cod_dise�o from dise�os";
		Vector<String> listadoCod_dise�o=new Vector<String>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
					listadoCod_dise�o.add(reg.getString(1));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoCod_dise�o;
	
	}
	
	 public int borraDise�o(String cod_dise�oBorrar ) {
		 String cadenaSQL="DELETE FROM dise�os Where cod_dise�o='"+cod_dise�oBorrar+"'";
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
