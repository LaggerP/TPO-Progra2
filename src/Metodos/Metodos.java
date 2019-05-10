/** 
	@Autores: plagger, ncheheid
	@Grupo: 2
**/

package Metodos;

import Api.ColaStringTDA;
import Api.ConjuntoStringTDA;
import Api.DiccionarioMultipleStringTDA;
import Api.DiccionarioSimpleStringTDA;
import Implementaciones.Dinamico.DiccionarioSimpleString;
import Implementaciones.Estatico.ColaString;

public class Metodos {

	/**
	 * @Tarea: calcularCantidadEstaciones().
	 * @Parámetros: Conjunto de claves, Conjunto de valores y el Diccionario
	 *              multimple de las claves con sus respectivos valores
	 * @Devuelve: Devuelve la cantidad de estaciones para cada una de las lineas
	 * @Precondición: Que existe un diccionario multiple con valores asociadas a las
	 *                claves
	 * @Postcondición:
	 * @Costo:
	 **/
	public void calcularCantidadEstaciones(ConjuntoStringTDA cl, DiccionarioMultipleStringTDA DM) {
		int cantEstaciones = 1;
		ConjuntoStringTDA val = null;
		while (!cl.ConjuntoVacio()) {
			String claveUnitaria = cl.Elegir(); // elegimos una clave al azar
			val = DM.recuperar(claveUnitaria); // recuperamos los valores asociados a clave
			System.out.println(claveUnitaria); // mostramos la clave
			while (!val.ConjuntoVacio()) {
				String valorUnitario = val.Elegir(); // elegimos un valor al azar asociado a la clave
				cantEstaciones++;
				val.Sacar(valorUnitario);
			}
			// tener en cuenta que la cantidad de estaciones que se muestran
			// son las totales dejando de lado las que se repiten.
			System.out.print(" Cantidad de estaciones: " + cantEstaciones);
			System.out.println();
			System.out.println();
			cl.Sacar(claveUnitaria);
			cantEstaciones = 0;
		}
	}

	/**
	 * @Tarea: porcentajeEstacionesTransferencia().
	 * @Parámetros: Conjunto de claves y el Diccionario Simple de las claves con sus
	 *              respectivos valores
	 * @Devuelve:
	 * @Precondición: Que existe un diccionario simple con valores asociadas a las
	 *                claves
	 * @Postcondición:
	 * @Costo:
	 **/
	public void porcentajeEstacionesTransferencia(DiccionarioSimpleStringTDA DS, ConjuntoStringTDA cl2) {
		ColaStringTDA colaDeValores = new ColaString();
		colaDeValores.InicializarCola();
		while (!cl2.ConjuntoVacio()) {
			String claveObtenida = cl2.Elegir();
			String valorObtenido = DS.Recuperar(claveObtenida);
			colaDeValores.Acolar(valorObtenido);
			cl2.Sacar(claveObtenida);
		}

		while (!colaDeValores.ColaVacia()) {
			System.out.println(colaDeValores.Primero());
			colaDeValores.Desacolar();
		}
	}

	/**
	 * @Tarea: listaEstacionesIgualNombre().
	 * @Parámetros: Diccionario Multiple
	 * @Devuelve: Un diccionario Simple con las estaciones coincidentes de las distintas lineas
	 * @Precondición: Que existe un diccionario multiple con valores asociadas a las
	 *                claves
	 * @Postcondición:
	 * @Costo:
	 **/
	public void listaEstacionesIgualNombre(DiccionarioMultipleStringTDA DM) {
		ConjuntoStringTDA clavesLineas = null;
		ConjuntoStringTDA valoresEstaciones = null;
		ConjuntoStringTDA est = null;

		DiccionarioSimpleStringTDA estacionesCoincidentesDS = new DiccionarioSimpleString();
		estacionesCoincidentesDS.InicializarDiccionario();

		String claveTemp = null;
		String lin = null;
		String x = null;

		clavesLineas = DM.claves(); // clavesLineas = lineas de subte/tren
		claveTemp = clavesLineas.Elegir();
		valoresEstaciones = DM.recuperar(claveTemp); // valoresEstaciones = estaciones de esa linea
		clavesLineas.Sacar(claveTemp); // saco la linea del conjunto de claves (EJ: saco subte A)

		while (!clavesLineas.ConjuntoVacio()) { // hasta que pase por todas las lineas
			lin = clavesLineas.Elegir(); // saco una linea
			est = DM.recuperar(lin); // guardo sus estaciones en un conjunto "est"

			while (!est.ConjuntoVacio()) { // mientras est tenga estaciones
				x = est.Elegir(); // saco una estacion al azar
				if (valoresEstaciones.Pertenece(x)) { // si pertenece al conjunto que guarde en un principio (EJ: subte A)
					String lineaCoincidente = claveTemp + " con " +  lin;
					estacionesCoincidentesDS.Agregar(lineaCoincidente, x); // guardo en un DS la linea de subte a la que pertenece y la estacion
				}
				est.Sacar(x); // saco la estacion del conjunto
			}
			clavesLineas.Sacar(lin); // elimino esa linea. una linea menos para recorrer.
		}
		mostrarDiccionarioSimple(estacionesCoincidentesDS);
	}
	
	
	private void mostrarDiccionarioSimple(DiccionarioSimpleStringTDA DS) {
		ConjuntoStringTDA clavesLineas = DS.Claves();
		while(!clavesLineas.ConjuntoVacio()) {
			String clave = clavesLineas.Elegir();
			clavesLineas.Sacar(clave);
			String estacion = DS.Recuperar(clave);
			System.out.println("Lineas que coinciden: " + clave);
			System.out.println("Nombre de estacion: " + estacion);
		}
	}

}
