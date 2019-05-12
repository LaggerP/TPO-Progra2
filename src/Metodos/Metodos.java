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
	// NO COMPARA ESTACIONES, intentado pero fallido -------ver



	@SuppressWarnings("null")
	public void listaEstacionesIgualNombre(DiccionarioMultipleStringTDA DM) {
		ConjuntoStringTDA clavesLineas = null;
		ConjuntoStringTDA clavesLineas2 = null;
		ConjuntoStringTDA valoresEstaciones = null;
		ConjuntoStringTDA valoresEstacionesComp = null;

		DiccionarioMultipleStringTDA estacionesCoincidentesDM = new DiccionarioMultipleString();
		estacionesCoincidentesDM.inicializarDiccionario();

		String claveTemp = null;
		String claveComparacion = null;
		String estacionTemp = null;
		
		clavesLineas = DM.claves();
					
		String valor;
		int cant = 0;
		while (!clavesLineas.ConjuntoVacio()) {
			valor = clavesLineas.Elegir();
			clavesLineas.Sacar(valor);
			cant++;
		}
		
		clavesLineas = DM.claves();	
		clavesLineas2 = DM.claves();

		while (cant!=0) {
			
			System.out.println("LINEAS RESTANTES: " + cant);
			System.out.println("ANTERIOR: "+claveTemp);
			claveTemp = clavesLineas.Elegir(); // subte A
			
			System.out.println("ACTUAL: " + claveTemp);
			clavesLineas.Sacar(claveTemp); // saco subte A del conjunto
			while (!clavesLineas.ConjuntoVacio()) {
				
				claveComparacion = clavesLineas.Elegir(); // tren mitre
				valoresEstaciones = DM.recuperar(claveTemp); // retiro moreno diagonal
				valoresEstacionesComp = DM.recuperar(claveComparacion); // retiro belgrano martinez
				while (!valoresEstacionesComp.ConjuntoVacio()) {
					estacionTemp = valoresEstacionesComp.Elegir(); // retiro
					if (valoresEstaciones.Pertenece(estacionTemp)) { // si
						String lineaCoincidente = claveTemp + " con " + claveComparacion;
						estacionesCoincidentesDM.agregar(lineaCoincidente, estacionTemp);
					}
					valoresEstacionesComp.Sacar(estacionTemp); // saco retiro y pruebo con moreno...
				}
				clavesLineas.Sacar(claveComparacion); // Se va el tren mitre		
			}	
			mostrarDiccionarioMultiple(estacionesCoincidentesDM);
			
			clavesLineas2.Sacar(claveTemp); 			
			clavesLineas=clavesLineas2;		// ????????????????????
			
			cant--;
			System.out.println("----------------------------------------------------------");
		}
	}

	private void mostrarDiccionarioMultiple(DiccionarioMultipleStringTDA DM) {
		ConjuntoStringTDA clavesLineas = DM.claves();
		while (!clavesLineas.ConjuntoVacio()) {
			String clave = clavesLineas.Elegir();
			clavesLineas.Sacar(clave);
			ConjuntoStringTDA estaciones = DM.recuperar(clave);
			while(!estaciones.ConjuntoVacio()) {
				String estacion = estaciones.Elegir();
				System.out.println("Lineas que coinciden: " + clave + "[]");
				System.out.println("Nombre de estacion: " + estacion);
				estaciones.Sacar(estacion);
			}
		}
	}

	
	static int cardinalidadConjunto(ConjuntoStringTDA clavesLineas) {
		int cant = 0;
		String valor;
		while (!clavesLineas.ConjuntoVacio()) {
			valor = clavesLineas.Elegir();
			clavesLineas.Sacar(valor);
			cant++;
		}
		return cant;
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
