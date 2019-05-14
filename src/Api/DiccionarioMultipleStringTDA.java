/** 
 * @Autores: plagger, ncheheid
 * @Grupo: 2
**/
/**
 * @TDA: DiccionarioMultipleStringTDA
 * @Definición: estructura de datos diccionario multiple se caracteriza porque cada valor
 * ingresa a la estructura asociado a una clave, y estas claves existen siempre que
 * tengan valor asociado y son unicas. Cada clave puede tener multiples valores
 **/

package Api;

public interface DiccionarioMultipleStringTDA {

	/**
	 * @Tarea: Inicializa el Diccionario multiple
	 * @Parámetros: diccionario
	 * @Devuelve: diccionario inicializado
	 * @Precondición: No hay
	 * @Postcondición:
	 **/
	void inicializarDiccionario();

	/**
	 * @Tarea: Agrego una clave con su o sus valores al diccionario
	 * @Parámetros: Diccionario, clave y valor
	 * @Devuelve: Diccinario con una clave con su valor
	 * @Precondición: Que el diccionario este inicializado
	 * @Postcondición:
	 **/
	void agregar(String clave, String dato);

	/**
	 * @Tarea: Elimino una clave y su valores del diccionario
	 * @Parámetros: Diccionario y clave
	 * @Devuelve: Diccionario con un valor menos
	 * @Precondición: Que el diccionario este inicializado
	 * @Postcondición:
	 **/
	void eliminar(String c);

	/**
	 * @Tarea: Me devuelve todas las claves que tiene el diccionario
	 * @Parámetros: Diccionario
	 * @Devuelve: Conjunto de claves
	 * @Precondición: Que el diccionario este inicializado
	 * @Postcondición:
	 **/
	ConjuntoStringTDA claves();

	/**
	 * @Tarea: Me devuelve el o los valores de una clave solicitada
	 * @Parámetros: Diccionario y clave
	 * @Devuelve: Valor de una clave
	 * @Precondición: Que el diccionario este inicializado y que exista la clave
	 * @Postcondición:
	 **/
	ConjuntoStringTDA recuperar(String c);

	/**
	 * @Tarea: Elimino un elemento de la clave del diccionario
	 * @Parámetros: Diccionario, clave y valor
	 * @Devuelve: Diccionario con un valor menos de una clave
	 * @Precondición: Que el diccionario este inicializado y tenga valores
	 *                existentes
	 * @Postcondición:
	 **/
	void EliminarElem(String c, String dato);

}
