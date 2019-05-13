package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import exceptions.DatosIntroducidosException;
import modelos.Diseño;

/**
 * 
 * @author Yandry
 *
 */
public class BD_Diseño extends BD_Conector {
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Diseño(){
		super();
	}
	
	public  int añadir_Diseño(Diseño diseños) {
		String cadenaSQL="INSERT INTO diseños (fecha_salida,descripcion,precio,categoria,cod_diseño) VALUES('"+diseños.getFecha_salida()+"','"+
			   diseños.getDescripcion()+"','"+diseños.getPrecio()+"','"+diseños.getCategoria()+"','"+diseños.getCodDiseño()+"')";
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
	
	public Vector <String> listadoCod_diseño(){
		String cadenaSQL="SELECT cod_diseño FROM diseños";
		Vector <String> listadoCod_diseño = new Vector <String>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
					listadoCod_diseño.add(reg.getString("cod_diseño"));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoCod_diseño;
	
	}
	
	public Vector <Diseño> listado(){
		String cadenaSQL="SELECT * FROM diseños";
		Vector <Diseño> listadoDiseños = new Vector <Diseño>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
				 listadoDiseños.add(new Diseño(reg.getInt("cantidad"),reg.getString("cod_diseño")));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoDiseños;
	
	}
	/*jj*/
	 public int borraDiseño(String cod_diseñoBorrar) {
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
					this.cerrar();
					return -1;
				
				}  
	 }
	 
	 public int modificar_datos(String modificador,String campo,String buscacod_diseño) {
		   
		   String cadenaSQL="UPDATE diseños set "+campo+"='"+modificador+"'where cod_diseño='"+buscacod_diseño+"'";
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
	   /*jajaj*/
	 public Vector <Diseño> consultar_Diseños() {
			 Vector <Diseño> mostrar = new <Diseño> Vector();
			 String cadenaSQL = "SELECT * FROM diseños";
			 
			 try {
				 this.abrir();
				 
				 s = c.createStatement();
				 reg = s.executeQuery(cadenaSQL);
				 
				 while(reg.next()) {
					mostrar.add(new Diseño(reg.getInt("cantidad"),reg.getString("cod_diseño"))); 
				 }
				 s.close();
				
				 this.cerrar();
			 }catch(SQLException e) {
				 this.cerrar();
				 e.printStackTrace();
			 }
			 return mostrar;
		 }
	   
		public int consultaNumeroSecuencialDiseño() {
			String cadenaSQL = "SELECT MAX(SUBSTRING(cod_diseño,4)) FROM diseños";
			int filas = 0;
			
			try {
				this.abrir();
				
				s = c.createStatement();
				reg = s.executeQuery(cadenaSQL);
				if(reg.next()){
					filas = reg.getInt(1);
				}
				
				return filas;
			}catch(SQLException e) {
				this.cerrar();
				return -1;
			}
		}
		
		public int hacerPedido(String codDis, int cantidad) throws DatosIntroducidosException {
			String cadenaSQL = "UPDATE diseños SET cantidad =(cantidad + '" + cantidad + "') WHERE cod_diseño ='" + codDis + "'";
			
			try {
				this.abrir();
				
				s = c.createStatement();
				int filas = s.executeUpdate(cadenaSQL);
				s.close();
				
				this.cerrar();
				return filas;
			}catch(SQLException e) {
				this.cerrar();
				throw new DatosIntroducidosException("Ha habido un problema con la base de datos");
			}
		}
}