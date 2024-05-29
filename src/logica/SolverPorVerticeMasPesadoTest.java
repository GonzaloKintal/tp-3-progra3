package logica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grafo.Grafo;

public class SolverPorVerticeMasPesadoTest {

	@Test
	public void SolverPorVerticeMasPesadoTest_grafo1() {
		Grafo grafo = new InstanciasGrafo().grafo_1();
		
		Solucion solucion = new Solver(grafo, Comparadores.porVerticeMasPesado).resolver();
		
		assertEquals(107, solucion.peso());
		assertEquals(2, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorVerticeMasPesadoTest_grafo2() {
		Grafo grafo = new InstanciasGrafo().grafo_2();
		
		Solucion solucion = new Solver(grafo, Comparadores.porVerticeMasPesado).resolver();
		
		assertEquals(100, solucion.peso());
		assertEquals(2, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorVerticeMasPesadoTest_grafo3() {
		Grafo grafo = new InstanciasGrafo().grafo_3();
		
		Solucion solucion = new Solver(grafo, Comparadores.porVerticeMasPesado).resolver();
		
		assertEquals(60, solucion.peso());
		assertEquals(1, solucion.cantidadVertices());
	}
	
}
