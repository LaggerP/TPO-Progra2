/** 
	@Autores: plagger
	@Grupo: 
**/

package Aplicaciones;

import Api.ConjuntoStringTDA;
import Api.DiccionarioMultipleStringTDA;
import Api_es.Entradas;
import Implementaciones.Dinamico.DiccionarioMultipleString;
import Metodos.Metodos;

public class AppTPOGRUPAL {
	public static void main(String args[]) {
		Entradas entrada = new Entradas(); // carga de archivo
		DiccionarioMultipleStringTDA DM = new DiccionarioMultipleString();
		DM.inicializarDiccionario();
		entrada.CargarDMArch(DM);
		ConjuntoStringTDA cl = DM.claves(); // obtenemos el conjunto de claves
		ConjuntoStringTDA val = null;

		Metodos m = new Metodos();
		// a. Cantidad de estaciones para cada una de las líneas
		m.calcularCantidadEstaciones(cl, val, DM);
		
		// b. Porcentaje de estaciones que tienen estaciones de transferencia por cada
		// línea
		// c. Lista de estaciones de igual nombre, indicando a que línea de subte o tren
		// pertenece
		// d. Lista de estaciones de transferencia en orden alfabético (nombre, línea a
		// la cual pertenece) indicando cantidad de líneas posibles se puede combinar.
	}
}
