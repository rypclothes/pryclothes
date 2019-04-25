package modelos;

import java.time.LocalDate;

public class Dise�o {
private LocalDate fecha_salida ;
private String descripcion;
private double precio;
private static  int cont;
private  int numDise�o;
private int cantidad;
private String categoria;
private String codDise�o;
public Dise�o(LocalDate fecha_salida, String descripcion, double precio, String categoria,int cantidad) {
	super();
	this.fecha_salida = fecha_salida;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;
	this.cont=1;
	cont++;
	this.codDise�o = categoria.substring(0,2).toUpperCase()+"-"+cont;
    
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
	return "Dise�o [fecha_salida=" + fecha_salida + ", descripcion=" + descripcion + ", precio=" + precio
			+ ", numDise�o=" + numDise�o + ", cantidad=" + cantidad + ", categoria=" + categoria + ", codDise�o="
			+ codDise�o + "]";
}

}

