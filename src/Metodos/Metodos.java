/** 
	@Autores: plagger
	@Grupo: 
**/

package Metodos;

import Api.ColaStringTDA;
import Api.ConjuntoStringTDA;
import Api.DiccionarioMultipleStringTDA;
import Api.DiccionarioSimpleStringTDA;
import Implementaciones.Estatico.ColaString;

public class Metodos {
	
	/**
	 * @Tarea: calcularCantidadEstaciones().
	 * @Parámetros: Conjunto de claves, Conjunto de valores y el Diccionario multimple de las claves con sus respectivos valores
	 * @Devuelve: Devuelve la cantidad de estaciones para cada una de las lineas
	 * @Precondición: Que existe un diccionario multiple con valores asociadas a las claves
	 * @Postcondición:
	 * @Costo:
	 **/
	public void calcularCantidadEstaciones(ConjuntoStringTDA cl, DiccionarioMultipleStringTDA DM) {
		int cantEstaciones = 1;
		ConjuntoStringTDA val = null;
		while (!cl.ConjuntoVacio()) {
			String claveUnitaria = cl.Elegir(); //elegimos una clave al azar
			val = DM.recuperar(claveUnitaria); //recuperamos los valores asociados a clave
			System.out.println(claveUnitaria); //mostramos la clave
			while(!val.ConjuntoVacio()) {
				String valorUnitario = val.Elegir(); //elegimos un valor al azar asociado a la clave
				cantEstaciones++;
				val.Sacar(valorUnitario);
			}
			//tener en cuenta que la cantidad de estaciones que se muestran
			//son las totales dejando de lado las que se repiten.
			System.out.print(" Cantidad de estaciones: " + cantEstaciones);
			System.out.println();
			System.out.println();
			cl.Sacar(claveUnitaria);
			cantEstaciones = 0;
		}
	}
	
	/**
	 * @Tarea: porcentajeEstacionesTransferencia().
	 * @Parámetros: Conjunto de claves y el Diccionario Simple de las claves con sus respectivos valores
	 * @Devuelve: 
	 * @Precondición: Que existe un diccionario simple con valores asociadas a las claves
	 * @Postcondición:
	 * @Costo:
	 **/
	public void porcentajeEstacionesTransferencia (DiccionarioSimpleStringTDA DS, ConjuntoStringTDA cl2) {
		ColaStringTDA colaDeValores = new ColaString();
		colaDeValores.InicializarCola();
		while(!cl2.ConjuntoVacio()) {
			String claveObtenida = cl2.Elegir();
			String valorObtenido = DS.Recuperar(claveObtenida);
			colaDeValores.Acolar(valorObtenido);
			cl2.Sacar(claveObtenida);
		}
		
		while(!colaDeValores.ColaVacia()) {
			System.out.println(colaDeValores.Primero());
			colaDeValores.Desacolar();
		}
	}

}
