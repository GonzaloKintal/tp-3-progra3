package logica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import grafo.Vertice;

public class AplicacionTest {

	private InstanciasGrafo grafos = new InstanciasGrafo();
	
    @Test
    public void cliqueMayorPesoGrafo1Test() {
        Solucion clique = Aplicacion.calcularClique(grafos.grafo_1());
        
        assertClique(grafos.mejorSolucionGrafo1, clique);
    }
    
    @Test
    public void cliqueMayorPesoGrafo2Test() {
    	Solucion clique = Aplicacion.calcularClique(grafos.grafo_2());
    	
    	assertClique(grafos.mejorSolucionGrafo2, clique);
    }
    
    @Test
    public void cliqueMayorPesoGrafo3Test() {
    	Solucion clique = Aplicacion.calcularClique(grafos.grafo_3());
    	
    	assertClique(grafos.mejorSolucionGrafo3, clique);
    }
    
    @Test
    public void cliqueMayorPesoGrafo4Test() {
    	Solucion clique = Aplicacion.calcularClique(grafos.grafo_4());
    	
    	assertClique(grafos.mejorSolucionGrafo4, clique);
    }
    
    
    @Test
    public void calcularVariasCliqueGrafo1Test() {
    	ArrayList<Solucion> esperado = new ArrayList<>();
    	
    	crearSolucionesGrafo1(esperado);
    	
    	ArrayList<Solucion> cliques = Aplicacion.calcularVariasCliques(grafos.grafo_1());
    	
    	assertCliques(esperado, cliques);
    }

	private void crearSolucionesGrafo1(ArrayList<Solucion> esperado) {
		Solucion s1 = new Solucion();
    	Vertice v6 = new Vertice(7);
    	v6.setID(6);
    	Vertice v7 = new Vertice(34);
    	v7.setID(7);
    	Vertice v8 = new Vertice(45);
    	v8.setID(8);
    	Vertice v9 = new Vertice(50);
    	v9.setID(9);
    	s1.agregar(v6);
    	s1.agregar(v7);
    	s1.agregar(v8);
    	s1.agregar(v9);
    	
    	Solucion s2 = new Solucion();
    	Vertice v10 = new Vertice(100);
    	v10.setID(10);
    	s2.agregar(v6);
    	s2.agregar(v10);
    	
    	Solucion s3 = new Solucion();
    	Vertice v5 = new Vertice(12);
    	v5.setID(5);
    	s3.agregar(v5);
    	s3.agregar(v6);
    	s3.agregar(v7);
    	
    	esperado.add(s1);
    	esperado.add(s2);
    	esperado.add(s3);
	}
    

	private void assertClique(Solucion mejorSolucion, Solucion clique) {
		assertEquals(mejorSolucion.peso(), clique.peso());
        assertEquals(mejorSolucion.cantidadVertices(), clique.cantidadVertices());
        
        for(Vertice vertice: clique.obtener()) {
        	assertTrue(mejorSolucion.obtener().contains(vertice));
        }
	}
	
	private void assertCliques(ArrayList<Solucion> esperado, ArrayList<Solucion> clique) {
		for (int i=0; i<esperado.size(); i++) {
			assertClique(esperado.get(i), clique.get(i));
		}
	}

}