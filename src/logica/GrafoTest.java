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
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaRepetidaTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 1);
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
	
	
	@Test
	public void estaCompletoTrueTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		
		assertTrue(grafo.estaCompleto());
	}
	
	@Test
	public void estaCompletoFalseTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		
		assertFalse(grafo.estaCompleto());
	}
	
	@Test
	public void estaCompletoVacioTest() {
		Grafo grafo = new Grafo();
		
		assertTrue(grafo.estaCompleto());
	}
	
	@Test
	public void estaCompletoUnVerticeTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		
		assertTrue(grafo.estaCompleto());
	}
	
	
	@Test
	public void toStringTest() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		grafo.agregarVertice(30);
		
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		
		String esperado = "Vértices:\n1 - Peso: 10\n2 - Peso: 20\n3 - Peso: 30\n\nAristas:\n(1, 2)\n(1, 3)\n(2, 3)\n";
		
		assertEquals(esperado, grafo.toString());
	}
	
}
