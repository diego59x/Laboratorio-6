/**********************************************************
*Hash.java			Fecha de creacion: 06 de marzo
*					Ultima fecha de modificacion: 06 de marzo
*							
*Funciones que lleva a cabo el mapa HashMap
*
*@author Andrea Amaya #19357
*@author Diego Alvarez
**********************************************************/
import java.util.HashMap;

public class Hash<K, V> extends MapAbstract<K, V>{
	protected HashMap<K, V> cards = new HashMap<K, V>();

	public int size(){
		return cards.size();
	}

	public V put(K k, V v){
		return cards.put(k, v);
	}

	public V remove(K k){
		return cards.remove(k);
	}

    public V get(K k){
    	return cards.get(k);
    }

	public boolean containsKey(K k){
		return cards.containsKey(k);
	}
	
	public boolean containsValue(V v){
		return cards.containsValue(v);
	}
}