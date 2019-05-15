package Api;

public interface ABBTDA {
	void inicializarArbol();
	String raiz();
	ABBTDA hijoIzq();
	ABBTDA hijoDer();
	void agregar (String x);
	void eliminar (String x);
	boolean arbolVacio();
}