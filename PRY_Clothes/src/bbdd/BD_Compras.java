package bbdd;

import java.sql.*;

import exceptions.DatosIntroducidosException;
import modelos.Compra;

/**
 * 
 * @author Pablo
 *
 */
public class BD_Compras extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
	public int devolverNumFactura() throws DatosIntroducidosException {
		cadenaSQL = "SELECT MAX(SUBSTRING(factura,4)) FROM compras";
		int filas = 0;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				filas = reg.getInt(1);
			}
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un problema con la BBDD");
		}
	}
	
	public int darAltaCompra(Compra co) throws DatosIntroducidosException {
		cadenaSQL = "INSERT INTO compras VALUES('" + co.getFactura() + "','" + co.getPrecio() + "','" + co.getNumPrendas() + "','" + co.getCodCliente() + "','" + co.getFechaCompra() + "')";
		int filas;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un problema con la BBDD");
		}
	}

	public int darBajaCompra(String factura) throws DatosIntroducidosException {
		cadenaSQL = "DELETE FROM compras WHERE factura='" + factura + "'";
		int filas;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido un problema con la BBDD");
		}
	}
}