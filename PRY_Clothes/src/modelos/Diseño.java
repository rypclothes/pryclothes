package modelos;

import java.time.LocalDate;

public class Diseño {
private LocalDate avisos ;
private String descripcion;
private int precio;
private String categoria;
private String codDiseño;
public Diseño(LocalDate avisos, String descripcion, int precio, String categoria, String codDiseño) {
	super();
	this.avisos = avisos;
	this.descripcion = descripcion;
	this.precio = precio;
	this.categoria = categoria;
	this.codDiseño = codDiseño;
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
public String getCodDiseño() {
	return codDiseño;
}

}
