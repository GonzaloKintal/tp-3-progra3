package logica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AplicacionTest {

	private InstanciasGrafo grafos = new InstanciasGrafo();
	
    @Test
    public void cliqueMayorPesoGrafo1Test() {
        Solucion clique = new Aplicacion(grafos.grafo_1()).calcularClique();
        
        assertClique(grafos.mejorSolucionGrafo1, clique);
    }
    
    @Test
    public void cliqueMayorPesoGrafo2Test() {
    	Solucion clique = new Aplicacion(grafos.grafo_2()).calcularClique();
    	
    	assertClique(grafos.mejorSolucionGrafo2, clique);
    }
    
    @Test
    public void cliqueMayorPesoGrafo3Test() {
    	Solucion clique = new Aplicacion(grafos.grafo_3()).calcularClique();
    	
    	assertClique(grafos.mejorSolucionGrafo3, clique);
    }
    
    @Test
    public void cliqueMayorPesoGrafo4Test() {
    	Solucion clique = new Aplicacion(grafos.grafo_4()).calcularClique();
    	
    	assertClique(grafos.mejorSolucionGrafo4, clique);
    }

	private void assertClique(Solucion mejorSolucion, Solucion clique) {
		assertEquals(mejorSolucion.peso(), clique.peso());
        assertEquals(mejorSolucion.cantidadVertices(), clique.cantidadVertices());
        
        for(Vertice vertice: clique.obtener()) {
        	assertTrue(mejorSolucion.obtener().contains(vertice));
        }
	}

}