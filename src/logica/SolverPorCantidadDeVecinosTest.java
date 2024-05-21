package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolverPorCantidadDeVecinosTest {

	@Test
	public void resolverPorCantidadDeVecinosTest() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(100);

		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);

		grafo.agregarArista(2, 3);

		Solucion solucion = new Solver(grafo, Comparadores.porCantidadDeVecinos).resolver();

		assertEquals(solucion.peso(), 110);
		assertEquals(solucion.cantidadVertices(), 2);
	}

	@Test
	public void resolverPorMayorCantidadDeVecinosMenorPesoTest() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(50);
		grafo.agregarVertice(5);
		grafo.agregarVertice(5);
		grafo.agregarVertice(5);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);

		grafo.agregarArista(3, 2);

		Solucion solucion = new Solver(grafo, Comparadores.porCantidadDeVecinos).resolver();

		assertEquals(solucion.peso(), 15);
		assertEquals(solucion.cantidadVertices(), 3);
	}
}
