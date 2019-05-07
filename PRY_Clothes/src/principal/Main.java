package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import bbdd.BD_Conector;
import bbdd.BD_Dise�o;
import modelos.Dise�o;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Conector.BD_Ini("pryclothes");
		BD_Dise�o bd = new BD_Dise�o();
		int opc;
		int filas;
		double precio;
		String categoria = null;
		LocalDate fecha_salida = null;
		LocalDate fechaIni = null;
		boolean correcto = false;
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");

		do {
			System.out.println("1. A�adir dise�o");
			System.out.println("2. Borrar dise�o");
			System.out.println("3. Modificar dise�o");
			System.out.println("4. Mostrar dise�os totales");
			System.out.println("5. Buscar dise�o propio");
			System.out.println("6. Mostrar dise�os hasta la fecha de hoy ");
			System.out.println("7. Mostrar dise�os ultimos 7 dias");
			System.out.println("8. Salir");
			
			System.out.print("\n\tIntroduce opcion: ");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:

				do {

					System.out.println("------------------------------------------------------*A�adir dise�o*-------------------------------------------------------------------");
					try {	
						System.out.println("Dime fecha de salida");
						String fecha_introducida = sc.nextLine();
						fecha_salida = LocalDate.parse(fecha_introducida, fechaFormateada);
						correcto = true;
					} catch (DateTimeParseException m) {
						System.out.println("Error en fecha tiene q estar en formato yyyy-LL-dd ");
						correcto = true;
					}

				} while (correcto != true);
				System.out.println("Dime descripcion");
				String descripcion = sc.nextLine();
				System.out.println("Dime precio de prenda");
				precio = sc.nextDouble();
				System.out.println("Dime categoria");
				sc.nextLine();
				categoria = sc.nextLine();
				System.out.println("Dime cantidad");
				int cantidad = sc.nextInt();
				Dise�o dise�os = new Dise�o(fecha_salida, descripcion, precio, categoria, cantidad);
				filas = bd.a�adir_Dise�o(dise�os);
				switch (filas) {
				case 1:
					System.out.println("\n Dise�o a�adido");
					break;
				case 0:
					System.out.println("\n Dise�o no a�adido");
					break;
				case -1:
					System.out.println("\n Ya se encuentra a�adido en nuestra BDD");
				}
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------------------------------*Borrar dise�o*-------------------------------------------------------------------");
				Vector<String> listadoCod_dise�o = new Vector<String>();
				for (int i = 0; i < listadoCod_dise�o.size(); i--)
					System.out.println((i + 1) + ".-" + listadoCod_dise�o.get(i));
				System.out.println("Dime cod de dise�o a buscar para posteriormente borrarlo");
				sc.nextLine();
				String cod_dise�oBorrar = sc.nextLine().toUpperCase();
				filas = bd.borraDise�o(cod_dise�oBorrar);
				switch (filas) {
				case 1:
					System.out.println("\n Dise�o borrado");
					break;
				case 0:
					System.out.println("\n Dise�o no borrado");
					break;
				case -1:
					System.out.println("\n Problemas t�cnicos");
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 3:
				System.out.println("------------------------------------------------------------*Moficar dise�o*-----------------------------------------------------------------");
				System.out.println("Dime campo");
				sc.nextLine();
				String campo = sc.nextLine();
				System.out.println("Dime modificador ");
				String modificador = sc.nextLine();
				System.out.println("Dime codigo de dise�o de prenda a modificar");
				String buscacod_dise�o = sc.nextLine();
				filas = bd.modificar_datos(modificador, campo, buscacod_dise�o);
				switch (filas) {
				case 1:
					System.out.println("\n Campo modificado");
					break;
				case 0:
					System.out.println("\n Campo  no modificado xq no existe el usuario");
					break;
				case -1:
					System.out.println("\n Problemas t�cnicos");
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 4:
				System.out.println("-----------------------------------------------------------*Dise�os totales*-----------------------------------------------------------------");
				Vector<Dise�o> dise�ito = bd.consultar_Dise�os();
				for (int i = 0; i < dise�ito.size(); i++) {
					System.out.println(dise�ito.get(i));
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 5:
				System.out.println("--------------------------------------------------------*Buscar dise�o propio*---------------------------------------------------------------");
				System.out.println("Los campos por los que puedes buscar son : categoria,cod_dise�o,fecha_salida,precio");

				String campoBuscar = sc.nextLine().toLowerCase();
				System.out.println("Dime lo q buscas de dicho campo  para posteriormente buscarlo");
				String buscado = sc.nextLine().toLowerCase();

				Vector<Dise�o> dise�opropio = bd.mostrar_Dise�o(buscado, campoBuscar);

				for (int i = 0; i < dise�opropio.size(); i++) {
					System.out.println((i + 1) + "." + dise�opropio.get(i));
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;

			case 6:
				System.out.println("-----------------------------------------------*Mostrar dise�o hasta la fecha de hoy*--------------------------------------------------------");
				do {

				
					try {
						System.out.println("Dime fecha inicio a buscar");
				
						String fechaBus = sc.nextLine();
						fechaIni = LocalDate.parse(fechaBus, fechaFormateada);
						if (fechaIni.isBefore(LocalDate.now())) 
							correcto = false;
					 } catch (DateTimeParseException m) {
						System.out.println("Error en fecha tiene q estar en formato yyyy-LL-dd ");
						correcto = true;
					}

				} while (correcto != false);
				Vector<Dise�o> dise�oDise�ofecha = bd.mostrar_dise�ofecha(fechaIni);
				for (int i = 0; i < dise�oDise�ofecha.size(); i++) {
					System.out.println((i + 1) + "." + dise�oDise�ofecha.get(i));
				}
				break;
			case 7:
				System.out.println("----------------------------------------------------*Mostrar dise�o ultima semana*----------------------------------------------------------");
				System.out.println("Te mostrare los dise�os de la ultima semana");
				Vector<Dise�o> dise�oDise�osiete = bd.mostrar_dise�osiete();
				for (int i = 0; i < dise�oDise�osiete.size(); i++) {
					System.out.println((i + 1) + "." + dise�oDise�osiete.get(i));
				}
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 8:
				break;
			}
			
		} while (opc != 8);

	}

}
