package grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class VerticeTest {

	@Test (expected = IllegalArgumentException.class)
	public void verificarPesoNegativoTest() {
		new Vertice(-5);
	}
	
	
	@Test
	public void actualizarPesoTest( ) {
		Vertice vertice = new Vertice(5);
		vertice.actualizarPeso(10);
		
		assertEquals(10, vertice.getPeso());
	}
	
	
	@Test
	public void agregarVecinoTest() {
		Vertice vertice = new Vertice(5);
		
		Vertice vecino = new Vertice(10);
		
		vertice.agregarVecino(vecino);
		
		assertTrue(vertice.tieneDeVecinoA(vecino));
	}
	
	@Test (expected = NullPointerException.class)
	public void agregarVecinoNullTest() {
		Vertice vertice = new Vertice(5);
		
		vertice.agregarVecino(null);
	}
	
	
	@Test
	public void obtenerVecinosTest() {
		Vertice vertice = new Vertice(5);
		vertice.setID(0);
		
		Vertice vecino1 = new Vertice(10);
		vecino1.setID(1);
		Vertice vecino2 = new Vertice(15);
		vecino2.setID(2);
		Vertice vecino3 = new Vertice(20);
		vecino3.setID(3);
		
		vertice.agregarVecino(vecino1);
		vertice.agregarVecino(vecino2);
		vertice.agregarVecino(vecino3);
		
		Set<Vertice> esperado = new HashSet<>();
		esperado.add(vecino1);
		esperado.add(vecino2);
		esperado.add(vecino3);
		
		assertEquals(esperado, vertice.obtenerVecinos());
	}
	
	@Test
	public void obtenerVecinosVacioTest() {
		Vertice vertice = new Vertice(5);
		
		Set<Vertice> esperado = new HashSet<>();
		
		assertEquals(esperado, vertice.obtenerVecinos());
	}
	
	
	@Test
	public void getIDVecinosTest() {
		String esperado = "{ 2  3 }";
		
		Vertice vertice = new Vertice(5);
		
		Vertice v1 = new Vertice(10);
		v1.setID(2);
		vertice.agregarVecino(v1);
		
		Vertice v2 = new Vertice(10);
		v2.setID(3);
		vertice.agregarVecino(v2);
		
		System.out.println(vertice.getIDVecinos());
		assertEquals(esperado, vertice.getIDVecinos());
	}

}
