package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import exceptions.DatosIntroducidosException;
import modelos.Aviso;
import modelos.Diseño;

public class BD_Aviso extends BD_Conector{
	private static Statement s;	  
	private static ResultSet reg;
	
	public int anotarAviso(Aviso av) throws DatosIntroducidosException {
		
		String cadenaSQL = "INSERT INTO avisos VALUES('" + av.getCodEmple() + "','" + av.getMotivo() + "','" + av.getFecha() + "')";
		
		try {
			this.abrir();
			
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("Los datos introducidos son incorrectos");
		}
	}
	
	public Vector<Aviso> mostrarAvisos() throws DatosIntroducidosException{
		String cadenaSQL = "SELECT * FROM avisos";
		Vector<Aviso> avisos=new Vector<Aviso>();
		
		try {
			this.abrir();
			
			s=c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while(reg.next()) {
				java.sql.Date fecha = reg.getDate("fecha_aviso");
				LocalDate fechaBuena = fecha.toLocalDate();
				avisos.add(new Aviso(reg.getString("cod_emple"), fechaBuena, reg.getString("motivo")));
			}
			s.close();
			return avisos;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("No se pueden mostrar los datos en este momento.");
		}
	}

	public int borrarAviso(LocalDate fecha) throws DatosIntroducidosException {
		String cadenaSQL= "DELETE FROM avisos WHERE fecha_aviso = '" + fecha +"'";
		
		try {
			this.abrir();
			
			s= c.createStatement();
			int filas= s.executeUpdate(cadenaSQL);
			s.close();
			
			this.cerrar();
			return filas;
		}catch(SQLException e) {
			this.cerrar();
			throw new DatosIntroducidosException("No se puede borrar ningun aviso en este momento.");
		}
	}
}