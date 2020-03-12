/**********************************************************
*Hash.java			Fecha de creacion: 06 de marzo
*					Ultima fecha de modificacion: 06 de marzo
*							
*Funciones que lleva a cabo el mapa HashMap
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
import java.util.HashMap;
import java.util.*;

public class Hash<K, V> extends MapAbstract<K, V>{
	protected HashMap<K, V> hash = new HashMap<K, V>();

	public int size(){
		return hash.size();
	}

	public V put(K k, V v){
		return hash.put(k, v);
	}

	public V remove(K k){
		return hash.remove(k);
	}

    public V get(K k){
    	return hash.get(k);
    }

	public boolean containsKey(K k){
		return hash.containsKey(k);
	}
	
	public boolean containsValue(V v){
		return hash.containsValue(v);
	}

	public Set<Map.Entry<K,V>> entrySet(){
		return hash.entrySet();
	}

	public Set<K> keySet(){
		return hash.keySet();
	}

}