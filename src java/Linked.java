/**********************************************************
*Linked.java		Fecha de creacion: 06 de marzo
*					Ultima fecha de modificacion: 06 de marzo
*							
*Funciones que lleva a cabo el mapa Linked Map
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/

import java.util.LinkedHashMap;
import java.util.*;
public class Linked<K,V> extends MapAbstract<K,V>{

	protected LinkedHashMap<K,V> linked = new LinkedHashMap<K,V>();

	public V get(K key){
		return linked.get(key);
	}
	public V put(K key, V value){
		return linked.put(key, value);
	}
	public V remove(K key){
		return linked.remove(key);
	}

	public int size(){
		return linked.size();
	}
	public boolean containsKey(K key){
		return linked.containsKey(key);
	}

	public boolean containsValue(V value){
		return linked.containsValue(value);
	}
	public Set<Map.Entry<K,V>> entrySet(){
		return linked.entrySet();
	}
}
