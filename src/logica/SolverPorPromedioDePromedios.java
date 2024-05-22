package logica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolverPorPromedioDePromedios {

	@Test
	public void SolverPorVerticeMasPesadoTest_grafo4() {
		Grafo grafo = new InstanciasGrafo().grafo_4();

		Solucion solucion = new Solver(grafo, Comparadores.porSumaPromedioVecindarioVecinos).resolver();

		assertEquals(25, solucion.peso());
		assertEquals(3, solucion.cantidadVertices());
	}

	@Test
	public void StressTest() {
		int[] CANTIDAD_VERTICES = { 1000, 10000, 20000, 80000 };

		for (Integer cant : CANTIDAD_VERTICES) {
			Grafo grafo = generarGrafoCompleto(cant);

			System.out.println("Grafo con " + cant + " vertices.");

			long startTime = System.nanoTime();
			new Solver(grafo, Comparadores.porSumaPromedioVecindarioVecinos).resolver();
			long endTime = System.nanoTime();

			long executionTime = (endTime - startTime) / 1000000;
			System.out.println("Execution time: " + executionTime + "ms.\n");
		}
	}

	private Grafo generarGrafoCompleto(int cantidadVertices) {
		Grafo grafo = new Grafo();

		for (int i = 0; i < cantidadVertices; i++) {
			grafo.agregarVertice(10);
		}

		for (int i = 0; i < grafo.tamano(); i++) {
			for (int j = i + 1; i < grafo.tamano(); i++) {
				if (i != j) {
					grafo.agregarArista(i, j);
				}
			}
		}
		return grafo;
	}

}
