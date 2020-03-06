/**********************************************************
*Factory.java				Fecha de creacion: 06 de marzo
*							Ultima fecha de modificacion: 06 de marzo
*							
*Factory para instanciar los mapas
*
*@author Andrea Amaya #19357
*@author Diego Alvarez
**********************************************************/
public class Factory{
	/**
	//Pre: Haber elegido un mapa 
	//Post: Intancia de tipo del mapa seleccionado
	 * @param tipoMapa  Tipo de mapa a instanciar
	*/
	public MapInterface getStack(int tipoMapa){
		if (tipoMapa == 1) { //Es un hashMap
			return new Hash<String, String>();
		} /*else if (tipoMapa == 2) { //Es un linkedMap
			return new Linked<String, String>();
		} else { //Es un treeMap
			return new Tree<String, String>();
		}*/

		return new Hash<String, String>();
	}
}