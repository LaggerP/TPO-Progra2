package Api_es;

import java.io.BufferedReader;
import java.io.FileReader;

import Api.DiccionarioMultipleStringTDA;
import Clases.Info;

/**
 * @Autores: plagger
 * @Grupo:
 **/

public class Entradas {

	/**
	 * @Tarea: CargarDMArch(). Se carga los datos existentes en los archivos en un
	 *         diccionario multiple
	 * @Parámetros: Diccionario destino
	 * @Devuelve:
	 * @Precondición:
	 * @Postcondición:
	 * @Costo:
	 *
	 *         Formato de los archivos: A;Perú;D;Catedral
	 * 
	 *         Campos: 1ero: sentido en que paran las formaciones (a: ambos; I: sólo
	 *         de ida; V: sólo de vuelta) 
	 *         2do: nombre de la estación 
	 *         3ro: línea de
	 *         subte/tren de transferencia 
	 *         4to: nombre de la estación de
	 *         transferencia
	 **/

	public void CargarDMArch(DiccionarioMultipleStringTDA destino) {
		String[] archivos = { "Subte A.csv", "Subte B.csv", "Subte C.csv", "Subte D.csv", "Subte E.csv", "Subte H.csv",
				"Premetro.csv", "FCGSM.csv", "FCDFS.csv", "FCGBM - R.Tigre.csv", "FCGBM - R.JLSuarez.csv",
				"FCGBM - R.Mitre.csv", "FCGU.csv" };
		for (int i = 0; i <archivos.length; i++) {
			try {
				FileReader arch = new FileReader(archivos[i]);
				BufferedReader buffer = new BufferedReader(arch);
				String clave;
				Info nuevo; // estructura de los datos a obtener

				// linea obtenida del archivo.
				String linea;
				while ((linea = buffer.readLine()) != null) {
					String[] valorObtenido = linea.split(";"); // metodo split separa el string cada vez que se encuentra el delimitador. En este caso ';'
					nuevo = new Info();
					clave = valorObtenido[1];
					nuevo.sentido = valorObtenido[0];
					nuevo.nombre = valorObtenido[1];
					nuevo.lineaNombre = valorObtenido[2];
					nuevo.estacionTransferencia = valorObtenido[3];
					destino.agregar(clave, nuevo.lineaNombre);
				}
				arch.close();
			} catch (Exception e) {
				System.out.println("Excepcion leyendo archivo " + archivos[i] + ": " + e);
			}
		}
	}
}
