package generadores;

import grafo.Grafo;

public class GeneradorGrafoRandom {

	private static Generador rd;
	
	private int _pesoMaximoPosible = 50;
	private double probabilidadArista = 0.7;

	
	public Grafo generar(int cantidadVertices) {
		if(cantidadVertices < 0) {
			throw new IllegalArgumentException("La cantidad de vertices para generar un grafo random deber ser positiva");
		}
		
		Grafo grafo = new Grafo();

		// Creacion vertices
		for (int i = 0; i < cantidadVertices; i++) {
			grafo.agregarVertice(rd.nextInt(_pesoMaximoPosible));
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
			throw new IllegalArgumentException("Asegurese de agregar vertices antes de agregar aristas random");
		}
		
		if (grafo.estaCompleto()) {
			throw new IllegalArgumentException("El grafo ya esta completo, no se pueden añadir mas aristas");
		}
		
		boolean flag = true;
		int vertice1 = 0;
		int vertice2 = 0;
		
		while (flag) {
			vertice1 = rd.nextInt(grafo.tamano());
			vertice2 = rd.nextInt(grafo.tamano());

			if (!grafo.existeArista(vertice1, vertice2) && vertice1 != vertice2) {
				flag = false;
			}
		}
		
		grafo.agregarArista(vertice1, vertice2);
	}
	
	
	public static void setGenerador(Generador generador) {
		rd = generador;
	}
	
	public void setPesoMaximo(int peso) {
		_pesoMaximoPosible = peso;
	}
}
