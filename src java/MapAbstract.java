/**********************************************************
*MapAbstract.java			Fecha de creacion: 06 de marzo
*							Ultima fecha de modificacion: 06 de marzo
*							
*Abstracta que contiene los metodos que puede usar un Mapa
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
public abstract class MapAbstract<K, V> implements MapInterface<K, V>{
	public boolean isEmpty(){
		return size() ==0;
	}
}