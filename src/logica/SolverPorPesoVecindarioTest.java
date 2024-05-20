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
	public void resolverVecindarioMasPesadoDeUnSoloVerticeTest() {
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
		assertEquals(100, solucion.peso());
		assertEquals(1, solucion.cantidadVertices());
	}
	
	@Test
	public void resolverVecindarioMasPesadoTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(60);
		grafo.agregarVertice(30);
		grafo.agregarVertice(30);
		grafo.agregarVertice(30);
		grafo.agregarVertice(50);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		
		grafo.agregarArista(2, 3);
		
		grafo.agregarArista(0, 4);
		
		Solver solver = porPesoVecindario(grafo);
		
		Solucion solucion = solver.resolver();
		assertEquals(150, solucion.peso());
		assertEquals(4, solucion.cantidadVertices());
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
