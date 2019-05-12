package modelos;

/**
 * 
 * @author Pablo y Dani
 *
 */

public class Cliente extends Usuario{

	private long numTarjeta;
	private String direccion;
	
	public Cliente(String codigo,long numTarjeta, String direccion) {
		super(codigo);
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
		
	}
	

	public Cliente(String contrase�a, String nombre, String telefono, long numTarjeta, String direccion) {
		super(contrase�a, nombre, telefono);
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
	}


	public String getCodCliente() {
		return codigo;
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public String getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Cliente [numTarjeta=" + numTarjeta + ", direccion=" + direccion + ", codigo=" + codigo + "]";
	}
}