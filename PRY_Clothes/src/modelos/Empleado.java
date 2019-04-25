package modelos;
//Daniel Cirtog y Pablo Martin

public class Empleado extends Usuario{
	private String funcion;
	private int numAvisos;
	private double salario;
	private int cont;
	private static int foto = 0;

	public Empleado(String codigo, String funcion, double salario) {
		super(codigo);
		this.funcion = funcion;
		this.salario = salario;
		
		foto++;
		cont = foto;
		
		numAvisos = 0;
	}
	
	/*Constructor para dar de alta a la vez en usuarios*/
	public Empleado(String contraseņa, String nombre, String telefono, String rol, String funcion, double salario) {
		super(contraseņa, nombre, telefono, rol);
		
		this.funcion = funcion;
		this.salario = salario;
		numAvisos = 0;
	}

	@Override
	public String toString() {
		return "Empleado [codEmple=" + codigo + ", funcion=" + funcion + ", numAvisos=" + numAvisos + ", salario="
				+ salario + ", cont=" + cont + "]";
	}

	public String getCodEmple() {
		return codigo;
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
