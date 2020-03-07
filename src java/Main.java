/**********************************************************
*Main.java							Fecha de creación: 06 de marzo
*							        Última fecha de modificación: 
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

		Boolean pedir = true;
		int mapa_escogido=0, opcion_escogida=0;

		exepcion = controlador.createAvailable(); //Se crean las cartas disponibles y se jala si hay excepcion

		//Se ordenan los datos
		System.out.println("_______________________________________\n         ESCOJA EL TIPO DE MAPA:          \n_______________________________________\n1. HashMap\n2. LinkedMap\n3. TreeMap\nElija la opcion: ");		
		
		//Se revisa que se ingrese un entero dentro del rango
		while(pedir){
			String mapa = scan.next();
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


		//Si no hay exepcion, se pide la accion a realizar
		if (exepcion.equalsIgnoreCase("")) {
			while(opcion_escogida != 7){
				System.out.println("_______________________________________\n         ESCOJA LA ACCION A REALIZAR:          \n_______________________________________");
				System.out.println("\n1. Agregar una carta a la coleccion\n2. Mostrar el tipo de una carta en especifico\n3. Mostrar el nombre, tipo y cantidad de cada carta en la coleccion\n4. Ordenar por tipo todas las cartas de la coleccion\n5. Mostrar nombre y tipo de todas las cartas existentes\n6. Ordenar por tipo las cartas existentes\n7. Salir\nElija la opcion: ");
				
				//Se revisa que la opcion sea un entero y este dentro del rango
				while(pedir){
					String opcion = scan.next();
					try {
						opcion_escogida = Integer.parseInt(opcion);
						if (opcion_escogida<=6 && opcion_escogida>0) {
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
						controlador.option1();
						break;
					case 2:
						controlador.option2();
						break;
					case 3:
						System.out.println(controlador.option3());
						break;
					case 4:
						controlador.option4();
						break;
					case 5:
						controlador.option5();
						break;
					default:
						controlador.option6();
						break;	
				}

			}



		}
			
	}
}