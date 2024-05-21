package logica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AplicacionTest {

    @Test
    public void cliqueMayorPesoGrafo1Test() {
        Grafo grafo = new InstanciasGrafo().grafo_1();
        Solucion clique = new Aplicacion(grafo).dameClique();
        
        assertEquals(136, clique.peso());
        assertEquals(4, clique.cantidadVertices());
    }
    
    @Test
    public void cliqueMayorPesoGrafo2Test() {
    	Grafo grafo = new InstanciasGrafo().grafo_2();
    	Solucion clique = new Aplicacion(grafo).dameClique();
    	
    	assertEquals(120, clique.peso());
    	assertEquals(2, clique.cantidadVertices());
    }
    
    @Test
    public void cliqueMayorPesoGrafo3Test() {
    	Grafo grafo = new InstanciasGrafo().grafo_3();
    	Solucion clique = new Aplicacion(grafo).dameClique();
    	
    	assertEquals(70, clique.peso());
    	assertEquals(3, clique.cantidadVertices());
    }

}