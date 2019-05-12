package Api_es;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Api.DiccionarioMultipleStringTDA;
import Clases.Info;


/**
 * @Autores: plagger, ncheheid
 * @Grupo: 2
 **/

public class Entradas {

	/**
	 * @Tarea: CargarDMArch(). Se carga los datos existentes en los archivos en un
	 *         diccionario multiple
	 * @Parámetros: Diccionario destino y Diccionario destinoPorcentajeEstaciones
	 * @Devuelve: Diccionarios multiples con información obtenida de los archivos
	 * @Precondición: Que existan los diccionarios multiples
	 * @Postcondición:
	 * @Costo:
	 **/

	public void CargarDMArch(DiccionarioMultipleStringTDA destino, DiccionarioMultipleStringTDA destinoPorcentajeEstaciones) {
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
				String linea = "";
				while ((linea = buffer.readLine()) != null) {
					String[] valorObtenido = linea.split(";", -1); 
					// metodo split separa el string cada vez que se encuentra el delimitador. En este caso ';'
					// aunque este metodo al encontrarse con string vacios los elimina. Para evitar esto,
					// se coloca el -1 como limitador 
					nuevo = new Info();
					clave = archivos[i].substring(0,archivos[i].length()-4); //retorna el nombre del archivo sin la extension .csv
					nuevo.sentido = valorObtenido[0];
					nuevo.nombre = valorObtenido[1];
					nuevo.lineaNombre = valorObtenido[2];
					nuevo.estacionTransferencia = valorObtenido[3];
					
					if (nuevo.sentido.compareTo("")!=0) {
						//si el sentido NO esta vacio se agrega al diccionario multiple.
						destino.agregar(clave, nuevo.nombre);
						if (nuevo.lineaNombre.compareTo("")!=0) {
							destinoPorcentajeEstaciones.agregar(clave, nuevo.lineaNombre); //ejercicio 2b)
						}
					}
				}
				arch.close();
			} catch (IOException e) {
				System.out.println("Excepcion leyendo archivo " + archivos[i] + ": " + e);
			}
		}
	}
}
