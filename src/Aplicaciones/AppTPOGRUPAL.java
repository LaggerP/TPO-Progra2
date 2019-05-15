/** 
	@Autores: plagger, ncheheid
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
		DiccionarioMultipleStringTDA DM_porcentaje_estaciones = new DiccionarioMultipleString();
		DM_porcentaje_estaciones.inicializarDiccionario();
		DiccionarioMultipleStringTDA destinoEstacionesTranferencia = new DiccionarioMultipleString();
		destinoEstacionesTranferencia.inicializarDiccionario();
		entrada.CargarDMArch(DM, DM_porcentaje_estaciones, destinoEstacionesTranferencia);
		Metodos m = new Metodos();

		System.out.println("<----EJERCICIO A---->");
		// a. Cantidad de estaciones para cada una de las líneas
		ConjuntoStringTDA cl = DM.claves(); // obtenemos el conjunto de claves de un diccionario multimple
		m.calcularCantidadEstaciones(cl, DM);

		System.out.println("<----EJERCICIO B---->");

		// b. Porcentaje de estaciones que tienen estaciones de transferencia por cada
		// línea
		ConjuntoStringTDA cl2 = DM_porcentaje_estaciones.claves(); // obtenemos el conjunto de claves de un diccionario
																	// simple
		m.porcentajeEstacionesTransferencia(DM, DM_porcentaje_estaciones, cl2);

		System.out.println("<----EJERCICIO C---->");

		// c. Lista de estaciones de igual nombre, indicando a que línea de subte o tren
		// pertenece
		m.listaEstacionesIgualNombre(DM);

		// d. Lista de estaciones de transferencia en orden alfabético (nombre, línea a
		// la cual pertenece) indicando cantidad de lineas posibles se puede combinar.
		System.out.println("<----EJERCICIO D---->");
		m.ordenarListaTransferencia(DM, destinoEstacionesTranferencia);

	}
}
