package util;

import java.util.Random;

import logica.Grafo;

public class GeneradorGrafoRandom {

	private static Random rd = new Random();
	
	public static Grafo generarGrafoRandom(int cantidadVertices) {
		Grafo grafo = new Grafo();
		int PESO_MAXIMO_POSIBLE = 10; 
		double PROBABILIDAD_ARISTA = 0.7;

		// Creacion vertices
		for (int i = 0; i < cantidadVertices; i++) {
			grafo.agregarVertice(rd.nextInt(PESO_MAXIMO_POSIBLE));
		}

		// Asignacion aristas
		for (int i = 0; i < grafo.tamano(); i++) {
			for (int j = i + 1; j < grafo.tamano(); j++) {
				if (rd.nextDouble(1) > PROBABILIDAD_ARISTA) {
					grafo.agregarArista(i, j);
				}
			}
		}
		return grafo;
	}
}
