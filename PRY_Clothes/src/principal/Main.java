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
		String codDiseño;
		boolean correcto = false;
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");

		do {
			System.out.println("1.añadir diseño");
			System.out.println("2.borrar diseño");
			System.out.println("3.Modificar diseño");
			System.out.println("4.Mostrar diseños");
			System.out.println("5.buscar diseño propio");
			System.out.println("6.te mostrare los diseños desde la fecha introducida hasta el dia de hoy ");
			opc = sc.nextInt();
			switch (opc) {
			case 1:

				do {

					System.out.println("dime fecha de salida");
					try {

						sc.nextLine();
						String fecha_introducida = sc.nextLine();
						fecha_salida = LocalDate.parse(fecha_introducida, fechaFormateada);
						correcto = true;
					} catch (DateTimeParseException m) {
						System.out.println("error en fecha tiene q estar en formato yyyy-LL-dd ");
						correcto = true;
					}

				} while (correcto != true);
				sc.nextLine();
				System.out.println("dime descripcion");
				String descripcion = sc.nextLine();
				System.out.println("dime precio de prenda");
				precio = sc.nextDouble();
				System.out.println("dime categoria");
				sc.nextLine();
				categoria = sc.nextLine();
				System.out.println("dime cantidad");
				int cantidad = sc.nextInt();
				Diseño diseños = new Diseño(fecha_salida, descripcion, precio, categoria, cantidad);
				filas = bd.añadir_Diseño(diseños);
				switch (filas) {
				case 1:
					System.out.println("\n diseño añadidos");
					break;
				case 0:
					System.out.println("\n diseño no añadido");
					break;
				case -1:
					System.out.println("\n Ya se encuentra añadido en nuestra BDD");
				}
				break;
			case 2:

				Vector<String> listadoCod_diseño = new Vector<String>();
				if (listadoCod_diseño == null) {
					System.out.println("no se puede realizar la operacion");
				}
				for (int i = 0; i < listadoCod_diseño.size(); i--)
					System.out.println((i + 1) + ".-" + listadoCod_diseño.get(i));
				System.out.println("dime cod de diseño a buscar para posteriormente borrarlo");
				sc.nextLine();
				String cod_diseñoBorrar = sc.nextLine().toUpperCase();
				filas = bd.borraDiseño(cod_diseñoBorrar);
				switch (filas) {
				case 1:
					System.out.println("\n Diseño borrado");
					break;
				case 0:
					System.out.println("\n diseño no borrado");
					break;
				case -1:
					System.out.println("\n Problemas técnicos");
				}

				break;
			case 3:
				System.out.println("dime campo");
				sc.nextLine();
				String campo = sc.nextLine();
				System.out.println("dime modificador ");
				String modificador = sc.nextLine();
				System.out.println("dime codigo de diseño de prenda a modificar");
				String buscacod_diseño = sc.nextLine();
				filas = bd.modificar_datos(modificador, campo, buscacod_diseño);
				switch (filas) {
				case 1:
					System.out.println("\n campo modificado");
					break;
				case 0:
					System.out.println("\n campo  no modificado xq no existe el usuario");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");
				}

				break;
			case 4:
				Vector<Diseño> diseñitos = new <Diseño>Vector();
				diseñitos = bd.consultar_Diseños();
				for (int i = 0; i < diseñitos.size(); i++) {
					System.out.println(diseñitos.get(i));
				}
			case 5:
				System.out
						.println("los campos por los que puedes buscar son : categoria,cod_diseño,fecha_salida,precio");
				sc.nextLine();
				String campoBuscar = sc.nextLine().toLowerCase();
				System.out.println("dime lo q buscas de dicho campo  para posteriormente buscarlo");
				String buscado = sc.nextLine().toLowerCase();

				Vector<Diseño> diseñopropio = bd.mostrar_Diseño(buscado, campoBuscar);

				for (int i = 0; i < diseñopropio.size(); i++) {
					System.out.println((i + 1) + "." + diseñopropio.get(i));
				}
				break;

			case 6:

				do {

				
					try {
						System.out.println("dime fecha inicio a buscar");
				
						String fechaBus = sc.nextLine();
						fechaIni = LocalDate.parse(fechaBus, fechaFormateada);
						if (fechaIni.isBefore(LocalDate.now())) 
							System.out.println("fecha correcta");
							correcto = false;
		                    sc.nextLine();
				       
					 } catch (DateTimeParseException m) {
						System.out.println("error en fecha tiene q estar en formato yyyy-LL-dd ");
						correcto = true;
					}

				} while (correcto != false);
				sc.nextLine();
				Vector<Diseño> diseñoDiseñofecha = bd.mostrar_diseñofecha(fechaIni);
				for (int i = 0; i < diseñoDiseñofecha.size(); i++) {
					System.out.println((i + 1) + "." + diseñoDiseñofecha.get(i));
				}

			}

		} while (opc != 6);

	}

}
