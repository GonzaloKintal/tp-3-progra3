package logica;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Test;

public class SolverPorCantidadDeVecinosTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

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

		Solver solver = porCantidadDeVecinos(grafo);

		Solucion solucion = solver.resolver();
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
		
		Solver solver = porCantidadDeVecinos(grafo);
		
		Solucion solucion = solver.resolver();
		assertEquals(solucion.peso(), 15);
		assertEquals(solucion.cantidadVertices(), 3);
	}
	
	public Solver porCantidadDeVecinos(Grafo grafo) {
		return new Solver(grafo, new Comparator<Vertice>() {

			@Override
			public int compare(Vertice uno, Vertice otro) {
				return -uno.obtenerVecinos().size() + otro.obtenerVecinos().size();
			}
		});
	}
}
