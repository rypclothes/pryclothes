package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Cliente;
import modelos.Empleado;
import modelos.Usuario;
/**
 * 
 * @author Pablo y Dani
 *
 */
public class BD_Clientes extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	private Vector <Cliente> clientes = new <Cliente> Vector();
	BD_Usuario bdu = new BD_Usuario();
	
	//@author Rober
	public boolean modificarCampoCliente(String cod, String campo, String valor) {
		cadenaSQL="UPDATE clientes SET '" + campo + "' = '" + valor + "' where cod ='" + cod + "'";
		
		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return true;

		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
	}
	
	public int darAltaCliente(Cliente cl) throws DatosIntroducidosException {
		Usuario usu = new Usuario(cl.getContraseña(),cl.getNombre(),cl.getTelefono());
		bdu.darAltaUsuario(usu);
		
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
			throw new DatosIntroducidosException("Los datos introducidos son incorrectos");
		}
	}

	public int darBajaCliente(String codCliente) throws DatosIntroducidosException {
		cadenaSQL = "DELETE FROM clientes WHERE cod_cliente ='" + codCliente + "'";
		
		try {
			this.abrir();
			
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();

			bdu.darBajaUsuario(codCliente);
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Algun dato no esta bien introducido");
		}
	}

	public Vector <Cliente> mostrarClientes() throws DatosIntroducidosException{
		Vector <Cliente> clientes = new <Cliente> Vector();
		cadenaSQL = "SELECT * FROM clientes";
		
		try {
			this.abrir();
			
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				clientes.add(new Cliente(reg.getString("cod_cliente"), reg.getLong("num_tarjeta"), reg.getString("direccion")));
			}
			s.close();
			
			this.cerrar();
			return clientes;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Ha habido problemas con la BBDD");
		}
	}
}
