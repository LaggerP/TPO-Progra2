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
	 * @Tarea: calcularCantidadEstaciones(). Calcula la cantidad de estaciones por
	 *         cada linea existente
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
	 * @Tarea: porcentajeEstacionesTransferencia(). Calcula el porcentaje de
	 *         estaciones de tranferencia existentes en cada linea.
	 * @Parámetros: Conjunto de claves y el Diccionario Simple de las claves con sus
	 *              respectivos valores
	 * @Devuelve: Porcentaje de estaciones de tranferencia por cada linea
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
			float cantLineasTotal = calculoTotalEstacionesPorLinea(DM, claveObtenida);
			float porcentaje = ((cant * 100) / cantLineasTotal);
			System.out.println("Porcentaje de estaciones de transferencia de la linea: " + claveObtenida + " es "
					+ porcentaje + "%");
			cl2.Sacar(claveObtenida);
			cant = 0;
		}
	}

	/**
	 * @Tarea: calculoTotalEstacionesPorLinea(). Calcula la cantidad de estaciones
	 *         por linea
	 * @Parámetros: Clave y el Diccionario Simple de las claves con sus respectivos
	 *              valores
	 * @Devuelve: La cantidad de estaciones por cada linea
	 * @Precondición: Que existe un diccionario simple con valores asociadas a las
	 *                claves
	 * @Postcondición:
	 * @Costo:
	 **/
	private int calculoTotalEstacionesPorLinea(DiccionarioMultipleStringTDA DM, String claveObtenida) {
		int cantEstaciones = 0;
		ConjuntoStringTDA val = null;
		val = DM.recuperar(claveObtenida); // recuperamos los valores asociados a clave
		while (!val.ConjuntoVacio()) {
			String valorUnitario = val.Elegir(); // elegimos un valor al azar asociado a la clave
			cantEstaciones++;
			val.Sacar(valorUnitario);
		}
		return cantEstaciones;
	}

	/**
	 * @Tarea: listaEstacionesIgualNombre(). Obtiene las distintas lineas que poseen
	 *         estaciones de igual nombre
	 * @Parametros: Diccionario Multiple
	 * @Devuelve: Un diccionario Multiple con las estaciones coincidentes de las
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

		while (!clavesAux.ConjuntoVacio()) {
			String clave = clavesLineas.Elegir(); // elegimos una clave del primer diccionario
			clavesLineas.Sacar(clave); // sacamos la clave de ese diccionario
			ConjuntoStringTDA valores = DM.recuperar(clave); // recuperamos los valores asociados a ese clave del primer
																// diccionario

			clavesLineas2.Sacar(clave); // eliminamos la clave en el segundo diccionario para no comparar con mismos
										// valores
			while (!clavesLineas2.ConjuntoVacio()) {
				String clave2 = clavesLineas2.Elegir(); // elegimos una clave del segundo diccionario
				ConjuntoStringTDA valores2 = DM.recuperar(clave2); // recuperamos el conjunto de valores asociados a la
																	// clave del segundo diccionario

				while (!valores2.ConjuntoVacio()) {
					String valor2 = valores2.Elegir(); // elegimos un valor del conjunto de valores de una clave del
														// segundo diccionario
					if (valores.Pertenece(valor2)) { // si el valor que elegimos esta en el conjunto de valores de una
														// clave del primer diccionario, lo guardamos
						String lineaCoincidente = "[Coinciden: " + clave + " con " + clave2 + "]--> ";

						estacionesCoincidentesDM.agregar(lineaCoincidente, valor2);
					}
					valores2.Sacar(valor2); // sacamos el valor del conjunto de valores del segundo diccionario
				}
				clavesLineas2.Sacar(clave2); // sacamos la clave del segundo diccionario
			}
			clavesLineas2 = DM.claves(); // volvemos completar con TODAS las claves al segundo diccionario
			clavesAux.Sacar(clave); // eliminamos la clave que usamos para comparar del conjunto de claves que
									// funciona como flag.
		}
		mostrarDiccionarioMultiple(estacionesCoincidentesDM);
	}

	/**
	 * @Tarea: mostrarDiccionarioMultiple(). Lista las distintas lineas que poseen
	 *         estaciones de igual nombre
	 * @Parametros: Diccionario Multiple
	 * @Devuelve: Valores asociados a una clave
	 * @Precondicion: Que existe un diccionario multiple con valores asociadas a las
	 *                claves
	 * @Postcondicion:
	 * @Costo:
	 **/
	private void mostrarDiccionarioMultiple(DiccionarioMultipleStringTDA DM) {
		ConjuntoStringTDA clavesLineas = DM.claves();
		while (!clavesLineas.ConjuntoVacio()) {
			String clave = clavesLineas.Elegir();
			clavesLineas.Sacar(clave);
			ConjuntoStringTDA estaciones = DM.recuperar(clave);
			while (!estaciones.ConjuntoVacio()) {
				String estacion = estaciones.Elegir();
				System.out.println(clave + " Nombre de estacion: " + estacion);
				System.out.println();
				estaciones.Sacar(estacion);
			}
		}
	}

	/**
	 * @Tarea: ordenarListaTransferencia().
	 * @Parametros:DiccionarioMultipleStringTDA DM, DiccionarioSimpleStringTDA DS
	 * @Devuelve: Diccionario Multiple con estaciones de transferencia en orden
	 *            alfabetico
	 * @Precondicion: Que existan diccionarios multiples con valores asociados a la
	 *                clave
	 * @Postcondicion:
	 * @Costo:
	 **/

	public void ordenarListaTransferencia(DiccionarioMultipleStringTDA DM,
			DiccionarioMultipleStringTDA DM_estacionesT) {
		ConjuntoStringTDA clavesAux = DM.claves();
		ConjuntoStringTDA clavesLineasEstaciones = DM.claves();
		ConjuntoStringTDA clavesLineasTransferencia = DM_estacionesT.claves();

		DiccionarioMultipleStringTDA estacionesTransferenciaDM = new DiccionarioMultipleString();
		estacionesTransferenciaDM.inicializarDiccionario();

		while (!clavesAux.ConjuntoVacio()) {
			String clave = clavesLineasEstaciones.Elegir(); // elegimos una clave del primer diccionario
			clavesLineasEstaciones.Sacar(clave); // sacamos la clave de ese diccionario
			ConjuntoStringTDA valores = DM.recuperar(clave); // recuperamos los valores asociados a ese clave del primer
																// diccionario

			clavesLineasTransferencia.Sacar(clave); // eliminamos la clave en el segundo diccionario para no comparar
													// con mismos valores
			while (!clavesLineasTransferencia.ConjuntoVacio()) {
				String clave2 = clavesLineasTransferencia.Elegir(); // elegimos una clave del segundo diccionario
				ConjuntoStringTDA valores2 = DM_estacionesT.recuperar(clave2); // recuperamos el conjunto de valores
																				// asociados a la clave del segundo
																				// diccionario

				while (!valores2.ConjuntoVacio()) {
					String valor2 = valores2.Elegir(); // elegimos un valor del conjunto de valores de una clave del
														// segundo diccionario
					if (valores.Pertenece(valor2)) { // si el valor que elegimos esta en el conjunto de valores de una
														// clave del primer diccionario, lo guardamos

						String est_transferencia = "[" + clave + " <-> " + clave2 + "]";
						estacionesTransferenciaDM.agregar(est_transferencia, valor2);
					}
					valores2.Sacar(valor2); // sacamos el valor del conjunto de valores del segundo diccionario
				}
				clavesLineasTransferencia.Sacar(clave2); // sacamos la clave del segundo diccionario
			}
			clavesLineasTransferencia = DM.claves(); // volvemos completar con TODAS las claves al segundo diccionario
			clavesAux.Sacar(clave); // eliminamos la clave que usamos para comparar del conjunto de claves que
									// funciona como flag.
		}
		mostrarDiccionarioMultiple(estacionesTransferenciaDM);
	}
}
