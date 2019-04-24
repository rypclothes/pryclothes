package modelos;
//Daniel Cirtog y Pablo Martin

public class Cliente extends Usuario{
	private long numTarjeta;
	private String direccion;
	
	public Cliente(String codigo,long numTarjeta, String direccion) {
		super(codigo);
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
		
	}
	

	public Cliente(String contraseña, String nombre, String telefono, long numTarjeta, String direccion) {
		super(contraseña, nombre, telefono);
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
		// TODO Auto-generated constructor stub
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
	
	
}
