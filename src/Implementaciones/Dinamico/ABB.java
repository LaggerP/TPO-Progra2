package Implementaciones.Dinamico;

import Api.ABBTDA;

public class ABB implements ABBTDA {

	class nodo {
		String dato;
		ABBTDA izq, der;
	}

	nodo primer;

	@Override
	public void inicializarArbol() {
		primer = null;
	}

	@Override
	public String raiz() {
		return primer.dato;
	}

	@Override
	public ABBTDA hijoIzq() {
		return primer.izq;
	}

	@Override
	public ABBTDA hijoDer() {
		return primer.der;
	}

	@Override
	public void agregar(String x) {
		if (arbolVacio()) {
			nodo nuevo = new nodo();
			nuevo.dato = x;
			nuevo.izq = new ABB();
			nuevo.izq.inicializarArbol();
			nuevo.der = new ABB();
			nuevo.der.inicializarArbol();
			primer = nuevo;
		} else if (primer.dato.compareTo(x) > 0)
			hijoIzq().agregar(x);
		else
			hijoDer().agregar(x);
	}

	@Override
	public void eliminar(String x) {
		if (!arbolVacio()) {
			if (primer.dato.compareTo(x) > 0) {
				hijoIzq().eliminar(x);
			} 
			else if (primer.dato.compareTo(x) < 0) {
				hijoDer().eliminar(x);
			}
		}
	}

	@Override
	public boolean arbolVacio() {
		return primer == null;
	}
}


