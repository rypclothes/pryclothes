package modelos;
//Daniel Cirtog y Pablo Martin
import java.time.LocalDateTime;

public abstract class Usuario {
	protected String codigo;
	private String contrase�a;
	private String nombre;
	private String rol;
	private String telefono;
	
	private LocalDateTime fechaAlta;

	public Usuario(String contrase�a, String nombre, String telefono, String rol) {
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.telefono = telefono;
		this.rol = rol;
		
		fechaAlta = fechaAlta.now();
		
		if(rol.substring(rol.length(),-2).equalsIgnoreCase("or")) {
			codigo = "AD";
		}
		if(rol.substring(0,2).equalsIgnoreCase("cl")) {
			codigo = "CL";
		}
		if(rol.substring(0,2).equalsIgnoreCase("lo")) {
			codigo = "EL";
		}
		if(rol.substring(0,2).equalsIgnoreCase("di")) {
			codigo = "ED";
		}
		if(rol.substring(0,2).equalsIgnoreCase("ad")) {
			codigo = "EA";
		}			
	}
	
	public Usuario(){}
	
	public String getCodigo() {
		return codigo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRol() {
		return rol;
	}

	public String getTelefono() {
		return telefono;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

}
