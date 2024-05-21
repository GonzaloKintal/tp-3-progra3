package logica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolverPorVerticeMasPesadoTest {

	@Test
	public void resolverCliqueDelVerticesMasPesadoTest() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		grafo.agregarVertice(30);
		grafo.agregarVertice(40);

		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);

		grafo.agregarArista(2, 3);

		Solucion solucion = new Solver(grafo, Comparadores.porVerticeMasPesado).resolver();
		assertEquals(solucion.peso(), 100);
		assertEquals(solucion.cantidadVertices(), 4);
	}

	@Test
	public void resolverCliqueDelVerticesMasPesadoAisladosTest() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(10);
		grafo.agregarVertice(20);

		Solucion solucion = new Solver(grafo, Comparadores.porVerticeMasPesado).resolver();
		assertEquals(solucion.peso(), 20);
		assertEquals(solucion.cantidadVertices(), 1);
	}

	@Test
	public void resolverCliqueDelVerticesMasPesadoConexoTest(){
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(5);
		grafo.agregarVertice(32);
		grafo.agregarVertice(1);
		grafo.agregarVertice(12);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		
		
		Solucion solucion = new Solver(grafo, Comparadores.porVerticeMasPesado).resolver();
		
		assertEquals(solucion.peso(), 44);
		assertEquals(solucion.cantidadVertices(), 2);
	}

	@Test
	public void resolverConGrafoVacio() {
		Solucion solucion = new Solver(new Grafo(), Comparadores.porVerticeMasPesado).resolver();
		assertEquals(solucion.peso(), 0);
		assertEquals(solucion.cantidadVertices(), 0);
	}
	
}
