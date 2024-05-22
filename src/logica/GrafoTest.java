package logica;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GrafoTest {

	
	@Test
	public void agregarVerticeTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		
		assertEquals(grafo.tamano(), 1);
	}
	
	@Test
	public void agregarVerticesTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		
		assertEquals(grafo.tamano(), 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarVerticePesoNegativoTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(-5);
	}
	
	
	@Test
	public void agregarAristaTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		
		grafo.agregarArista(0, 1);
		
		assertTrue(grafo.existeArista(0, 1));
	}
	
	@Test
	public void agregarAristaRepetidaTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 1);
		
		assertEquals(30, grafo.get(0).getPesoTotalVecindario());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaConSíMismoTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		
		grafo.agregarArista(0, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaIndiceNegativosTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		
		grafo.agregarArista(-2, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaIndiceExcedidoTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		
		grafo.agregarArista(0, 1);
	}
	

	@Test
	public void existeAristaFalseTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		
		assertFalse(grafo.existeArista(0, 1));
	}
	
}
