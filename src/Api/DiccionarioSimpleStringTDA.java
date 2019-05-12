/** 
	@Autores: plagger, ncheheid, afierro
	@Grupo: 2
**/

/**
 * @TDA: DiccionarioSimpleStringTDA
 * @Definición: estructura de datos diccionario multiple se caracteriza porque cada valor
 * ingresa a la estructura asociado a una clave, y estas claves existen siempre que
 * tengan valor asociado y son unicas. Cada clave tiene un unico valor asociado
 **/

package Api;

public interface DiccionarioSimpleStringTDA {

	/**
	 * @Tarea: Inicializar Diccionario Simple
	 * @Parámetros: Diccionario
	 * @Devuelve: Diccionario inicializado
	 * @Precondición: No hay
	 * @Postcondición:
	 **/
	void InicializarDiccionario();

	/**
	 * @Tarea: Agrego una clave con su valor al diccionario
	 * @Parámetros: Diccionario, clave y valor
	 * @Devuelve: Diccinario con una clave y valor adicional
	 * @Precondición: Que el diccionario este inicializado
	 * @Postcondición:
	 **/
	void Agregar(String clave, String valor);

	/**
	 * @Tarea: Elimino una clave y su valor del diccionario
	 * @Parámetros: Diccionario y clave
	 * @Devuelve: Diccionario con un valor menos
	 * @Precondición: Que el diccionario este inicializado
	 * @Postcondición:
	 **/
	void Eliminar(String clave);

	/**
	 * @Tarea: Me devuelve el valor de una clave solicitada
	 * @Parámetros: Diccionario y clave
	 * @Devuelve: Valor de una clave
	 * @Precondición: Que el diccionario este inicializado y que exista la clave
	 * @Postcondición:
	 **/
	String Recuperar(String clave);

	/**
	 * @Tarea: Me devuelve todas las claves que tiene el diccionario
	 * @Parámetros: Diccionario
	 * @Devuelve: Conjunto de claves
	 * @Precondición: Que el diccionario este inicializado
	 * @Postcondición:
	 **/
	ConjuntoStringTDA Claves();
}
