package generadores;

import static org.junit.Assert.*;

import org.junit.Test;
import grafo.Grafo;
import static generadores.GeneradorGrafoRandom.agregarAristaRandom;


public class GeneradorGrafoRandomTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void generarTest() {
		GeneradorGrafoRandom generador = new GeneradorGrafoRandom();
		generador.setGenerador(new GeneradorPrefijado(0));
		
		Grafo esperado = new Grafo();
		esperado.agregarVertice(0);
		esperado.agregarVertice(1);
		esperado.agregarVertice(2);
		esperado.agregarArista(0, 1);
		esperado.agregarArista(0, 2);
		esperado.agregarArista(1, 2);
		
		Grafo random = generador.generar(3);
		
		assertGrafo(esperado,random);	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void generarAristaRandomTest() {
		GeneradorGrafoRandom generador = new GeneradorGrafoRandom();
		generador.setGenerador(new GeneradorPrefijado(0));
	
		Grafo grafo = new Grafo();
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		agregarAristaRandom(grafo);
		
		assertTrue(grafo.existeArista(0, 1));		
	}
	
	public void assertGrafo(Grafo uno, Grafo otro) {
		assertEquals(uno.getVertices(),otro.getVertices());
		assertEquals(uno.tamano(),otro.tamano());
		for(int i=0; i<uno.tamano(); i++) {	
			for(int j=i+1; j<uno.tamano(); j++) {
				assertEquals(uno.existeArista(i, j),otro.existeArista(i, j));
			}
		}	
	}
}
