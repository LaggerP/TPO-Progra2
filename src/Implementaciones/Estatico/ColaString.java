/** 
@Autores: plagger, ncheheid, afierro
@Grupo: 2
**/

package Implementaciones.Estatico;

import Api.ColaStringTDA;

public class ColaString implements ColaStringTDA {

	private String[] v;
	private int ult;

	@Override
	public void InicializarCola() {
		ult = 0;
		v = new String[100];
	}

	@Override
	public void Acolar(String x) {
		v[ult] = x;
		ult++;
	}

	@Override
	public void Desacolar() {
		for (int i = 0; i < ult - 1; i++)
			v[i] = v[i + 1];
		ult--;
	}

	@Override
	public boolean ColaVacia() {
		return ult == 0;
	}

	@Override
	public String Primero() {
		return v[0];
	}
}
