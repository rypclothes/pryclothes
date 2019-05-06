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
		String codDise�o;
		boolean correcto = false;
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");

		do {
			System.out.println("1.a�adir dise�o");
			System.out.println("2.borrar dise�o");
			System.out.println("3.Modificar dise�o");
			System.out.println("4.Mostrar dise�os");
			System.out.println("5.buscar dise�o propio");
			System.out.println("6.te mostrare los dise�os desde la fecha introducida hasta el dia de hoy ");
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
				Dise�o dise�os = new Dise�o(fecha_salida, descripcion, precio, categoria, cantidad);
				filas = bd.a�adir_Dise�o(dise�os);
				switch (filas) {
				case 1:
					System.out.println("\n dise�o a�adidos");
					break;
				case 0:
					System.out.println("\n dise�o no a�adido");
					break;
				case -1:
					System.out.println("\n Ya se encuentra a�adido en nuestra BDD");
				}
				break;
			case 2:

				Vector<String> listadoCod_dise�o = new Vector<String>();
				if (listadoCod_dise�o == null) {
					System.out.println("no se puede realizar la operacion");
				}
				for (int i = 0; i < listadoCod_dise�o.size(); i--)
					System.out.println((i + 1) + ".-" + listadoCod_dise�o.get(i));
				System.out.println("dime cod de dise�o a buscar para posteriormente borrarlo");
				sc.nextLine();
				String cod_dise�oBorrar = sc.nextLine().toUpperCase();
				filas = bd.borraDise�o(cod_dise�oBorrar);
				switch (filas) {
				case 1:
					System.out.println("\n Dise�o borrado");
					break;
				case 0:
					System.out.println("\n dise�o no borrado");
					break;
				case -1:
					System.out.println("\n Problemas t�cnicos");
				}

				break;
			case 3:
				System.out.println("dime campo");
				sc.nextLine();
				String campo = sc.nextLine();
				System.out.println("dime modificador ");
				String modificador = sc.nextLine();
				System.out.println("dime codigo de dise�o de prenda a modificar");
				String buscacod_dise�o = sc.nextLine();
				filas = bd.modificar_datos(modificador, campo, buscacod_dise�o);
				switch (filas) {
				case 1:
					System.out.println("\n campo modificado");
					break;
				case 0:
					System.out.println("\n campo  no modificado xq no existe el usuario");
					break;
				case -1:
					System.out.println("\nProblemas t�cnicos");
				}

				break;
			case 4:
				Vector<Dise�o> dise�itos = new <Dise�o>Vector();
				dise�itos = bd.consultar_Dise�os();
				for (int i = 0; i < dise�itos.size(); i++) {
					System.out.println(dise�itos.get(i));
				}
			case 5:
				System.out
						.println("los campos por los que puedes buscar son : categoria,cod_dise�o,fecha_salida,precio");
				sc.nextLine();
				String campoBuscar = sc.nextLine().toLowerCase();
				System.out.println("dime lo q buscas de dicho campo  para posteriormente buscarlo");
				String buscado = sc.nextLine().toLowerCase();

				Vector<Dise�o> dise�opropio = bd.mostrar_Dise�o(buscado, campoBuscar);

				for (int i = 0; i < dise�opropio.size(); i++) {
					System.out.println((i + 1) + "." + dise�opropio.get(i));
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
				Vector<Dise�o> dise�oDise�ofecha = bd.mostrar_dise�ofecha(fechaIni);
				for (int i = 0; i < dise�oDise�ofecha.size(); i++) {
					System.out.println((i + 1) + "." + dise�oDise�ofecha.get(i));
				}

			}

		} while (opc != 6);

	}

}
