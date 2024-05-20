package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class VerticeTest {

	@Test (expected = IllegalArgumentException.class)
	public void verificarPesoCeroTest() {
		Vertice vertice = new Vertice(0);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void verificarPesoNegativoTest() {
		Vertice vertice = new Vertice(-5);
	}

}
