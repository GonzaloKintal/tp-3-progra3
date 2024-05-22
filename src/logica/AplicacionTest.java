package logica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AplicacionTest {

	private InstanciasGrafo grafos = new InstanciasGrafo();
	
    @Test
    public void cliqueMayorPesoGrafo1Test() {
        Solucion clique = new Aplicacion(grafos.grafo_1()).calcularClique();
        
        assertEquals(136, clique.peso());
        assertEquals(4, clique.cantidadVertices());
    }
    
    @Test
    public void cliqueMayorPesoGrafo2Test() {
    	Solucion clique = new Aplicacion(grafos.grafo_2()).calcularClique();
    	
    	assertEquals(120, clique.peso());
    	assertEquals(2, clique.cantidadVertices());
    }
    
    @Test
    public void cliqueMayorPesoGrafo3Test() {
    	Solucion clique = new Aplicacion(grafos.grafo_3()).calcularClique();
    	
    	assertEquals(70, clique.peso());
    	assertEquals(3, clique.cantidadVertices());
    }

}