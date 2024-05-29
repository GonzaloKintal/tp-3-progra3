package logica;

import static org.junit.Assert.*;

import org.junit.Test;

import grafo.Grafo;

public class SolverPorPromedioVecindarioTest {

	@Test
	public void SolverPorPromedioVecindarioTest_grafo1() {
		Grafo grafo = new InstanciasGrafo().grafo_1();
		
		Solucion solucion = new Solver(grafo, Comparadores.porPromedioVecindario).resolver();
		
		assertEquals(107, solucion.peso());
		assertEquals(2, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorPromedioVecindarioTest_grafo2() {
		Grafo grafo = new InstanciasGrafo().grafo_2();
		
		Solucion solucion = new Solver(grafo, Comparadores.porPromedioVecindario).resolver();
		
		assertEquals(120, solucion.peso());
		assertEquals(2, solucion.cantidadVertices());
	}
	
	
	@Test
	public void SolverPorPromedioVecindarioTest_grafo3() {
		Grafo grafo = new InstanciasGrafo().grafo_3();
		
		Solucion solucion = new Solver(grafo, Comparadores.porPromedioVecindario).resolver();
		
		assertEquals(60, solucion.peso());
		assertEquals(1, solucion.cantidadVertices());
	}

}
