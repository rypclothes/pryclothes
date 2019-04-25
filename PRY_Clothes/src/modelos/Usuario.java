package modelos;
//Daniel Cirtog y Pablo Martin
import java.time.*;

import bbdd.BD_Usuario;

public class Usuario {
	protected String codigo;
	private String contrase�a;
	private String nombre;
	protected String rol;
	private String telefono;
	
	BD_Usuario bdu = new BD_Usuario();
	
	private LocalDateTime fechaAlta;
	
	/*Constructor para Clientes*/
	public Usuario(String contrase�a, String nombre, String telefono) {
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.telefono = telefono;
		
		fechaAlta = fechaAlta.now();
		
		rol = "Cliente";
		
		codigo = "CL" + (bdu.consultaNumeroSecuencialCliente() + 1);
	}
	
	public Usuario(){}
	
	/*Constructor para Empleados*/
	public Usuario(String contrase�a, String nombre, String telefono, String rol) {
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.telefono = telefono;
		this.rol = rol;
		
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
