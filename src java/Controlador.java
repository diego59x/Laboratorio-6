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
	private MapInterface<String, String> availableCards = new Hash<String, String>(); //Cartas disponibles
	private MapInterface<String, String> userCollection; //Coleccion del usuario
	private ArrayList<String> keys = new ArrayList<String>(); //Llaves en el texto
	private ArrayList<String> values = new ArrayList<String>(); //Valores en el texto

	private Factory factory = new Factory(); //Se instancia el factory

	//Se crean las cartas disponibles 
	public String createAvailable(){
		String txt = "", exepcion=""; //Las cartas se meteran a esta variable, el error se metera en esta variable
		//Se lee el txt
		try {
			Scanner r = new Scanner(new File("prueba.txt")); 
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
	public String option1(String nom){ //Agregar una carta
		String mensaje = "______________\nSe agrego correctamente\n______________";
		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(keys);
		ArrayList<String> clear_keys = new ArrayList<>(hashSet);
		for (int i = 0; i<clear_keys.size(); i++) {
	    	if (clear_keys.get(i).equalsIgnoreCase(nom)) {
	    		userCollection.put(nom,values.get(i));
	    	}
		}
		return mensaje;
	}
	public void option2(){ //Tipo de carta especifica

	}

	public ArrayList<String> option3(){ //Nombre, tipo, cantidad en coleccion
		ArrayList<String> cards = new ArrayList<String>();
		int monster = 0;
		int spell = 0;
		int charm = 0;

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);

		cards.add("Nombre_____________:Tipo_______________");
		cards.add("_______________________________________");
		for (Map.Entry<String, String> entry : userCollection.entrySet()) {
	    	cards.add(entry.getKey() + " : " + entry.getValue());
	    	if (entry.getValue().equalsIgnoreCase("monstruo")) {
	    		monster++;
	    	} else if (entry.getValue().equalsIgnoreCase("hechizo")) {
	    		spell++;
	    	} else {
	    		charm++;
	    	}
		}

		cards.add("_______________________________________");
		cards.add("Tipo Monstruo: " + monster);
		cards.add("Tipo Hechizo: " + spell);
		cards.add("Tipo Encanto: " + charm);
		cards.add("_______________________________________");

		return cards;
	}
	// ArrayList<ArrayList<String>>
	public void option4(){ //Ordenar por tipo coleccion

	}

	public ArrayList<ArrayList<String>> option5(){ //Mostrar nombre y tipo de cartas existentes
		// aqui 
		ArrayList<ArrayList<String>> sortByType = new ArrayList<ArrayList<String>>();
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
				if (values.get(j).equalsIgnoreCase(actualType)) {
					quantity++; 
					typeInfo.add(keys.get(j)); //Se guarda el nombre de la carta
				}
			}
			typeInfo.add(0,"_______________________________________");
			typeInfo.add(0, "Cantidad " + quantity); //Se agrega la cantidad
			typeInfo.add(0, "Tipo de carta " + actualType); //Se agrega el tipo
			typeInfo.add(0,"_______________________________________");

			sortByType.add(typeInfo); //Se agrega la infomracion del tipo de carta
		}

		return sortByType;
	}
//ArrayList<ArrayList<String>>
	public ArrayList<String> option6(){
		ArrayList<String> cards = new ArrayList<String>();
		int monster = 0;
		int spell = 0;
		int charm = 0;

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);

		cards.add("Nombre_____________:Tipo_______________");
		cards.add("_______________________________________");
		for (Map.Entry<String, String> entry : availableCards.entrySet()) {
	    	cards.add(entry.getKey() + " : " + entry.getValue());
	    	if (entry.getValue().equalsIgnoreCase("monstruo")) {
	    		monster++;
	    	} else if (entry.getValue().equalsIgnoreCase("hechizo")) {
	    		spell++;
	    	} else {
	    		charm++;
	    	}
		}

		cards.add("_______________________________________");
		cards.add("Tipo Monstruo: " + monster);
		cards.add("Tipo Hechizo: " + spell);
		cards.add("Tipo Encanto: " + charm);
		cards.add("_______________________________________");

		return cards;
	} //Ordenar por tipo cartas existentes
	
}





