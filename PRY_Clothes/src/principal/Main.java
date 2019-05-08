package principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import modelos.Incidencia;
import bbdd.BD_Incidencias;


public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opc=0;
		
		BD_Incidencias bd=new BD_Incidencias("proyecto2");
		LocalDate fecha_salida = null;
		boolean correcto=false;
	    DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");
		
		 do {
	         System.out.println("1.añadir incidencia");
	         System.out.println("2.borrar incidencia");
	         System.out.println("3.listar incidencia");
	         System.out.println("4. Salir");
	         opc=sc.nextInt();    
	        int filas;
			switch(opc) {
	         case 1:
			   do{
				   System.out.println("-----------------------------------------------------*Añadir incidencia *-----------------------------------------------------------");
			    	  System.out.println("dime fecha de error");
			      try {
			    	  sc.nextLine();
			    	  String fecha_error=sc.nextLine();
			    	  fecha_salida=LocalDate.parse(fecha_error, fechaFormateada);
			    	  correcto=true;
			      }catch(DateTimeParseException m) {
		    	   System.out.println("error en fecha tiene q estar en formato yyyy-LL-dd ");
		    	   correcto=true;
			      }
			      System.out.println("introduce codigo de empleado");;
			      String cod_emple=sc.nextLine();
			      System.out.println("introduce tipo de error");
			      String tipo_error=sc.nextLine();
			      Incidencia incidencia=new Incidencia(fecha_salida,cod_emple,tipo_error);			
			      filas=bd.añadir_Incidencia(incidencia);				
					switch (filas){
					case 1:
						System.out.println("\nIncidencia añadida");
						break;
					case 0:
						System.out.println("\nIncidencia No añadido");
						break;
					case -1:
						System.out.println("\nProblemas técnicos");
						break;
					}
					System.out.println("----------------------------------------------------------------------------------------");
				break;
		   }while(correcto!=true);
		break;
			case 2:
				System.out.println("-----------------------------------------------------* Borrar incidencia *-----------------------------------------------------------");
				sc.nextLine();
				System.out.println("Introduce codigo de empleado");
				String cod_emple=sc.nextLine();
				System.out.println("Introduce numero de incidencia ");
				String num_incidencia=sc.nextLine();	

				filas=bd.borrar_Incidencias(cod_emple,num_incidencia);
			
				switch (filas){
				case 1:
					System.out.println("\nIncidencia borrada");
					break;
				case 0:
					System.out.println("\nNo añadida");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");
					break;
				}	
				System.out.println("----------------------------------------------------------------------------------------");
				break;
			case 3:
				System.out.println("-----------------------------------------------------* Listar incidencia *-----------------------------------------------------------");
				Vector <Incidencia> incidencias=bd.listadoIncidencias();
				if (incidencias==null){
						System.out.println("En este momento no podemos realizar la operación");
						break;
				}
				System.out.println("Lista de Incidencias");
				for (int i=0;i<incidencias.size();i++)
					System.out.println(incidencias.get(i));
				System.out.println("----------------------------------------------------------------------------------------");
				break;
			}
		}while (opc!=4);
		
		 
	}

}

