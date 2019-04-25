/*
 * Clase relacionada con Reclamaciones
 * @author Roberto_Saavedra
 */
package modelos;

import java.time.LocalDate;

public class Reclamacion {

	private LocalDate Fecha_Rec;
	private String cod_cliente, descripcion, respuesta;

	public Reclamacion(String cod_cliente, String descripcion) {
		super();
		Fecha_Rec = LocalDate.now();
		this.cod_cliente = cod_cliente;
		this.descripcion = descripcion;
	}

	public Reclamacion(String cod_cliente, String descripcion, String respuesta) {
		super();
		Fecha_Rec = LocalDate.now();
		this.cod_cliente = cod_cliente;
		this.descripcion = descripcion;
		this.respuesta = respuesta;
	}

	public LocalDate getFecha_Rec() {
		return Fecha_Rec;
	}

	public void setFecha_Rec(LocalDate fecha_Rec) {
		Fecha_Rec = fecha_Rec;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
