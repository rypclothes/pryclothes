package modelos;

import java.time.*;

import bbdd.BD_Compras;
import exceptions.DatosIntroducidosException;

/**
 * 
 * @author Pablo
 *
 */
public class Compra {
	private String factura;
	private double precio;
	private int numPrendas;
	private String codCliente;
	private LocalDate fechaCompra;
	
	BD_Compras bdc = new BD_Compras();
	
	public Compra(int precio, int numPrendas, String codCliente) {
		super();
		this.precio = precio;
		this.numPrendas = numPrendas;
		this.codCliente = codCliente;
		
		fechaCompra = fechaCompra.now();
		try {
			factura = codCliente + (bdc.devolverNumFactura() + 1);
		} catch (DatosIntroducidosException e) {
			e.printStackTrace();
		}
	}
	

	public Compra(String factura, int precio, String codCliente, LocalDate fechaCompra) {
		super();
		this.factura = factura;
		this.precio = precio;
		this.codCliente = codCliente;
		this.fechaCompra = fechaCompra;
	}


	public String getFactura() {
		return factura;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumPrendas() {
		return numPrendas;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	@Override
	public String toString() {
		return factura;
	}
	
	
}