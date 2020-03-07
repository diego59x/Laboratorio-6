/**********************************************************
*Controlador.java	Fecha de creacion: 06 de marzo
*					Ultima fecha de modificacion: 06 de marzo
*							
*Funciones que se llevaran a cabo en el main
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
import java.util.*;
import java.io.*; 


public class Controlador{
	private HashMap<String, String> availableCards = new HashMap<String, String>(); //Cartas disponibles
	private MapInterface<String, String> userCollection; //Coleccion del usuario
	private ArrayList<String> keys = new ArrayList<String>(); //Llaves en el texto
	private ArrayList<String> values = new ArrayList<String>(); //Valores en el texto

	private Factory factory = new Factory(); //Se instancia el factory

	//Se crean las cartas disponibles 
	public String createAvailable(){
		String txt = "", exepcion=""; //Las cartas se meteran a esta variable, el error se metera en esta variable
		//Se lee el txt
		try {
			Scanner r = new Scanner(new File("cards_desc.txt")); 
			while (r.hasNextLine()) {
				txt = r.nextLine(); //Mientras hayan lineas por leer se meten a la variable txt

				String[] partes = txt.split("\\|"); 
				keys.add(partes[0]); 
				values.add(partes[1]); 

				availableCards.put(partes[0], partes[1]); //Se agrega al diccionario
			}
			r.close();	
		} catch (Exception e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
			exepcion += "\nEl archivo no se encuentra";
		}
		
		return exepcion;
	}

	//Se genera el factory
	public void createMapCollection(int mapa_escogido){
		userCollection = factory.getMap(mapa_escogido); //Se crea el tipo de Stack
	}

	//Se lleva a cabo la operacion pedida
	public void option1(){ //Agregar una carta

	}
	public void option2(){ //Tipo de carta especifica

	}

	public ArrayList<ArrayList<String>> option3(){ //Nombre, tipo, cantidad en coleccion
		ArrayList<ArrayList<String>> option3 = new ArrayList<ArrayList<String>>();
		ArrayList<String> typeInfo = new ArrayList<String>();

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);

		//Se hace la cantidad de tipos de cartas que hayan
		for (int i=0; i<clear_values.size(); i++) {
			typeInfo = new ArrayList<String>(); //Se crea en limpio
			int quantity = 0; //Se regresa a 0
			String actualType = clear_values.get(i); //Se obtiene el tipo actual
			
			for (int j=0; j<keys.size(); j++) {
				//Se obtiene la cantidad de cartas con ese tipo
				if (userCollection.containsValue(actualType)) {
					quantity++; 
					typeInfo.add(keys.get(j)); //Se guarda el nombre de la carta
				}
			}

			typeInfo.add(0, "Cantidad " + quantity); //Se agrega la cantidad
			typeInfo.add(0, "Tipo de carta " + actualType); //Se agrega el tipo

			option3.add(typeInfo); //Se agrega la infomracion del tipo de carta
		}

		return option3;
	}

	public void option4(){ //Ordenar por tipo coleccion

	}
	public void option5(){ //Mostrar nombre y tipo de cartas existentes

	}
	public void option6(){ //Ordenar por tipo cartas existentes

	}



}