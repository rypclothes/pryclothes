package modelos;

import java.sql.Date;
import java.time.*;

public class Incidencia {
	private LocalDate fechaError;
	private String codEmple;
	private String tipoIncidencia;
	
	public Incidencia(String codEmple, String tipoIncidencia) {
		super();
		this.fechaError = LocalDate.now();
		this.codEmple = codEmple;
		this.tipoIncidencia = tipoIncidencia;
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

	@Override
	public String toString() {
		return "Incidencias [fechaError=" + fechaError + ", codEmple=" + codEmple + ", tipoIncidencia=" + tipoIncidencia
				+ ", getTipoIncidencia()=" + getTipoIncidencia() + ", getFechaError()=" + getFechaError()
				+ ", getCodEmple()=" + getCodEmple() + super.toString() + "]";
	}

	
}
