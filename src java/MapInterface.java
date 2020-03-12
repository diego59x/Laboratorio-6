/**********************************************************
*MapInterface.java			Fecha de creacion: 06 de marzo
*							Ultima fecha de modificacion: 06 de marzo
*							
*Interfaz que contiene los metodos que puede usar un Mapa
*
*@author Andrea Amaya #19357
*@author Diego Alvarez #19498
**********************************************************/
import java.util.*;
public interface MapInterface<K, V>{
	/**
	Pre: Tener un map para obtener el tamano
	Post: Tamano del map
	*/
	public int size();

    /**
	Pre: Tener una llave y un valor
	Post: Inserta un valor a la llave
	* @param k  Llave
	* @param v  Valor
	*/
	public V put(K k, V v);

	/**
	Pre: La llave existe
	Post: Remueve la llave con su valor
	* @param k  Llave
	*/
	public V remove(K k);

	/**
	Pre: La llave existe
	Post: Retorna el valor asignado a la llave
	* @param k  Llave
	*/	
    public V get(K k);

	/**
	Pre: La llave existe
	Post: Retorna verdadero si la llave se encuentra en el mapa
	* @param k  Llave
	*/	
	public boolean containsKey(K k);

	/**
	Pre: El valor existe
	Post: Retorna verdadero si el valor se encuentra en el mapa
	* @param v Valor
	*/	
	public boolean containsValue(V v);

	/**
	Pre: 
	Post: Retorna los elementos dentro del mapa
	*/
	public Set<Map.Entry<K,V>> entrySet();

	/**
	Pre: Hay un mapa
	Post: Se retorna true si el mapa esta vacio
	*/
	public boolean isEmpty();
}