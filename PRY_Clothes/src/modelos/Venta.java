package modelos ;

public class Venta  {
	
	private String cod_dise�o,factura;
	private int cantidad,precio_venta;
	
	public Venta(String cod_dise�o, String factura, int cantidad, int precio_venta) {
		super();
		this.cod_dise�o = cod_dise�o;
		this.factura = factura;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
	}

	public String getCod_dise�o() {
		return cod_dise�o;
	}

	public String getFactura() {
		return factura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPrecio_venta() {
		return precio_venta;
	}
	
	

}
