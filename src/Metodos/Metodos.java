/** 
	@Autores: plagger
	@Grupo: 
**/

package Metodos;

import Api.ConjuntoStringTDA;
import Api.DiccionarioMultipleStringTDA;

public class Metodos {
	/**
	 * @param DM 
	 * @Tarea: calcularCantidadEstaciones().
	 * @Parámetros: Conjunto de claves, Conjunto de valores y el Diccionario multimple de las claves con sus respectivos valores
	 * @Devuelve: Devuelve la cantidad de estaciones para cada una de las lineas
	 * @Precondición: Que existe un diccionario multiple con valores asociadas a claves
	 * @Postcondición:
	 * @Costo:
	 **/

	public void calcularCantidadEstaciones(ConjuntoStringTDA cl, ConjuntoStringTDA val, DiccionarioMultipleStringTDA DM) {
		int cantEstaciones = 0;
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
	
	public void porcentajeEstacionesTransferencia () {
		
	}
}
