package modelos;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import bbdd.BD_Incidencias;

public class Incidencia {
	private LocalDate fechaError;
	private String codEmple;
	private String tipoIncidencia;
	private int num_incidencia;
	BD_Incidencias bdd = new BD_Incidencias("proyecto2");
	
	public Incidencia(LocalDate fechaError, String codEmple, String tipoIncidencia) {
		super();
		this.fechaError = fechaError;
		this.codEmple = codEmple;
		this.tipoIncidencia = tipoIncidencia;
		this.num_incidencia = bdd.consultaNumIncidencia() + 1;
	}
	public Incidencia(LocalDate fechaError, String codEmple, String tipoIncidencia,int creado) {
		super();
		this.fechaError = fechaError;
		this.codEmple = codEmple;
		this.tipoIncidencia = tipoIncidencia;
		
	}

	public void setCodEmple(String codEmple) {
		this.codEmple = codEmple;
	}

	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

	public LocalDate getFechaError() {
		return fechaError;
	}

	public void setFechaError(LocalDate fechaError) {
		this.fechaError = fechaError;
	}

	public String getCodEmple() {
		return codEmple;
	}

	public String getTipoIncidencia() {
		return tipoIncidencia;
	}


	public int getNum_incidencia() {
		return num_incidencia;
	}

	public void setNum_incidencia(int num_incidencia) {
		this.num_incidencia = num_incidencia;
	}

	@Override
	public String toString() {
		return "Incidencia [fechaError=" + fechaError + ", codEmple=" + codEmple + ", tipoIncidencia=" + tipoIncidencia + "]";
	}
}
