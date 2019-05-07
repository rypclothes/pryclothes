package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import bbdd.BD_Conector;
import bbdd.BD_Diseño;
import modelos.Diseño;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Conector.BD_Ini("pryclothes");
		BD_Diseño bd = new BD_Diseño();
		int opc;
		int filas;
		double precio;
		String categoria = null;
		LocalDate fecha_salida = null;
		LocalDate fechaIni = null;
		boolean correcto = false;
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");

		do {
			System.out.println("1. Añadir diseño");
			System.out.println("2. Borrar diseño");
			System.out.println("3. Modificar diseño");
			System.out.println("4. Mostrar diseños totales");
			System.out.println("5. Buscar diseño propio");
			System.out.println("6. Mostrar diseños hasta la fecha de hoy ");
			System.out.println("7. Mostrar diseños ultimos 7 dias");
			System.out.println("8. Salir");
			
			System.out.print("\n\tIntroduce opcion: ");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:

				do {

					System.out.println("------------------------------------------------------*Añadir diseño*-------------------------------------------------------------------");
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
				Diseño diseños = new Diseño(fecha_salida, descripcion, precio, categoria, cantidad);
				filas = bd.añadir_Diseño(diseños);
				switch (filas) {
				case 1:
					System.out.println("\n Diseño añadido");
					break;
				case 0:
					System.out.println("\n Diseño no añadido");
					break;
				case -1:
					System.out.println("\n Ya se encuentra añadido en nuestra BDD");
				}
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------------------------------*Borrar diseño*-------------------------------------------------------------------");
				Vector<String> listadoCod_diseño = new Vector<String>();
				for (int i = 0; i < listadoCod_diseño.size(); i--)
					System.out.println((i + 1) + ".-" + listadoCod_diseño.get(i));
				System.out.println("Dime cod de diseño a buscar para posteriormente borrarlo");
				sc.nextLine();
				String cod_diseñoBorrar = sc.nextLine().toUpperCase();
				filas = bd.borraDiseño(cod_diseñoBorrar);
				switch (filas) {
				case 1:
					System.out.println("\n Diseño borrado");
					break;
				case 0:
					System.out.println("\n Diseño no borrado");
					break;
				case -1:
					System.out.println("\n Problemas técnicos");
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 3:
				System.out.println("------------------------------------------------------------*Moficar diseño*-----------------------------------------------------------------");
				System.out.println("Dime campo");
				sc.nextLine();
				String campo = sc.nextLine();
				System.out.println("Dime modificador ");
				String modificador = sc.nextLine();
				System.out.println("Dime codigo de diseño de prenda a modificar");
				String buscacod_diseño = sc.nextLine();
				filas = bd.modificar_datos(modificador, campo, buscacod_diseño);
				switch (filas) {
				case 1:
					System.out.println("\n Campo modificado");
					break;
				case 0:
					System.out.println("\n Campo  no modificado xq no existe el usuario");
					break;
				case -1:
					System.out.println("\n Problemas técnicos");
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 4:
				System.out.println("-----------------------------------------------------------*Diseños totales*-----------------------------------------------------------------");
				Vector<Diseño> diseñito = bd.consultar_Diseños();
				for (int i = 0; i < diseñito.size(); i++) {
					System.out.println(diseñito.get(i));
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 5:
				System.out.println("--------------------------------------------------------*Buscar diseño propio*---------------------------------------------------------------");
				System.out.println("Los campos por los que puedes buscar son : categoria,cod_diseño,fecha_salida,precio");

				String campoBuscar = sc.nextLine().toLowerCase();
				System.out.println("Dime lo q buscas de dicho campo  para posteriormente buscarlo");
				String buscado = sc.nextLine().toLowerCase();

				Vector<Diseño> diseñopropio = bd.mostrar_Diseño(buscado, campoBuscar);

				for (int i = 0; i < diseñopropio.size(); i++) {
					System.out.println((i + 1) + "." + diseñopropio.get(i));
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
				break;

			case 6:
				System.out.println("-----------------------------------------------*Mostrar diseño hasta la fecha de hoy*--------------------------------------------------------");
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
				Vector<Diseño> diseñoDiseñofecha = bd.mostrar_diseñofecha(fechaIni);
				for (int i = 0; i < diseñoDiseñofecha.size(); i++) {
					System.out.println((i + 1) + "." + diseñoDiseñofecha.get(i));
				}
				break;
			case 7:
				System.out.println("----------------------------------------------------*Mostrar diseño ultima semana*----------------------------------------------------------");
				System.out.println("Te mostrare los diseños de la ultima semana");
				Vector<Diseño> diseñoDiseñosiete = bd.mostrar_diseñosiete();
				for (int i = 0; i < diseñoDiseñosiete.size(); i++) {
					System.out.println((i + 1) + "." + diseñoDiseñosiete.get(i));
				}
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			case 8:
				break;
			}
			
		} while (opc != 8);

	}

}
