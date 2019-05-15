package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import exceptions.DatosIntroducidosException;
import modelos.Dise�o;

/**
 * 
 * @author Yandry
 *
 */
public class BD_Dise�o extends BD_Conector {
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Dise�o(){
		super();
	}
	
	/**
	 * Crea un dise�o en la base de datos
	 * @param dise�os
	 * @return 1 si se ha a�adido con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
	public  int a�adir_Dise�o(Dise�o dise�os) {
		String cadenaSQL="INSERT INTO dise�os (fecha_salida,descripcion,precio,categoria,cod_dise�o) VALUES('"+dise�os.getFecha_salida()+"','"+
			   dise�os.getDescripcion()+"','"+dise�os.getPrecio()+"','"+dise�os.getCategoria()+"','"+dise�os.getCodDise�o()+"')";
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
	 * Devuelve todos los codigos de dise�o de la base de datos
	 * @return Vector de String
	 */
	public Vector <String> listadoCod_dise�o(){
		String cadenaSQL="SELECT cod_dise�o FROM dise�os";
		Vector <String> listadoCod_dise�o = new Vector <String>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
					listadoCod_dise�o.add(reg.getString("cod_dise�o"));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoCod_dise�o;
	
	}
	
	/**
	 * Lista todas las prendas de una misma categoria
	 * @param cat
	 * @return Vector de Dise�os
	 */
	public Vector <Dise�o> listadoPrendasCat(String cat){
		String cadenaSQL="SELECT * FROM dise�os where categoria = '"+ cat +"' ";
		Vector <Dise�o> listadoDise�os = new Vector <Dise�o>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
				 listadoDise�os.add(new Dise�o(reg.getString("descripcion"),reg.getDouble("precio"),reg.getString("categoria"),reg.getString("cod_dise�o")));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoDise�os;
	
	}
	
	/**
	 * Lista todos los dise�os completos	
	 * @return Vector de dise�os
	 */
	public Vector <Dise�o> listado(){
		String cadenaSQL="SELECT * FROM dise�os";
		Vector <Dise�o> listadoDise�os = new Vector <Dise�o>();
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 while ( reg.next()){
				 listadoDise�os.add(new Dise�o(reg.getInt("cantidad"),reg.getString("cod_dise�o")));
				}	
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoDise�os;
	
	}
	
	/**
	 * Borra un dise�o cuyo codigo es pasado por parametro
	 * @param cod_dise�oBorrar
	 * @return 1 si se ha borrado con exito, 0 si hay algun dato mal introducido o una excepcion
	 */
	 public int borraDise�o(String cod_dise�oBorrar) {
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
					this.cerrar();
					return -1;
				
				}  
	 }
	 
	 /**
	  * Metodo para modificar algun campo
	  * @param modificador
	  * @param campo
	  * @param buscacod_dise�o
	  * @return 1 si se ha modificado con exito, 0 si hay algun dato mal introducido o una excepcion
	  */
	 public int modificar_datos(String modificador,String campo,String buscacod_dise�o) {
		   
		   String cadenaSQL="UPDATE dise�os set "+campo+"='"+modificador+"'where cod_dise�o='"+buscacod_dise�o+"'";
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
	    * Consulta el numero del dise�o con el codigo mas alto para la gestion de los codigos de los dise�os
	    * @return el codigo mas alto
	    */
		public int consultaNumeroSecuencialDise�o() {
			String cadenaSQL = "SELECT MAX(SUBSTRING(cod_dise�o,4)) FROM dise�os";
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
			String cadenaSQL = "UPDATE dise�os SET cantidad =(cantidad + '" + cantidad + "') WHERE cod_dise�o ='" + codDis + "'";
			
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
		 * @param codDise�o
		 * @param cantidad
		 * @return 1 si se ha realizado con exito, 0 si hay algun dato mal introducido o -1 si ha habido un error
		 */
		public int restarCantidad(String codDise�o, int cantidad) {
			String cadenaSQL = "UPDATE dise�os SET cantidad = (cantidad - '" + cantidad + "') WHERE cod_dise�o ='" + codDise�o + "'";
			
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