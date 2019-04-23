package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Cliente;

public class BD_Clientes extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
	public int darAltaCliente(Cliente cl) {
		cadenaSQL = "INSERT INTO clientes VALUES('" + cl.getCodCliente() + "','" + cl.getDireccion() + "','" + cl.getNumTarjeta() + "')";
		
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

	public int darBajaCliente(String codCliente) {
		cadenaSQL = "DELETE FROM clientes WHERE cod_cliente ='" + codCliente + "'";
		
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
