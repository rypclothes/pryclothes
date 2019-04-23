package principal;

import java.util.*;

import modelos.Alumno;
import modelos.Incidencia;




public class Main {

	public static void main(String[] args) {
		Scanner sLeer=new Scanner(System.in);
		int opc=0;
		bbdd.BD_Incidencias bd=new bbdd.BD_Incidencias("incidencia");
		
		do{
			System.out.println("\n\nGESTIÓN DE INCIDENCIAS");
			System.out.println("***************");
			System.out.println("1.Nueva incidencia\n"
					+ "\n2.Borrar incidencias\n3.Listado de incidencias\n"
					);
			System.out.print("\tTeclea opción: ");
			try{
			opc=sLeer.nextInt();
			}
			catch(NumberFormatException e ){
				System.out.println("Opcion incorrecta");
				opc=0;
			}
			catch(InputMismatchException e ){
				System.out.println("Debes introducir número 1-4");
				opc=0;
			}
			
			sLeer.nextLine();
			switch (opc){
			case 1:
				System.out.println("\n\nALTA ALUMNO");
				System.out.print("Introduce tipo de error\t");
				String tipo_error=sLeer.nextLine();				
				System.out.print("Introduce codigo de empleado\t");
				String cod_emple=sLeer.nextLine();
				System.out.print("Introduce fecha de error\t");
				String fecha_error=sLeer.nextLine();	
				
				Vector <String> incidencias=bd.listadoIncidencias(cod_emple);
				if (incidencias==null){
						System.out.println("En este momento no podemos realizar la operación");
						break;
				}
				System.out.println("Lista de incidencias");
				for (int i=0;i<incidencias.size();i++)
					System.out.println((i+1)+ ".- "+incidencias.get(i));				
				System.out.print("Teclea el codigo del empleado\t");
				cod_emple=sLeer.next();
				Incidencia inci=new Incidencia(fecha_error,cod_emple,tipo_error);			
				int filas=bd.añadir_Incidencia(inci);				
				switch (filas){
				case 1:
					System.out.println("\nIncidencia añadida");
					break;
				case 0:
					System.out.println("\nNo añadida");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");
					break;
				break;
			case 2:
				System.out.println("Introduce codigo del empleado");
				cod_emple=sLeer.nextLine();
				System.out.println("Introduce la fecha de error ");
				fecha_error=sLeer.nextLine();
				filas=bd.borrar_Incidencias(cod_emple, fecha_error);	
				switch (filas){
				case 1:
					System.out.println("\nAlumno borrado");
					break;
				case 0:
					System.out.println("\nNo añadido");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");
					break;
					
				}	
				break;
			case 3:
				filas=bd.listadoIncidencias(cod_emple);
				if (incidencias==null){
						System.out.println("En este momento no podemos realizar la operación");
						break;
				}
				System.out.println("Lista de cursos");
				for (int i=0;i<incidencias.size();i++)
					System.out.println((i+1)+ ".- "+incidencias.get(i));				
				System.out.print("Teclea el codigo del empleado\t");
				cod_emple=sLeer.next();
				Vector <Incidencia> listado=bd.listadoIncidencias(cod_emple);
				for (int i=0;i<listado.size();i++)									
					System.out.println(listado.get(i).toString());
				break;

			}while (opc!=4);

	}

}

