package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolverPorCantidadDeVecinosTest {

	@Test
	public void SolverPorCantidadDeVecinosTest_grafo1() {
		Grafo grafo = new InstanciasGrafo().grafo_1();
		
		Solucion solucion = new Solver(grafo, Comparadores.porCantidadDeVecinos).resolver();
		
		assertEquals(53, solucion.peso());
		assertEquals(3, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorCantidadDeVecinosTest_grafo2() {
		Grafo grafo = new InstanciasGrafo().grafo_2();
		
		Solucion solucion = new Solver(grafo, Comparadores.porCantidadDeVecinos).resolver();
		
		assertEquals(100, solucion.peso());
		assertEquals(2, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorCantidadDeVecinosTest_grafo3() {
		Grafo grafo = new InstanciasGrafo().grafo_3();
		
		Solucion solucion = new Solver(grafo, Comparadores.porCantidadDeVecinos).resolver();
		
		assertEquals(70, solucion.peso());
		assertEquals(3, solucion.cantidadVertices());
	}
	
}
