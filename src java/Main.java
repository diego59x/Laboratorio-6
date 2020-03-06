/**********************************************************
*Main.java							Fecha de creación: 06 de marzo
*							        Última fecha de modificación: 
*							
*@author Andrea Amaya #19357
*@author Diego Alvarez
**********************************************************/
import java.util.*;
import java.io.*; 

public class Main{
	public static void main(String[] args) {
		String txt = "", exepcion=""; //Las cartas se meteran a esta variable, el error se metera en esta variable
		Factory factory = new Factory();
		MapInterface<String, String> mapElegido;
		String[] cartas; //Cartas a leer
		Scanner scan = new Scanner(System.in);
		Boolean pedir = true;
		int mapa_escogido=0;


		//Se lee el txt
		try {
			Scanner r = new Scanner(new File("cards_desc.txt")); 
			while (r.hasNextLine()) {
				txt += (r.nextLine()); //Mientras hayan lineas por leer se meten a la variable txt
			}
			r.close();	
		} catch (Exception e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
		}
		cartas = txt.split("|"); //Cartas creada a partir del txt

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
		
		mapElegido = factory.getStack(mapa_escogido); //Se crea el tipo de Stack	
	}
}