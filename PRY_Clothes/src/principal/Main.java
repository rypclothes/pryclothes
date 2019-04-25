package principal;

import java.util.*;

import com.sun.org.apache.bcel.internal.util.Class2HTML;

import bbdd.BD_Clientes;
import bbdd.BD_Conector;
import bbdd.BD_Empleado;
import bbdd.BD_Reclamaciones;
import exceptions.DatosIntroducidosException;
import modelos.Cliente;
import modelos.Empleado;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Conector.BD_Ini("ryp_clothes");
		BD_Empleado bde = new BD_Empleado();
		BD_Clientes bdc = new BD_Clientes();
		BD_Reclamaciones bdr=new BD_Reclamaciones();
		
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
	}
}

