package modelos;
//Daniel Cirtog y Pablo Martin

public class Empleado extends Usuario{
	private String codEmple;
	private String funcion;
	private int numAvisos;
	private double salario;
	private int cont;
	private static int foto = 0;
	
	public Empleado(String rol, String funcion, double salario) {
		this.funcion = funcion;
		this.salario = salario;
		codEmple = super.codigo;
		
		foto++;
		cont = foto;
		
		numAvisos = 0;
	}

	public String getCodEmple() {
		return codEmple;
	}

	public String getFuncion() {
		return funcion;
	}

	public int getNumAvisos() {
		return numAvisos;
	}

	public double getSalario() {
		return salario;
	}

	public int getCont() {
		return cont;
	}

	public static int getFoto() {
		return foto;
	}
	
}
