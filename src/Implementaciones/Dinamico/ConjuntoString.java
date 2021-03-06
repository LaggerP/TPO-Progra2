/** 
@Autores: plagger, ncheheid
@Grupo: 2
**/

package Implementaciones.Dinamico;

import Api.ConjuntoStringTDA;

public class ConjuntoString implements ConjuntoStringTDA {

	class nodo {
		String valor;
		nodo sig;
	}

	nodo inicio;

	@Override
	/**Costo: C **/
	public void InicializarConjunto() {
		inicio = null;
	}

	@Override
	/**Costo: C **/
	public String Elegir() {
		return inicio.valor;
	}

	@Override
	/**Costo: Lineal **/
	public void Sacar(String x) {
		nodo actual = inicio, anterior = null;
		while (actual != null && actual.valor.compareTo(x) != 0) {
			anterior = actual;
			actual = actual.sig;
		}
		if (actual != null) {
			if (anterior == null) {
				inicio = inicio.sig;
			} else {
				anterior.sig = actual.sig;
			}
		}
	}

	@Override
	/**Costo: Lineal **/
	public void Agregar(String x) {
		if (!Pertenece(x)) {
			nodo nuevo = new nodo();
			nuevo.valor = x;
			nuevo.sig = inicio;
			inicio = nuevo;
		}
	}

	@Override
	/**Costo: C **/
	public boolean ConjuntoVacio() {
		return inicio == null;
	}

	@Override
	/**Costo: Lineal **/
	public boolean Pertenece(String x) {
		nodo actual = inicio;
		while (actual != null && actual.valor.compareTo(x) != 0) {
			actual = actual.sig;
		}
		return (actual != null);
	}
}
