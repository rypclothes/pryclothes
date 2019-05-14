package modelos;

import java.time.*;

import bbdd.BD_Usuario;

/**
 * 
 * @author Pablo y Dani
 *
 */

public class Usuario {
	protected String codigo;
	private String contraseña;
	private String nombre;
	protected String rol;
	private String telefono;
	
	BD_Usuario bdu = new BD_Usuario();
	
	private LocalDate fechaAlta;
	
	/*Constructor para Clientes*/
	public Usuario(String contraseña, String nombre, String telefono) {
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.telefono = telefono;
		
		fechaAlta = fechaAlta.now();
		
		rol = "Cliente";
		
		codigo = "CL" + (bdu.consultaNumeroSecuencialCliente() + 1);
	}
	
	
	
	public Usuario(String codigo,String contraseña, String nombre, String telefono, LocalDate fechaAlta) {
		super();
		this.codigo=codigo;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaAlta = fechaAlta;
	}
	
	public Usuario(String contraseña, String nombre, String telefono, LocalDate fechaAlta) {
		super();
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaAlta = fechaAlta;
	}



	public Usuario(String contraseña, String nombre) {
		super();
		this.contraseña = contraseña;
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", contraseña=" + contraseña + ", nombre=" + nombre + ", rol=" + rol
				+ ", telefono=" + telefono + ", fechaAlta=" + fechaAlta + "]";
	}

	public Usuario(){}
	
	/*Constructor para Empleados*/
	public Usuario(String contraseña, String nombre, String telefono, String rol) {
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.telefono = telefono;
		this.rol = rol;
		
		fechaAlta = fechaAlta.now();
		
		if(rol.substring(0,2).equalsIgnoreCase("lo")) {
			codigo = "EL" + (bdu.consultaNumeroSecuencialEmpleado() + 1);
		}
		if(rol.substring(0,2).equalsIgnoreCase("di")) {
			codigo = "ED" + (bdu.consultaNumeroSecuencialEmpleado() + 1);
		}
		if(rol.substring(0,2).equalsIgnoreCase("ad")) {
			codigo = "EA" + (bdu.consultaNumeroSecuencialEmpleado() + 1);
		}
	}
	
	/*Constructor para todo*/
	public Usuario(String codigo, String contraseña, String nombre, String rol, String telefono,
			LocalDate fechaAlta) {
		super();
		this.codigo = codigo;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.rol = rol;
		this.telefono = telefono;
		this.fechaAlta = fechaAlta;
	}
	
	public Usuario(String codigo) {
		super();
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getContraseña() {
		return contraseña;
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

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

}
