package logica;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Test;

public class SolverPorPesoVecindarioTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		
		grafo.agregarVertice(100);
		
		grafo.agregarArista(0, 1);

		Solver solver = porPesoVecindario(grafo);

		Solucion solucion = solver.resolver();
		assertEquals(solucion.peso(), 20);
		assertEquals(solucion.cantidadVertices(), 2);
	}
	
	public Solver porPesoVecindario(Grafo grafo) {
		return new Solver(grafo, new Comparator<Vertice>() {

			@Override
			public int compare(Vertice uno, Vertice otro) {
				return -uno.getPesoTotalVecindario() + otro.getPesoTotalVecindario();
			}
		});
	}

}
