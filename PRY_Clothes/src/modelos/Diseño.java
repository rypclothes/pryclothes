package modelos;

import java.time.LocalDate;

public class Dise�o {
private LocalDate avisos ;
private String descripcion;
private int precio;
private String categoria;
private String codDise�o;
public Dise�o(LocalDate avisos, String descripcion, int precio, String categoria, String codDise�o) {
	super();
	this.avisos = avisos;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;
	this.codDise�o = codDise�o;
}
public LocalDate getAvisos() {
	return avisos;
}
public String getDescripcion() {
	return descripcion;
}
public int getPrecio() {
	return precio;
}
public String getCategoria() {
	return categoria;
}
public String getCodDise�o() {
	return codDise�o;
}

}
