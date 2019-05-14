package modelos;

import java.sql.Date;
import java.time.*;
/**
 * 
 * @author Mario, corregido por Pablo
 *
 */
public class Incidencia {
	private LocalDate fechaError;
	private String codEmple;
	private String tipoIncidencia;
	private int numIncidencia;
	
	public Incidencia(String codEmple, String tipoIncidencia) {
		this.fechaError = LocalDate.now();
		this.codEmple = codEmple;
		this.tipoIncidencia = tipoIncidencia;
	}
	
	public Incidencia(LocalDate fechaError, String codEmple, String tipoIncidencia, int numIncidencia) {
		this.fechaError = fechaError;
		this.codEmple = codEmple;
		this.tipoIncidencia = tipoIncidencia;
		this.numIncidencia = numIncidencia;
	}

	public void setCodEmple(String codEmple) {
		this.codEmple = codEmple;
	}

	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

	public String getTipoIncidencia() {
		// TODO Auto-generated method stub
		return tipoIncidencia;
	}

	public LocalDate getFechaError() {
		return fechaError;
	}

	public String getCodEmple() {
		return codEmple;
	}
	
	public int getNumIncidencia() {
		return numIncidencia;
	}

	@Override
	public String toString() {
		return String.valueOf(numIncidencia);
	}

	
}
