package principal;

import java.util.*;

import com.sun.org.apache.bcel.internal.util.Class2HTML;

import bbdd.BD_Clientes;
import bbdd.BD_Compras;
import bbdd.BD_Conector;
import bbdd.BD_Empleado;
import bbdd.BD_Usuario;
import exceptions.DatosIntroducidosException;
import modelos.Cliente;
import modelos.Compra;
import modelos.Empleado;
import modelos.Usuario;
import sun.text.CompactByteArray;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Conector.BD_Ini("ryp_clothes");
		BD_Empleado bde = new BD_Empleado();
		BD_Clientes bdc = new BD_Clientes();
		BD_Usuario bdu = new BD_Usuario();
		BD_Compras bdco = new BD_Compras();
		
		System.out.println("Introduzca opcion:");
		int op = sc.nextInt();
		
		if(op == 1) {
			System.out.println("Damos de alta cliente:");
			System.out.println("Introduce nombre usuario");
			sc.nextLine();
			String nombre = sc.nextLine();
			
			System.out.println("Introduce contraseña:");
			String contraseña = sc.nextLine();
			
			System.out.println("Introduce telefono:");
			String telefono = sc.nextLine();
			
			System.out.println("Introduce direccion: ");
			String direccion = sc.nextLine();
			
			System.out.println("Introduce num tarjeta");
			long numTarjeta = sc.nextLong();
			
			Cliente cl = new Cliente(contraseña, nombre, telefono, numTarjeta, direccion);
			
			try {
				System.out.println(bdc.darAltaCliente(cl));
			} catch (DatosIntroducidosException e) {
				e.printStackTrace();
			}
		}
		
		if(op == 2) {
			System.out.println("Introduce el codigo del cliente para borrarlo");
			sc.nextLine();
			String codCliente = sc.nextLine();
			
			try {
				System.out.println(bdc.darBajaCliente(codCliente));
			}catch(DatosIntroducidosException e) {
				e.printStackTrace();
			}
		}
		
		if(op == 3) {
			System.out.println("Damos de alta un nuevo empleado");
			System.out.println("Nombre:");
			sc.nextLine();
			String nombre = sc.nextLine();
			
			System.out.println("Contraseña");
			String contraseña = sc.nextLine();
			
			System.out.println("Telefono");
			String telefono = sc.nextLine();
			
			System.out.println("Rol: ");
			String rol = sc.nextLine();
			
			System.out.println("Funcion: ");
			String funcion = sc.nextLine();
			
			System.out.println("Salario");
			double salario = sc.nextDouble();
			
			Empleado em = new Empleado(contraseña, nombre, telefono, rol, funcion, salario);
			
			try {
				System.out.println(bde.darAltaEmpleado(em));
			}catch(DatosIntroducidosException e) {
				e.printStackTrace();
			}
		}
		
		if(op == 4) {
			System.out.println("Introduce el codigo del empleado para borrarlo");
			sc.nextLine();
			String codEmple = sc.nextLine();
			
			try {
				System.out.println(bde.darBajaEmpleado(codEmple));
			}catch(DatosIntroducidosException e) {
				e.printStackTrace();
			}
		}
		
		if(op == 5) {
			try {
				Vector <Empleado> empleados = bde.mostrarEmpleados();
				
				for(int i = 0; i < empleados.size(); i++) {
					System.out.println(empleados.get(i));
				}
			} catch (DatosIntroducidosException e) {
				e.printStackTrace();
			}
			
		}
		
		if(op == 6) {
			Vector <Cliente> clientes = new <Cliente> Vector();
			try {
				clientes = bdc.mostrarClientes();
				
				for(int i = 0; i < clientes.size(); i++) {
					System.out.println(clientes.get(i));
				}	
			}catch (DatosIntroducidosException e) {
				e.printStackTrace();
			}	
		}
		
		if(op == 7) {
			System.out.println("precio");
			int precio = sc.nextInt();
			
			System.out.println("numero prendas");
			int prendas = sc.nextInt();
			
			System.out.println("codCliente");
			sc.nextLine();
			String codCliente = sc.nextLine();
			
			Compra cl = new Compra(precio, prendas, codCliente);
			
			try {
				System.out.println(bdco.darAltaCompra(cl));
			} catch (DatosIntroducidosException e) {
				e.printStackTrace();
			}
		}
		
		if(op == 8) {
			System.out.println("factura");
			sc.nextLine();
			String factura = sc.nextLine();
			
			try {
				System.out.println(bdco.darBajaCompra(factura));
			}catch(DatosIntroducidosException e) {
				e.printStackTrace();
			}
		}
	}
}

