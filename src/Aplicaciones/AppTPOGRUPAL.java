/** 
	@Autores: plagger
	@Grupo: 
**/

package Aplicaciones;

import Api.DiccionarioMultipleStringTDA;
import Api_es.Entradas;
import Implementaciones.Dinamico.DiccionarioMultipleString;

public class AppTPOGRUPAL {

	public static void main(String args[]) {
		Entradas ent = new Entradas();
		DiccionarioMultipleStringTDA DM = new DiccionarioMultipleString();
		DM.inicializarDiccionario();
		ent.CargarDMArch(DM);
	}

}
