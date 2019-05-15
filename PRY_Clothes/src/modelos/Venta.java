package modelos;

public class Venta  {
	
	private String cod_diseño,factura;
	private int cantidad,precio_venta;
	
	public Venta(String cod_diseño, String factura, int cantidad, int precio_venta) {
		super();
		this.cod_diseño = cod_diseño;
		this.factura = factura;
		this.cantidad = cantidad;
		this.precio_venta = cantidad*precio_venta;
	}

	public String getCod_diseño() {
		return cod_diseño;
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

	@Override
	public String toString() {
		return cod_diseño +" "+cantidad+" und" + ", precio=" + precio_venta;
	}

	
	
	
	

}
