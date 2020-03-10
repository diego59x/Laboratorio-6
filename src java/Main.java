/**********************************************************
*Main.java							Fecha de creación: 06 de marzo
*							        Última fecha de modificación: 10 de marzo
*							
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
import java.util.*;
import java.io.*; 

public class Main{
	public static void main(String[] args) {
		String exepcion=""; //Si hay error se metera en esta variable
		Controlador controlador = new Controlador();
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		Boolean pedir = true;
		int mapa_escogido=0, opcion_escogida=0;

		//Se ordenan los datos
		System.out.println("_______________________________________\n         ESCOJA EL TIPO DE MAPA:          \n_______________________________________\n1. HashMap\n2. LinkedMap\n3. TreeMap\nElija la opcion: ");		
		
		//Se revisa que se ingrese un entero dentro del rango
		while(pedir){
			String mapa = scan.nextLine();
			try {
				mapa_escogido = Integer.parseInt(mapa);
				if (mapa_escogido<=3 && mapa_escogido>0) {
					pedir = false;
				} else {
					System.out.println("Ingrese un numero dentro del rango");
				}	
			} catch (Exception e){
				System.out.println("Ingrese un numero entero");
			}
		}
		pedir = true;

		controlador.createMapCollection(mapa_escogido); //Se genera el mapa de la coleccion	userCollection
		exepcion = controlador.createAvailable(); //Se crean las cartas disponibles y se jala si hay excepcion

		//Si no hay exepcion, se pide la accion a realizar
		if (exepcion.equalsIgnoreCase("")) {
			while(opcion_escogida != 7){
				System.out.println("_______________________________________\n   ESCOJA LA ACCION A REALIZAR:   \n_______________________________________");
				System.out.println("\n1. Agregar una carta a la coleccion\n2. Mostrar el tipo de una carta en especifico\n3. Mostrar el nombre, tipo y cantidad de cada carta en la coleccion\n4. Ordenar por tipo todas las cartas de la coleccion\n5. Mostrar nombre y tipo de todas las cartas existentes\n6. Ordenar por tipo las cartas existentes\n7. Salir\nElija la opcion: ");
				
				//Se revisa que la opcion sea un entero y este dentro del rango
				while(pedir){
					String opcion = scan.nextLine();
					try {
						opcion_escogida = Integer.parseInt(opcion);
						if (opcion_escogida<=7 && opcion_escogida>0) {
							pedir = false;
						} else {
							System.out.println("Ingrese un numero dentro del rango");
						}	
					} catch (Exception e){
						System.out.println("Ingrese un numero entero");
					}
				}

				pedir = true; //Se regresa a verdadero


				switch(opcion_escogida) {
					case 1:
						System.out.println("_______________________________________\n   INGRESE EL NOMBRE DE LA CARTA   \n_______________________________________");
						String nombre = scan2.nextLine();
						System.out.println(controlador.option1(nombre));						
						break;
					case 2:
						System.out.println("_______________________________________\n   INGRESE NOMBRE DE LA CARTA   \n_______________________________________");
						String tipo = scan2.nextLine();
						System.out.println(controlador.option2(tipo));		
						break;
					case 3:
						ArrayList<String> opt3 = controlador.option3();
						for (int i=0; i<opt3.size(); i++) {
							System.out.println(opt3.get(i));
						}
						break;
						
						//break;
					case 4:
						ArrayList<String> opt4 = controlador.option4();
						for (int i=0; i<opt4.size(); i++) {
							System.out.println(opt4.get(i));
						}
						break;
					case 5:
						ArrayList<String> opt5 = controlador.option5();
						for (int i=0; i<opt5.size(); i++) {
							System.out.println(opt5.get(i));
						}
						break;
					case 6:
						ArrayList<String> opt6 = controlador.option6();
						for (int i=0; i<opt6.size(); i++) {
							System.out.println(opt6.get(i));
						}
						break;
					case 7:
						break;	
				}
			}
		} else {
			System.out.println("_______________________________________\nEXEPCION\n" + exepcion + "\n_______________________________________");
		}		
			
	}
		
}