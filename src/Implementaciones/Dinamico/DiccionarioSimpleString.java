/** 
@Autores: plagger, ncheheid
@Grupo: 2
**/

package Implementaciones.Dinamico;

import Api.ConjuntoStringTDA;
import Api.DiccionarioSimpleStringTDA;

public class DiccionarioSimpleString implements DiccionarioSimpleStringTDA {

	class NodoCl {
		String clave;
		String valor;
		NodoCl sigCl;
	}

	NodoCl iniCl;

	@Override
	/**Costo: C **/
	public void InicializarDiccionario() {
		iniCl = null;
	}

	@Override
	/**Costo: Lineal **/
	public void Agregar(String c, String valor) {
		NodoCl nuevo;
		nuevo = new NodoCl();
		nuevo.clave = c;
		nuevo.valor = valor;
		NodoCl aux = iniCl;
		while (aux != null && aux.clave.compareTo(c) != 0) {
			aux = aux.sigCl;
		}
		if (aux == null) {
			nuevo.sigCl = iniCl;
			iniCl = nuevo;
		}
	}

	@Override
	/**Costo: Lineal **/
	public void Eliminar(String c) {
		if (iniCl != null) {
			if (iniCl.clave == c) {
				iniCl = iniCl.sigCl;
			} else {
				NodoCl aux = iniCl;
				while (aux.sigCl != null && aux.sigCl.clave.compareTo(c) != 0) {
					aux = aux.sigCl;
				}
				if (aux.sigCl != null) {
					aux.sigCl = aux.sigCl.sigCl;
				}
			}
		}
	}

	@Override
	/**Costo: Lineal **/
	public String Recuperar(String c) {
		NodoCl claveBuscada = iniCl;
		while (claveBuscada != null && claveBuscada.clave.compareTo(c) != 0) {
			claveBuscada = claveBuscada.sigCl;
		}
		return claveBuscada.valor;
	}

	@Override
	/**Costo: Lineal **/
	public ConjuntoStringTDA Claves() {
		ConjuntoStringTDA claves = new ConjuntoString();
		claves.InicializarConjunto();
		NodoCl actual = iniCl;
		while (actual != null) {
			claves.Agregar(iniCl.clave);
			actual = actual.sigCl;
		}
		return claves;
	}
}