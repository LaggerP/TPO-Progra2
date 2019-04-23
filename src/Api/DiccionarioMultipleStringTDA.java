/** 
 * @Autores: plagger
 * @Grupo: 
**/


package Api;


public interface DiccionarioMultipleStringTDA {
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
	 void agregar(String clave, String dato);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 void eliminar (String c);
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
	 ConjuntoTDA recuperar (String c);
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	 void EliminarElem(String c, String dato);
	
}
