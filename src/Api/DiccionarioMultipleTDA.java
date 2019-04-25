/** 
@Autores: 
@Grupo: 
**/


package Api;

public interface DiccionarioMultipleTDA {
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 void inicializarDiccionario();
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 void agregar(int c, int v);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 void eliminar (int c);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 ConjuntoTDA claves();
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 ConjuntoTDA recuperar (int c);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 void EliminarElem(int c, int x);
}
