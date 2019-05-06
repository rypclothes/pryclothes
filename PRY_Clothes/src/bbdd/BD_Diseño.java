package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
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
	
	public int buscaNumero(String bus) {
		String cadenaSQL="SELECT MAX(SUBSTRING(cod_diseño,1,2)='"+bus+"') from diseños";
		int num=0;
		try {
			this.abrir();
			 s = c.createStatement();
			 reg=s.executeQuery(cadenaSQL);
			 if ( reg.next()){
				num=reg.getInt(1);
				}	
			 s.close();
			 this.cerrar();
			 return num;
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
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
			 s.close();
			 this.cerrar();
		}catch(SQLException e) {
			this.cerrar();
			System.out.println(e.getMessage());
			return null;
		}
		
		return listadoCod_diseño;
	
	}
	/*jj*/
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
					mostrar.add(new Diseño(reg.getDate("fecha_salida").toLocalDate(),reg.getString("descripcion"),reg.getDouble("precio"),reg.getString("categoria"),reg.getInt("cantidad"))); 
				 }
				 s.close();
				
				 this.cerrar();
			 }catch(SQLException e) {
				 this.cerrar();
				 e.printStackTrace();
			 }
			 return mostrar;
		 }
	  public Vector <Diseño> mostrar_Diseño(String buscado,String campoBuscar ){
			 Vector <Diseño> mostrar = new <Diseño> Vector();
			   
			   String cadenaSQL="SELECT * FROM diseños  where "+campoBuscar+"='"+buscado+"'";
			 try {
				 this.abrir();
				 
				 s = c.createStatement();
				 reg = s.executeQuery(cadenaSQL);
				 
				 while(reg.next()) {
					mostrar.add(new Diseño(reg.getDate("fecha_salida").toLocalDate(),reg.getString("descripcion"),reg.getDouble("precio"),reg.getString("categoria"),reg.getInt("cantidad"),reg.getString("cod_diseño"))); 
				 }
				 s.close();
				
				 this.cerrar();
			 }catch(SQLException e) {
				 this.cerrar();
				 e.printStackTrace();
			 }
			 return mostrar;
	  }
	 
	 public  Vector <Diseño> mostrar_diseñofecha(LocalDate fechaIni) {
		 Vector <Diseño> mostrarDiseñofecha = new <Diseño> Vector();
		 String cadenaSQL="SELECT * FROM diseños where fecha_salida between '"+fechaIni+"' and  '"+LocalDate.now()+"'";
		 		try {
		 			this.abrir();
		 			 s = c.createStatement();
					 reg = s.executeQuery(cadenaSQL);
					 while(reg.next()) {
							mostrarDiseñofecha.add(new Diseño(reg.getDate("fecha_salida").toLocalDate(),reg.getString("descripcion"),reg.getDouble("precio"),reg.getString("categoria"),reg.getInt("cantidad"),reg.getString("cod_diseño"))); 
						 }
						 s.close();
						
						 this.cerrar();
					 }catch(SQLException e) {
						 this.cerrar();
						 e.printStackTrace();
					 }
		 		return mostrarDiseñofecha;
		 		
		 		}
	 
	 
	 
		 
	 }
	     

