/** 
	@Autores: 
	@Grupo: 
**/

/**
 * @TDA: 
 * @Definición: 
 **/


package Api;

public interface DiccionarioSimpleStringTDA {
	
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
	void Agregar(String clave, String valor);
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	void Eliminar(String clave);
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	String Recuperar(String clave);
	
	/** 
	 * @Tarea: 
	 * @Parámetros: 
	 * @Devuelve: 
	 * @Precondición: 
	 * @Postcondición: 
	**/
	ConjuntoStringTDA Claves();
}
