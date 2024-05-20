package logica;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class SolverPorPesoDeLaListaDeVecinoTest {

	@Test
	public void resolverCliqueListaDeVecinoTest() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(100);
		
		grafo.agregarArista(0, 1);

		Solver solver = porPesoDeLaListaDeVecino(grafo);

		Solucion solucion = solver.resolver();
		assertEquals(solucion.peso(), 20);
		assertEquals(solucion.cantidadVertices(), 2);
	}
	
	@Test
	public void resolverCliqueListaDeVecinoVaciasTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		
		Solver solver = porPesoDeLaListaDeVecino(grafo);
		
		Solucion solucion = solver.resolver();
		
		// En caso de que todas las listas de vecinos esten vacias
		// el resolver se queda con el primer vertice
		assertEquals(solucion.peso(), 10);
		assertEquals(solucion.cantidadVertices(), 1);
	}
	
	@Test
	public void resolverCliqueListaDeVecinoMismoPesoTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(40);
		grafo.agregarVertice(40);
		grafo.agregarVertice(30);
		
		// 0
		// Peso total 50 / peso vecinos 40 / 1 vecino
		grafo.agregarArista(0, 2);
		
		// 3
		// Peso total 80 / peso vecinos 40 / 2 vecinos
		grafo.agregarArista(1, 3);
		grafo.agregarArista(4, 3);
		
		Solver solver = porPesoDeLaListaDeVecino(grafo);
		
		Solucion solucion = solver.resolver();
		
		// En caso de empate de los pesos de los vecinos, el resolver se queda
		// con la primer clique.
		assertEquals(solucion.peso(), 50);
		assertEquals(solucion.cantidadVertices(), 2);
	}

	public Solver porPesoDeLaListaDeVecino(Grafo grafo) {
		return new Solver(grafo, new Comparator<Vertice>() {

			@Override
			public int compare(Vertice uno, Vertice otro) {
				return -uno.getPesoVecinos() + otro.getPesoVecinos();
			}
		});
	}

}
