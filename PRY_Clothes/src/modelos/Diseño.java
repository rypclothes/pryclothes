package modelos;

import java.time.LocalDate;

import bbdd.BD_Diseño;

/**
 * 
 * @author Yandry
 *
 */

public class Diseño {
private LocalDate fecha_salida ;
private String descripcion;
private double precio;
private int numCod;
private  int numDiseño;
private int cantidad;
private String categoria;
private String codDiseño;
public Diseño(String descripcion, double precio, String categoria) {
	super();
	this.fecha_salida = fecha_salida;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;

	BD_Diseño bd=new BD_Diseño();
	numCod=bd.consultaNumeroSecuencialDiseño();
		
	this.codDiseño = categoria.substring(0,2).toUpperCase()+"-"+ (numCod + 1);
	
	this.fecha_salida = LocalDate.now();
}
public Diseño(String descripcion, double precio, String categoria, int cantidad) {
	super();
	this.descripcion = descripcion;
	this.precio = precio;
	this.cantidad = cantidad;
	this.categoria = categoria;
}

public Diseño(int cantidad, String codDiseño) {
	super();
	this.cantidad = cantidad;
	this.codDiseño = codDiseño;
}
/*jajajd*/
public LocalDate getFecha_salida() {
	return fecha_salida;
}
public String getDescripcion() {
	return descripcion;
}
public double getPrecio() {
	return precio;
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
	return codDiseño;
}
	

}

