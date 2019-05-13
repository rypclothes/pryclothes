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
	/*jj*/
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
	   /*jajaj*/
	 public Vector <Dise�o> consultar_Dise�os() {
			 Vector <Dise�o> mostrar = new <Dise�o> Vector();
			 String cadenaSQL = "SELECT * FROM dise�os";
			 
			 try {
				 this.abrir();
				 
				 s = c.createStatement();
				 reg = s.executeQuery(cadenaSQL);
				 
				 while(reg.next()) {
					mostrar.add(new Dise�o(reg.getInt("cantidad"),reg.getString("cod_dise�o"))); 
				 }
				 s.close();
				
				 this.cerrar();
			 }catch(SQLException e) {
				 this.cerrar();
				 e.printStackTrace();
			 }
			 return mostrar;
		 }
	   
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
}