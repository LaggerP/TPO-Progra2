/** 
@Autores: 
@Grupo: 
**/

package Implementaciones.Estatico;

import Api.PilaTDA;

public class Pila implements PilaTDA {

	private int [] v;
	private int ult;
	
	@Override
	public void InicializarPila() {
		ult = 0;
		v = new int [100];
	}

	@Override
	public void Apilar(int x) {
		v[ult] = x;
		ult++;
	}

	@Override
	public void Desapilar() {
		ult--;
	}

	@Override
	public int Tope() {
		return v[ult-1];
	}

	@Override
	public boolean PilaVacia() {
		if (ult == 0)
			return true;
		else
			return false;
	}

}
