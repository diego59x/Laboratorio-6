/**********************************************************
*Controlador.java	Fecha de creacion: 06 de marzo
*					Ultima fecha de modificacion: 10 de marzo
*							
*Funciones que se llevaran a cabo en el main
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
import java.util.*;
import java.io.*; 


public class Controlador{
	private MapInterface<String, String> availableCards; //Cartas disponibles
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
		userCollection = factory.getMap(mapa_escogido); //Se crea el tipo de Mapa del usuario
		availableCards = factory.getMap(mapa_escogido); //Se crea el tipo de Mapa de la colección
	}

	//Se lleva a cabo la operacion pedida
	public String option1(String nom){ //Agregar una carta
		String mensaje = ""; 
		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(keys);
		ArrayList<String> clear_keys = new ArrayList<>(hashSet);
		//Se revisa que el nombre de la carta sea existente entre las cartas disponibles
		for (int i = 0; i<clear_keys.size(); i++) {
	    	if (clear_keys.get(i).equalsIgnoreCase(nom)) {
	    		userCollection.put(nom,values.get(i));
	    		i = clear_keys.size();

	    		mensaje = "_______________________________________\nSE AGREGO CORRECTAMENTE\n_______________________________________";
	    	}else{
	    		mensaje = "_______________________________________\nNO EXISTE LA CARTA\n_______________________________________";
	    	}
		}

		return mensaje;
	}
	public String option2(String nom){ //Tipo de carta especifica
		String tipo = "";
		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(keys);
		ArrayList<String> clear_keys = new ArrayList<>(hashSet);
		//Se obtiene el tipo de la 
		for (int i = 0; i<clear_keys.size(); i++) {
	    	if (clear_keys.get(i).equalsIgnoreCase(nom)) {
	    		tipo = values.get(i);
	    	} 
		} if (tipo.equals("")) {
			tipo = "_______________________________________\nNO EXISTE LA CARTA\n_______________________________________";
		}
		return tipo;
	}

	public ArrayList<String> option3(){ //Nombre, tipo, cantidad en coleccion
		ArrayList<String> cards = new ArrayList<String>();
		int monster = 0;
		int spell = 0;
		int trap = 0;

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);

		if (!userCollection.isEmpty()) {
			cards.add("Nombre_____________:Tipo_______________");
			cards.add("_______________________________________");
			for (Map.Entry<String, String> entry : userCollection.entrySet()) {
		    	cards.add(entry.getKey() + " : " + entry.getValue());
		    	if (entry.getValue().equalsIgnoreCase("monstruo")) {
		    		monster++;
		    	} else if (entry.getValue().equalsIgnoreCase("hechizo")) {
		    		spell++;
		    	} else {
		    		trap++;
		    	}
			}

			cards.add("_______________________________________");
			cards.add("Tipo Monstruo: " + monster);
			cards.add("Tipo Hechizo: " + spell);
			cards.add("Tipo Trampa: " + trap);
			cards.add("_______________________________________");			
		} else {
			cards.add("_______________________________________");
			cards.add("             NO HAY CARTAS");
			cards.add("_______________________________________");
		}


		return cards;
	}
	
	public ArrayList<String> option4(){ //Ordenar por tipo coleccion
		ArrayList<String> cards = new ArrayList<String>();
		int monster = 0;
		int spell = 0;
		int trap = 0;

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);

		//Se obtiene nombre y tipo
		if (!userCollection.isEmpty()) {
			for (Map.Entry<String, String> entry : userCollection.entrySet()) {
		    	cards.add(entry.getValue() + " : " + entry.getKey());
		    	if (entry.getValue().equalsIgnoreCase("monstruo")) {
		    		monster++;
		    	} else if (entry.getValue().equalsIgnoreCase("hechizo")) {
		    		spell++;
		    	} else if (entry.getValue().equalsIgnoreCase("trampa")){
		    		trap++;
		    	} 
			}

			Collections.sort(cards); //Se ordenan alfabeticamente
			cards.add(0, "_______________________________________");
			cards.add(0, "Tipo_____________:Nombre_______________"); 
			cards.add("_______________________________________");
			cards.add("Tipo Monstruo: " + monster);
			cards.add("Tipo Hechizo: " + spell);
			cards.add("Tipo Trampa: " + trap);
			cards.add("_______________________________________");			
		} else {
			cards.add("_______________________________________");
			cards.add("             NO HAY CARTAS");
			cards.add("_______________________________________");			
		}


		return cards;
	}

	public ArrayList<String> option5(){ //Mostrar nombre y tipo de cartas existentes
		ArrayList<String> cards = new ArrayList<String>();

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);

		//Se hace la cantidad de tipos de cartas que hayan

		//Se van mostrando  tipo y nombre
		for (Map.Entry<String, String> entry : availableCards.entrySet()) {
			cards.add(entry.getValue() + " : " + entry.getKey());
		}

		return cards;
	}

	public ArrayList<String> option6(){//Ordenar por tipo cartas existentes
		ArrayList<String> cards = new ArrayList<String>();
		int monster = 0;
		int spell = 0;
		int trap = 0;

		//Se eliminan las llaves duplicadas
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(values);
		ArrayList<String> clear_values = new ArrayList<>(hashSet);
		
		//Se van mostrando  tipo y nombre
		for (Map.Entry<String, String> entry : availableCards.entrySet()) {
	    	cards.add(entry.getValue() + " : " + entry.getKey());
	    	if (entry.getValue().equalsIgnoreCase("monstruo")) {
	    		monster++;
	    	} else if (entry.getValue().equalsIgnoreCase("hechizo")) {
	    		spell++;
	    	} else if (entry.getValue().equalsIgnoreCase("trampa")) {
	    		trap++;
	    	}
		}

		Collections.sort(cards); //Se ordenan alfabeticamente

		cards.add(0, "Tipo_____________:Nombre_______________");
		cards.add(0, "_______________________________________"); 
		cards.add("_______________________________________");
		cards.add("Tipo Monstruo: " + monster);
		cards.add("Tipo Hechizo: " + spell);
		cards.add("Tipo Trampa: " + trap);
		cards.add("_______________________________________");

		return cards;
	} 
	
}





