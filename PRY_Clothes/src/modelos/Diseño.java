package modelos;

import java.time.LocalDate;

public class Diseño {
private LocalDate fecha_salida ;
private String descripcion;
private double precio;
private static  int cont;
private  int numDiseño;
private int cantidad;
private String categoria;
private String codDiseño;
public Diseño(LocalDate fecha_salida, String descripcion, double precio, String categoria,int cantidad) {
	super();
	this.fecha_salida = fecha_salida;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;
	this.cont=1;
	cont++;
	this.codDiseño = categoria.substring(0,2).toUpperCase()+"-"+cont;
    
	this.cantidad=cantidad;
}
/*jajaj*/
public LocalDate getFecha_salida() {
	return fecha_salida;
}
public String getDescripcion() {
	return descripcion;
}
public double getPrecio() {
	return precio;
}
public static int getCont() {
	return cont;
}
public int getNumDiseño() {
	return numDiseño;
}
public int getCantidad() {
	return cantidad;
}
public String getCategoria() {
	return categoria;
}
public String getCodDiseño() {
	return codDiseño;
}
@Override
public String toString() {
	return "Diseño [fecha_salida=" + fecha_salida + ", descripcion=" + descripcion + ", precio=" + precio
			+ ", numDiseño=" + numDiseño + ", cantidad=" + cantidad + ", categoria=" + categoria + ", codDiseño="
			+ codDiseño + "]";
}

}

