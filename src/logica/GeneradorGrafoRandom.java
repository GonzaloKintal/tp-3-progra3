package logica;

public class GeneradorGrafoRandom {

	private static Generador rd;
	
	public static void setGenerador(Generador generador) {
		rd = generador;
	}
	
	public static Grafo generarGrafoRandom(int cantidadVertices) {
		Grafo grafo = new Grafo();
		int PESO_MAXIMO_POSIBLE = 50; 
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
