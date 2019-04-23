/** 
	@Autores: 
	@Grupo: 
**/

/**
 * @TDA: 
 * @Definición: 
 **/


package Api;

public interface DiccionarioSimpleTDA {
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void InicializarDiccionario();
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void Agregar(int clave, int valor);
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void Eliminar(int clave);
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	float Recuperar(int clave);
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	ConjuntoTDA Claves();
}
