/** 
 * @Autores: 
 * @Grupo: 
**/

/**
 * @TDA: Pila
 * @Definición: Definicion: La pila es una estructura que almacena, elimina y recupera conjuntos de valores,
 * con la particularidad de que el elemento que se recupera o elimina es el ultimo que ingreso.
**/

package Api;

public interface PilaTDA {
	/** 
	 * @Tarea: Inicializar la Pila
	 * @Parámetros: Pila
	 * @Devuelve: Pila inicializada
	 * @Precondición: No hay
	 * @Postcondición: No hay
	**/
	void InicializarPila();
	
	/** 
	 * @Tarea: Agregar un valor a la pila
	 * @Parámetros: Dato a agregar
	 * @Devuelve: Pila con nuevo valor
	 * @Precondición: Que la pila este inicializada
	 * @Postcondición: 
	**/
    void Apilar(int x);
    
	/** 
	 * @Tarea: Sacar un valor de la pila
	 * @Parámetros: Pila
	 * @Devuelve: Pila con un valor menos
	 * @Precondición: Que la pila este inicializada y que no este vacia
	 * @Postcondición: 
	**/
    void Desapilar();
    
	/** 
	 * @Tarea: Encuentra el ultimo valor ingresado en la pila
	 * @Parámetros: Pila
	 * @Devuelve: Primer valor de la pila
	 * @Precondición: Que la pila este inicializada y no este vacia
	 * @Postcondición: 
	**/
    int Tope();
    
	/** 
	 * @Tarea: Confirmar si la pila esta vacia o no
	 * @Parámetros: Pila
	 * @Devuelve: Verdadero si la pila esta vacia, falso si la pila posee algun valor
	 * @Precondición: Que la pila este inicializada
	 * @Postcondición: 
	**/
    boolean PilaVacia();

	
}
