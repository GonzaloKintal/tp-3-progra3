package generadores;

import grafo.Grafo;

public class GeneradorGrafoRandom {

	private static Generador rd;
	
	private int pesoMaximoPosible = 50;
	private double probabilidadArista = 0.7;
	
	
	public static void setGenerador(Generador generador) {
		rd = generador;
	}
	
	public Grafo generarGrafoRandom(int cantidadVertices) {
		Grafo grafo = new Grafo();

		// Creacion vertices
		for (int i = 0; i < cantidadVertices; i++) {
			grafo.agregarVertice(rd.nextInt(pesoMaximoPosible));
		}

		// Asignacion aristas
		for (int i = 0; i < grafo.tamano(); i++) {
			for (int j = i + 1; j < grafo.tamano(); j++) {
				if (rd.nextDouble(1) > probabilidadArista) {
					grafo.agregarArista(i, j);
				}
			}
		}
		return grafo;
	}
	
	public static void agregarAristaRandom(Grafo grafo) {
		if(grafo.tamano() == 0) {
			throw new RuntimeException("Asegurese de agregar vertices antes de agregar aristas random");
		}
		
		if (grafo.estaCompleto()) {
			throw new RuntimeException("El grafo ya esta completo, no se pueden añadir mas aristas");
		}
		
		boolean flag = true;
		int a = 0;
		int b = 0;
		
		while (flag) {
			a = rd.nextInt(grafo.tamano());
			b = rd.nextInt(grafo.tamano());

			if (!grafo.existeArista(a, b) && a != b) {
				flag = false;
			}
		}
		
		grafo.agregarArista(a, b);
	}
}
