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
	
	/**
	 * Crea un diseño en la base de datos
	 * @param diseños
	 * @return 1 si se ha añadido con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
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
	
	/**
	 * Devuelve todos los codigos de diseño de la base de datos
	 * @return Vector de String
	 */
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
	
	/**
	 * Lista todas las prendas de una misma categoria
	 * @param cat
	 * @return Vector de Diseños
	 */
	public Vector <Diseño> listadoPrendasCat(String cat){
		String cadenaSQL="SELECT * FROM diseños where categoria = '"+ cat +"' ";
		Vector <Diseño> listadoDiseños = new Vector <Diseño>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
				 listadoDiseños.add(new Diseño(reg.getString("descripcion"),reg.getDouble("precio"),reg.getString("categoria"),reg.getString("cod_diseño")));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoDiseños;
	
	}
	
	/**
	 * Lista todos los diseños completos	
	 * @return Vector de diseños
	 */
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
	
	/**
	 * Borra un diseño cuyo codigo es pasado por parametro
	 * @param cod_diseñoBorrar
	 * @return 1 si se ha borrado con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
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
	 
	 /**
	  * Metodo para modificar algun campo
	  * @param modificador
	  * @param campo
	  * @param buscacod_diseño
	  * @return 1 si se ha modificado con exito, 0 si hay algun dato mal introducido o una excepcion
	  */
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
	   
	   /**
	    * Consulta el numero del diseño con el codigo mas alto para la gestion de los codigos de los diseños
	    * @return el codigo mas alto
	    */
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
		
		/**
		 * Metodo para rellenar el almacen
		 * @param codDis
		 * @param cantidad
		 * @return 1 si se ha modificado con exito, 0 si hay algun dato mal introducido o una excepcion
		 * @throws DatosIntroducidosException
		 */
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
		
		/**
		 * Resta la cantidad seleccionada al realizar una venta
		 * @param codDiseño
		 * @param cantidad
		 * @return 1 si se ha realizado con exito, 0 si hay algun dato mal introducido o -1 si ha habido un error
		 */
		public int restarCantidad(String codDiseño, int cantidad) {
			String cadenaSQL = "UPDATE diseños SET cantidad = (cantidad - '" + cantidad + "') WHERE cod_diseño ='" + codDiseño + "'";
			
			try {
				this.abrir();
				
				s = c.createStatement();
				int filas = s.executeUpdate(cadenaSQL);
				s.close();
				
				this.cerrar();
				return filas;
			}catch(SQLException e) {
				this.cerrar();
				return -1;
			}
		}
}