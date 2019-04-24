package modelos;
//Daniel Cirtog y Pablo Martin
import java.time.LocalDateTime;

public class Usuario {
	protected String codigo;
	private String contrase�a;
	private String nombre;
	protected String rol;
	private String telefono;
	
	private LocalDateTime fechaAlta;

	public Usuario(String contrase�a, String nombre, String telefono) {
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.telefono = telefono;
		
		fechaAlta = fechaAlta.now();
		
		rol = "Cliente";
		
		if(rol.endsWith("or")) {
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
	
	public Usuario(String contrase�a, String nombre, String telefono, String rol) {
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.telefono = telefono;
		
		fechaAlta = fechaAlta.now();
		
		if(rol.substring(0,2).equalsIgnoreCase("lo")) {
			codigo = "EL";
		}
		if(rol.substring(0,2).equalsIgnoreCase("di")) {
			codigo = "ED";
		}
		if(rol.substring(0,2).equalsIgnoreCase("ad")) {
			codigo = "EA";
		}	
		
		rol = "Cliente";
		
		if(rol.endsWith("or")) {
			codigo = "AD";
		}
		if(rol.substring(0,2).equalsIgnoreCase("cl")) {
			codigo = "CL";
		}		
	}
	
	public Usuario(String codigo) {
		super();
		this.codigo = codigo;
	}

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
