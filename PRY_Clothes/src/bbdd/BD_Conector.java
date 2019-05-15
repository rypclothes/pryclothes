package bbdd;

import java.sql.*;


public class BD_Conector {
	static private String base;
	static private String usuario;
	static private String pass;
	static private String url;
	static protected Connection c;
	
	public BD_Conector() {
		
	}

	/**
	 * Inicia la base de datos
	 * @param bbdd
	 */
	public static void BD_Ini(String bbdd){		
		base=bbdd;
		usuario="root";
		pass="";
		url="jdbc:mysql://localhost/"+base;
	}
	
	/**
	 * Abre la base de datos
	 */
	public void abrir(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
		 	c=DriverManager.getConnection(url,usuario,pass);
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	
	}	
	
	/**
	 * Cierra la base de datos
	 */
	public void cerrar(){
		try{
			c.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}
	
}
