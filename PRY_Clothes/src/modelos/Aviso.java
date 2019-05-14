package modelos;

import java.time.LocalDate;

public class Aviso {

	private String codEmple;
	private LocalDate fecha;
	private String motivo;
	
	public Aviso(String codEmple, String motivo) {
		this.codEmple = codEmple.toUpperCase();
		this.motivo = motivo.substring(0).toUpperCase();
		
		fecha= fecha.now();
	}
	
	public Aviso(String codEmple, LocalDate fecha, String motivo) {
		this.codEmple = codEmple;
		this.fecha = fecha;
		this.motivo = motivo;
	}
	
	public String getCodEmple() {
		return codEmple;
	}
	public void setCodEmple(String codEmple) {
		this.codEmple = codEmple;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
	@Override
	public String toString() {
		return codEmple + ",    " + fecha + "    " + motivo;
	}
	
}