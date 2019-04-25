package Api_es;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
					clave = archivos[i].substring(0,archivos[i].length()-4); //retorna el nombre del archivo sin la extension .csv
					nuevo.sentido = valorObtenido[0];
					nuevo.nombre = valorObtenido[1];
					destino.agregar(clave, nuevo.nombre);
				}
				arch.close();
			} catch (IOException e) {
				System.out.println("Excepcion leyendo archivo " + archivos[i] + ": " + e);
			}
		}
	}
}
