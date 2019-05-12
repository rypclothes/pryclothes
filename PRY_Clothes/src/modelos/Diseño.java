package modelos;

import java.time.LocalDate;

import bbdd.BD_Dise�o;

/**
 * 
 * @author Yandry
 *
 */

public class Dise�o {
private LocalDate fecha_salida ;
private String descripcion;
private double precio;
private int numCod;
private  int numDise�o;
private int cantidad;
private String categoria;
private String codDise�o;
public Dise�o(String descripcion, double precio, String categoria) {
	super();
	this.fecha_salida = fecha_salida;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;

	BD_Dise�o bd=new BD_Dise�o();
	numCod=bd.consultaNumeroSecuencialDise�o();
		
	this.codDise�o = categoria.substring(0,2).toUpperCase()+"-"+ (numCod + 1);
	
	this.fecha_salida = LocalDate.now();
}
public Dise�o(String descripcion, double precio, String categoria, int cantidad) {
	super();
	this.descripcion = descripcion;
	this.precio = precio;
	this.cantidad = cantidad;
	this.categoria = categoria;
}

public Dise�o(int cantidad, String codDise�o) {
	super();
	this.cantidad = cantidad;
	this.codDise�o = codDise�o;
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
public int getNumDise�o() {
	return numDise�o;
}
public int getCantidad() {
	return cantidad;
}
public String getCategoria() {
	return categoria;
}
public String getCodDise�o() {
	return codDise�o;
}
@Override
public String toString() {
	return codDise�o;
}
	

}

