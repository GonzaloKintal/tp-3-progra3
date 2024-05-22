package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolverPorPesoVecindarioTest {

	@Test
	public void SolverPorPesoVecindarioTest_grafo1() {
		Grafo grafo = new InstanciasGrafo().grafo_1();
		
		Solucion solucion = new Solver(grafo, Comparadores.porPesoDelVecindario).resolver();
		
		assertEquals(136, solucion.peso());
		assertEquals(4, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorPesoVecindarioTest_grafo2() {
		Grafo grafo = new InstanciasGrafo().grafo_2();
		
		Solucion solucion = new Solver(grafo, Comparadores.porPesoDelVecindario).resolver();
		
		assertEquals(100, solucion.peso());
		assertEquals(2, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorPesoVecindarioTest_grafo3() {
		Grafo grafo = new InstanciasGrafo().grafo_3();
		
		Solucion solucion = new Solver(grafo, Comparadores.porPesoDelVecindario).resolver();
		
		assertEquals(70, solucion.peso());
		assertEquals(3, solucion.cantidadVertices());
	}
	
}
