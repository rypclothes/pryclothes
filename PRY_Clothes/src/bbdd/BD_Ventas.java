package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Empleado;
import modelos.Venta;

//@author Roberto Saavedra
public class BD_Ventas extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String crearFactura(String cod_cliente)  {
		int num=0;
		String cadenaSQL="SELECT MAX(SUBSTRING(factura,4)) FROM COMPRAS";	
		
		try {
			
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next())
				num=reg.getInt(1);
			
			num++;
			s.close();
			this.cerrar();
			
			return cod_cliente+num;
		}catch(SQLException e) {
			return null;
		}
		
	}
	
	public int añadirVenta(Venta ve) throws DatosIntroducidosException {
		String cadenaSQL="INSERT INTO VENTAS VALUES ('"+ve.getCod_diseño()+"','"+ve.getCantidad()+"','"+ve.getPrecio_venta()+"','"+ve.getFactura()+"')";
		int filas;
		
		try {
			this.abrir();
			
			s = c.createStatement();
			filas=s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Algun dato no esta bien introducido");
		}
		
	}
	public Vector<Venta> listadoVentas(String factura){
		
		String cadenaSQL="SELECT * FROM VENTAS WHERE FACTURA = '"+factura+"'";
		Vector<Venta> lista=new Vector<Venta>();
		
		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			while (reg.next()) {
				lista.add(new Venta(reg.getString(1),reg.getString(4),reg.getInt(2),reg.getInt(3)));
			}
			s.close();
			this.cerrar();
			return lista;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public int darBajaVenta(String factura) throws DatosIntroducidosException {
		String cadenaSQL = "DELETE FROM ventas WHERE factura='" + factura + "'";
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
	
	public Vector<String> listadoCamposVnetas() {

		String cadenaSQL = "SHOW COLUMNS FROM VENTAS";
		Vector<String> listaVentas = new Vector<String>();

		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			while (reg.next()) {
				listaVentas.add(reg.getString(1));
			}
			s.close();
			this.cerrar();
			return listaVentas;
		} catch (SQLException e) {
			return null;
		}
	}

}
