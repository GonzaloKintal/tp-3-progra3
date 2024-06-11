package generadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import grafo.Grafo;

public class GeneradorGrafoRandomTest {

	private GeneradorGrafoRandom _generador;

	@Before
	public void init() {
		_generador = new GeneradorGrafoRandom();
		_generador.setPesoMaximo(10);

		GeneradorGrafoRandom.setGenerador( new GeneradorPrefijado(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void generarGrafoCantidadNegativa() {
		_generador.generar(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarAristaGrafoVacioTest() {
		GeneradorGrafoRandom.agregarAristaRandom(new Grafo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarAristaGrafoCompletoTest() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(0);
		grafo.agregarVertice(0);
		grafo.agregarVertice(0);

		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);

		grafo.agregarArista(1, 2);

		GeneradorGrafoRandom.agregarAristaRandom(grafo);
	}

	@Test
	public void generarGrafoVacioTest() {
		Grafo grafo1 = _generador.generar(0);
		Grafo grafo2 = new Grafo();

		assertEquals(grafo1.tamano(), grafo2.tamano());
	}

	@SuppressWarnings("static-access")
	@Test
	public void generarTest() {
		Grafo random = _generador.generar(3);

		Grafo esperado = new Grafo();
		esperado.agregarVertice(0);
		esperado.agregarVertice(1);
		esperado.agregarVertice(2);
		esperado.agregarArista(0, 1);
		esperado.agregarArista(0, 2);
		esperado.agregarArista(1, 2);

		assertGrafo(esperado, random);
	}

	@Test
	public void generarPesoVerticesPorGeneradorPrefijado() {
		Grafo grafo = _generador.generar(4);

		assertEquals(0, grafo.get(0).getPeso());
		assertEquals(1, grafo.get(1).getPeso());
		assertEquals(2, grafo.get(2).getPeso());
		assertEquals(3, grafo.get(3).getPeso());
	}

	@SuppressWarnings("static-access")
	@Test
	public void generarAristaRandomTest() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		_generador.agregarAristaRandom(grafo);

		assertTrue(grafo.existeArista(0, 1));
	}

	public void assertGrafo(Grafo uno, Grafo otro) {
		assertEquals(uno.getVertices(), otro.getVertices());
		assertEquals(uno.tamano(), otro.tamano());
		for (int i = 0; i < uno.tamano(); i++) {
			for (int j = i + 1; j < uno.tamano(); j++) {
				assertEquals(uno.existeArista(i, j), otro.existeArista(i, j));
			}
		}
	}
}
