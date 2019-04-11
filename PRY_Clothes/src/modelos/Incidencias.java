package modelos;

import java.time.LocalDateTime;

public class Incidencias {
	private LocalDateTime fechaError;
	private String codEmple;
	private String tipoIncidencia;
	
	public Incidencias(LocalDateTime fechaError, String codEmple, String tipoIncidencia) {
		super();
		this.fechaError = fechaError;
		this.codEmple = codEmple;
		this.tipoIncidencia = tipoIncidencia;
	}

	
}
