/**
 * @Autores: 
 * @Grupo: 
**/

/**
 * @TDA: Cola
 * @Definición: Una cola es una estructura que almacena valores, recupera y elimina el primer
 * valor ingresado, ademas nos permite conocer si la cola tiene o no elementos.
**/

package Api;

public interface ColaStringTDA {
	
	/** 
	 * @Tarea: Inicializar la cola
	 * @Parámetros: Cola
	 * @Devuelve: Cola inicializada
	 * @Precondición: No hay
	 * @Postcondición: 
	**/
	void InicializarCola();
	
	/** 
	 * @Tarea: Agrega un valor a la cola
	 * @Parámetros: Cola y el valor a ingresar
	 * @Devuelve: Cola con el valor nuevo ingresado
	 * @Precondición: Que la cola este inicializada
	 * @Postcondición: 
	**/
	void Acolar(String x);
	
	/** 
	 * @Tarea: Saca el primer valor de la cola
	 * @Parámetros: Cola
	 * @Devuelve: Cola con un valor menos
	 * @Precondición: Que la cola este inicializada y que no este vacia
	 * @Postcondición: 
	**/
	void Desacolar();
	
	/** 
	 * @Tarea: Decir si la cola esta vacia
	 * @Parámetros: Cola
	 * @Devuelve: Verdadero si la cola esta vacia, falso si la cola posee todavia valores
	 * @Precondición: Que la cola este inicializada
	 * @Postcondición: 
	**/
	boolean ColaVacia();
	
	/** 
	 * @Tarea: Encuentra el primer valor de la cola
	 * @Parámetros: Cola
	 * @Devuelve: El primer valor existente en la cola
	 * @Precondición: Que la cola este inicializada y no este vacia
	 * @Postcondición: 
	**/
	String Primero();
}
