/** 
 * @Autores: plagger, ncheheid
 * @Grupo: 2
**/

/**
 * @TDA: ConjuntoStringTDA
 * @Definición: es una estructura que nos permite guardar elementos y en donde no se tiene un orden, y ademas nos permite conocer si
 * un elemento dado se encuentra o pertenece a la estructura.
 **/

package Api;

public interface ConjuntoStringTDA {
	/**
	 * @Tarea: Inicializa el conjunto
	 * @Parámetros: Conjunto
	 * @Devuelve: Conjunto inicializado
	 * @Precondición: No hay
	 * @Postcondición:
	 **/
	void InicializarConjunto();

	/**
	 * @Tarea: Elige un numero al azar del conjunto
	 * @Parámetros: Conjunto
	 * @Devuelve: Valor del conjunto
	 * @Precondición: Que el conjunto no este vacio y este inicializado
	 * @Postcondición:
	 **/
	String Elegir();

	/**
	 * @Tarea: Eliminar valor deseado al conjunto
	 * @Parámetros: Conjunto y dato a eliminar
	 * @Devuelve: Conjunto con un valor menos
	 * @Precondición: Que el conjunto este inicializado y no este vacio
	 * @Postcondición:
	 **/
	void Sacar(String x);

	/**
	 * @Tarea: Agregar valor deseado al conjunto
	 * @Parámetros: Conjunto y dato a agregar
	 * @Devuelve: Conjunto con un valor mas
	 * @Precondición: Que el conjunto este inicializado
	 * @Postcondición:
	 **/
	void Agregar(String clave);

	/**
	 * @Tarea: Decir si el conjunto esta vacio o no
	 * @Parámetros: Conjunto
	 * @Devuelve: Verdadero o falso
	 * @Precondición: Conjunto inicializado
	 * @Postcondición:
	 **/
	boolean ConjuntoVacio();

	/**
	 * @Tarea: Decir si un valor se encuentra dentro de mi conjunto o no
	 * @Parámetros: Conjunto y valor que quiero buscar
	 * @Devuelve: Verdadero o Falso
	 * @Precondición: Que el conjunto este inicializado
	 * @Postcondición:
	 **/
	boolean Pertenece(String x);

}
