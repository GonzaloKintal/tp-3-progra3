package logica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AplicacionTest {

	@Test
	public void dameCliqueTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(32);
		grafo.agregarVertice(1);
		grafo.agregarVertice(12);
		grafo.agregarVertice(7);
		grafo.agregarVertice(34);
		grafo.agregarVertice(45);
		grafo.agregarVertice(50);
		grafo.agregarVertice(100);
		
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);
		
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		
		grafo.agregarArista(4, 3);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(4, 6);
		
		grafo.agregarArista(5, 6);
		grafo.agregarArista(5, 7);
		grafo.agregarArista(5, 8);
		grafo.agregarArista(5, 9);
		
		
		grafo.agregarArista(6, 7);
		grafo.agregarArista(6, 8);
		
		grafo.agregarArista(7, 8);

		
		assertEquals(136, new Aplicacion(grafo).dameClique().peso());
		assertEquals(4, new Aplicacion(grafo).dameClique().cantidadVertices());
	}

}
