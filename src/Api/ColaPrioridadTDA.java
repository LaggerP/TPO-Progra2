/** 
 * @Autores: 
 * @Grupo: 
**/

/**
 * @TDA: ColaPrioridad	
 * @Definición: Es una estructura que a cada elemento cuando se la ingresa a la misma, se le 
 * asignar una prioridad, y luego los elementos van a ser recuperados o eliminados
 * de la estructura de acuerdo a esa prioridad.
**/

package Api;

public interface ColaPrioridadTDA {
	
	/** 
	 * @Tarea: Agrega valor a la cola con prioridad en su ubicacion correcta respetando la prioridad
	 * @Parámetros: Cola con prioridad, valor a agregar y prioridad del dato
	 * @Devuelve: Cola con prioridad con nuevo valor agregado y ordenado
	 * @Precondición: Que la cola con prioridad este inicializada
	 * @Postcondición: 
	**/
	void acolarPrioridad (int p,int x);

	/** 
	 * @Tarea: Saca el primer valor que se agrego a la cola con prioridad
	 * @Parámetros: Cola con prioridad
	 * @Devuelve: Cola con prioridad con un valor menos
	 * @Precondición: Que la cola con prioridad este inicializada y que no este vacia
	 * @Postcondición: 
	**/
    void desacolar();
    
	/** 
	 * @Tarea: Encuentra primer valor de la cola con prioridad
	 * @Parámetros: Cola con prioridad
	 * @Devuelve: Primer valor de la Cola con prioridad
	 * @Precondición: Que la cola con prioridad este inicializada y que no este vacia
	 * @Postcondición: 
	**/
    int primero();
    
	/** 
	 * @Tarea: Devuelve el valor que tiene mayor prioridad
	 * @Parámetros: Cola con prioridad
	 * @Devuelve: Prioridad del primer valor de la Cola con prioridad
	 * @Precondición: Que la cola con prioridad este inicializada y que no este vacia
	 * @Postcondición: 
	**/
    int prioridad();
    
	/** 
	 * @Tarea: Decir si la cola con prioridad esta vacia o no
	 * @Parámetros: Cola con prioridad
	 * @Devuelve: Verdadero o Falso
	 * @Precondición: Que la cola con prioridad este inicializada
	 * @Postcondición: 
	**/
    boolean colaVacia();
    
	/** 
	 * @Tarea: Inicializa la Cola con prioridad
	 * @Parámetros: Cola con prioridad
	 * @Devuelve: Cola con prioridad inicializada
	 * @Precondición: No hay
	 * @Postcondición: 
	**/
    void inicializarCola();
}
