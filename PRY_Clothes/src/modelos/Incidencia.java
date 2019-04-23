package modelos;

import java.sql.Date;
import java.time.LocalDateTime;

public class Incidencia {
	private Date fechaError;
	private String codEmple;
	private String tipoIncidencia;
	
	public Incidencia(Date date, String string, String string2) {
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

	public String getTipoIncidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFechaError() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodEmple() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String toString() {
		return "Incidencias [fechaError=" + fechaError + ", codEmple=" + codEmple + ", tipoIncidencia=" + tipoIncidencia
				+ ", getTipoIncidencia()=" + getTipoIncidencia() + ", getFechaError()=" + getFechaError()
				+ ", getCodEmple()=" + getCodEmple() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
