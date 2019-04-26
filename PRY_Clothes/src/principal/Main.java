package principal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import modelos.Incidencia;


public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opc=0;
		bbdd.BD_Incidencias bd=new bbdd.BD_Incidencias("proyecto2");
		LocalDate fecha_salida = null;
		boolean correcto=false;
	    DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");
		
		 do {
	         System.out.println("1.añadir incidencia");
	         System.out.println("2.borrar incidencia");
	         System.out.println("3.listar incidencia");
	         opc=sc.nextInt();    
	        int filas;
			switch(opc) {
	         case 1:
			   do{
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
			      System.out.println("introduce codigo de error");
			      String tipo_error=sc.nextLine();
			      System.out.println("introduce el numero de incidencia");
			      int num_incidencia=sc.nextInt();
			      Incidencia incidencia=new Incidencia(fecha_salida,cod_emple,tipo_error,num_incidencia);			
				filas=bd.añadir_Incidencia(incidencia);				
					switch (opc){
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
				break;
		   }while(correcto!=true);
		break;
			case 2:
				sc.nextLine();
				System.out.println("Introduce codigo de incidencia");
				String cod_emple=sc.nextLine();
				System.out.println("Introduce numero de incidencia ");
				String num_incidencia=sc.nextLine();
				filas=bd.borrar_Incidencias(cod_emple,num_incidencia, fecha_salida);	
				switch (opc){
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
	
				break;
			case 3:
				Vector <String> incidencias=bd.listadoIncidencias();
				if (incidencias==null){
						System.out.println("En este momento no podemos realizar la operación");
						break;
				}
				System.out.println("Lista de Incidencias");
				for (int i=0;i<incidencias.size();i++)
					System.out.println(incidencias.get(i).toString());
				break;	
			}
		}while (opc!=3);
		
		 
	}

}

