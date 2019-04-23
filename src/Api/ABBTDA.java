/** 
@Autores: 
@Grupo: 
**/


package Api;

public interface ABBTDA {
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void inicializarArbol();
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	int raiz();
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	ABBTDA hijoIzq();
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	ABBTDA hijoDer();
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void agregar (int x);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void eliminar (int x);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	boolean arbolVacio();
}