/**********************************************************
*Tree.java			Fecha de creacion: 06 de marzo
*					Ultima fecha de modificacion: 06 de marzo
*							
*Funciones que lleva a cabo el mapa TreeMap
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
import java.util.*;
import java.util.TreeMap;
public class Tree<K,V> extends MapAbstract<K,V>/**, Cloneable, Serializable*/{

	protected TreeMap<K,V> tree = new TreeMap<K,V>();

	public V get(K key){
		return tree.get(key);
	}
	public V put(K key, V value){
		return tree.put(key, value);
	}
	public V remove(K key){
		return tree.remove(key);
	}

	public int size(){
		return tree.size();
	}
	public boolean containsKey(K key){
		return tree.containsKey(key);
	}

	public boolean containsValue(V value){
		return tree.containsValue(value);
	}

	public Set<Map.Entry<K,V>> entrySet(){
		return tree.entrySet();
	}
}
