package bbdd;

import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Compra;
import modelos.Venta;

/**
 * 
 * @author Pablo
 *
 */

public class BD_Compras extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
	/**
	 * Lista las compras que haya en la base de datos que haya hecho un cliente en concreto
	 * @param cod
	 * @return Vector de Compras
	 */
	public Vector<Compra> listadoCompras(String cod){
		
		String cadenaSQL="SELECT * FROM Compras WHERE cod_cliente = '"+cod+"'";
		Vector<Compra> lista=new Vector<Compra>();
		
		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			while (reg.next()) {
				java.sql.Date f=reg.getDate("fecha_compra");
				LocalDate fBuena=f.toLocalDate();
				lista.add(new Compra(reg.getString("factura"),reg.getInt("precio"),reg.getString("cod_cliente"),fBuena));
			}
			s.close();
			this.cerrar();
			return lista;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	/**
	 * Devuelve el mayor numero de factura para la gestion del numero secuencial
	 * @return maximo numero de factura
	 * @throws DatosIntroducidosException
	 */
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
	
	/**
	 * Da de alta una compra en la base de datos
	 * @param co
	 * @return 1 si se ha añadido con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
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
	
	/**
	 * Metodo para devolver una compra
	 * @param factura
	 * @return 1 si se ha devuelto con exito, 0 si hay algun dato mal introducido o una excepcion
	 * @throws DatosIntroducidosException
	 */
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