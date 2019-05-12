/** 
	@Autores: plagger, ncheheid
	@Grupo: 2
**/

package Metodos;

import Api.ConjuntoStringTDA;
import Api.DiccionarioMultipleStringTDA;
import Api.DiccionarioSimpleStringTDA;
import Implementaciones.Dinamico.DiccionarioMultipleString;
import Implementaciones.Dinamico.DiccionarioSimpleString;

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
	public void porcentajeEstacionesTransferencia(DiccionarioMultipleStringTDA DM,
			DiccionarioMultipleStringTDA porcentajEstaciones, ConjuntoStringTDA cl2) {
		DiccionarioSimpleStringTDA DSValores = new DiccionarioSimpleString();
		DSValores.InicializarDiccionario();
		int cant = 1;
		while (!cl2.ConjuntoVacio()) {
			String claveObtenida = cl2.Elegir();
			ConjuntoStringTDA valoresObtenido = porcentajEstaciones.recuperar(claveObtenida);
			while (!valoresObtenido.ConjuntoVacio()) {
				String valor = valoresObtenido.Elegir();
				cant++;
				valoresObtenido.Sacar(valor);
			}
			int cantLineasTotal = calculoTotalEstacionesPorLinea(DM, claveObtenida);
			float porcentaje = ((cant * 100) / cantLineasTotal);
			System.out.println("Porcentaje de estaciones de transferencia de la linea: " + claveObtenida + " es "
					+ porcentaje + "%");
			cl2.Sacar(claveObtenida);
			cant = 0;
		}
	}

	private int calculoTotalEstacionesPorLinea(DiccionarioMultipleStringTDA DM, String claveObtenida) {
		int cantEstaciones = 0;
		ConjuntoStringTDA val = null;
		val = DM.recuperar(claveObtenida); // recuperamos los valores asociados a clave
		System.out.println(claveObtenida); // mostramos la clave
		while (!val.ConjuntoVacio()) {
			String valorUnitario = val.Elegir(); // elegimos un valor al azar asociado a la clave
			cantEstaciones++;
			val.Sacar(valorUnitario);
		}
		return cantEstaciones;
	}

	/**
	 * @Tarea: listaEstacionesIgualNombre().
	 * @Parametros: Diccionario Multiple
	 * @Devuelve: Un diccionario Simple con las estaciones coincidentes de las
	 *            distintas lineas
	 * @Precondicion: Que existe un diccionario multiple con valores asociadas a las
	 *                claves
	 * @Postcondicion:
	 * @Costo:
	 **/

	public void listaEstacionesIgualNombre(DiccionarioMultipleStringTDA DM) {
		
		ConjuntoStringTDA clavesAux = DM.claves();
		ConjuntoStringTDA clavesLineas = DM.claves();
		ConjuntoStringTDA clavesLineas2 = DM.claves();

		DiccionarioMultipleStringTDA estacionesCoincidentesDM = new DiccionarioMultipleString();
		estacionesCoincidentesDM.inicializarDiccionario();

		while(!clavesAux.ConjuntoVacio()) {
			String clave = clavesLineas.Elegir(); //elegimos una clave del primer diccionario
			clavesLineas.Sacar(clave); //sacamos la clave de ese diccionario
			ConjuntoStringTDA valores = DM.recuperar(clave); //recuperamos los valores asociados a ese clave del primer diccionario
			
			clavesLineas2.Sacar(clave); //eliminamos la clave en el segundo diccionario para no comparar con mismos valores
			while(!clavesLineas2.ConjuntoVacio()) {
				String clave2 = clavesLineas2.Elegir(); //elegimos una clave del segundo diccionario
				ConjuntoStringTDA valores2 = DM.recuperar(clave2); //recuperamos el conjunto de valores asociados a la clave del segundo diccionario
				
				while(!valores2.ConjuntoVacio()) {
					String valor2 = valores2.Elegir(); //elegimos un valor del conjunto de valores de una clave del segundo diccionario
					if(valores.Pertenece(valor2)) { //si el valor que elegimos esta en el conjunto de valores de una clave del primer diccionario, lo guardamos
						String lineaCoincidente = clave + " con " + clave2;
						estacionesCoincidentesDM.agregar(lineaCoincidente, valor2);
					}
					valores2.Sacar(valor2); //sacamos el valor del conjunto de valores del segundo diccionario
				}
				clavesLineas2.Sacar(clave2); //sacamos la clave del segundo diccionario
			}
			clavesLineas2 = DM.claves(); //volvemos completar con TODAS las claves al segundo diccionario
			clavesAux.Sacar(clave); //eliminamos la clave que usamos para comparar del conjunto de claves que funciona como flag.
		}
		mostrarDiccionarioMultiple(estacionesCoincidentesDM);
	}

	private void mostrarDiccionarioMultiple(DiccionarioMultipleStringTDA DM) {
		ConjuntoStringTDA clavesLineas = DM.claves();
		while (!clavesLineas.ConjuntoVacio()) {
			String clave = clavesLineas.Elegir();
			clavesLineas.Sacar(clave);
			ConjuntoStringTDA estaciones = DM.recuperar(clave);
			while(!estaciones.ConjuntoVacio()) {
				String estacion = estaciones.Elegir();
				System.out.println("Coinciden: " + clave + " Nombre de estacion: " + estacion);
				System.out.println();
				estaciones.Sacar(estacion);
			}
		}
	}
	
	/**
	 * @Tarea: ordenarListaTransferencia().
	 * @Parametros:DiccionarioMultipleStringTDA DM, DiccionarioSimpleStringTDA DS
	 * @Devuelve:
	 * @Precondicion:
	 * @Postcondicion:
	 * @Costo:
	 **/

	/*
	 * d. Lista de estaciones de transferencia en orden alfab�tico (nombre, l�nea a
	 * la cual pertenece) indicando cantidad de l�neas posibles se puede combinar.
	 */

	public void ordenarListaTransferencia(DiccionarioMultipleStringTDA DM, DiccionarioSimpleStringTDA DS) {
		ConjuntoStringTDA estaciones = null;
		ConjuntoStringTDA estaciones2 = null;
		ConjuntoStringTDA linea = null;

		String a = null;
		String b = null;
		String c = null;
		estaciones = DM.claves();
		estaciones2 = DM.claves();

		while (!estaciones.ConjuntoVacio()) {
			a = estaciones.Elegir();
			linea = DM.recuperar(a);

			while (!linea.ConjuntoVacio()) {
				b = linea.Elegir();
				c = linea.Elegir();

				// COMO COMPARAR??? ------ a partir de aca, fruta:

				// if b > c
				// DS.Agregar(a, c);
				// linea.Sacar(c);
				// else if c > b
				// DS.Agregar(a, b);
				// linea.Sacar(b);

			}
		}
	}
}
