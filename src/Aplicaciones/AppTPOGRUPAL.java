/** 
	@Autores: plagger
	@Grupo: 
**/

package Aplicaciones;

import Api.ConjuntoStringTDA;
import Api.DiccionarioMultipleStringTDA;
import Api.DiccionarioSimpleStringTDA;
import Api_es.Entradas;
import Implementaciones.Dinamico.DiccionarioMultipleString;
import Implementaciones.Dinamico.DiccionarioSimpleString;
import Metodos.Metodos;

public class AppTPOGRUPAL {
	public static void main(String args[]) {
		Entradas entrada = new Entradas(); // carga de archivo
		DiccionarioMultipleStringTDA DM = new DiccionarioMultipleString();
		DM.inicializarDiccionario();
		DiccionarioSimpleStringTDA DS = new DiccionarioSimpleString();
		DS.InicializarDiccionario();
		entrada.CargarDMArch(DM,DS);
		Metodos m = new Metodos();

		// a. Cantidad de estaciones para cada una de las líneas
		ConjuntoStringTDA cl = DM.claves(); // obtenemos el conjunto de claves de un diccionario multimple
		m.calcularCantidadEstaciones(cl, DM);
		
		System.out.println("<----SIGUIENTE EJERCICIO---->");
		
		// b. Porcentaje de estaciones que tienen estaciones de transferencia por cada línea{“
		ConjuntoStringTDA cl2 = DS.Claves(); // obtenemos el conjunto de claves de un diccionario simple
		m.porcentajeEstacionesTransferencia(DS, cl2);
		
		// c. Lista de estaciones de igual nombre, indicando a que línea de subte o tren pertenece
		// d. Lista de estaciones de transferencia en orden alfabético (nombre, línea a
		// la cual pertenece) indicando cantidad de líneas posibles se puede combinar.
	}
}
