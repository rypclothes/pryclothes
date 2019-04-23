package modelos;
//Daniel Cirtog y Pablo Martin

public class Cliente extends Usuario{
	private String codCliente;
	private long numTarjeta;
	private String direccion;
	
	public Cliente(long numTarjeta, String direccion) {
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
		codCliente = super.codigo;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public String getDireccion() {
		return direccion;
	}
	
	
}
