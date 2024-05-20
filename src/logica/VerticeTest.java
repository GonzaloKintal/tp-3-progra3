package logica;

import org.junit.Test;

public class VerticeTest {

	@Test (expected = IllegalArgumentException.class)
	public void verificarPesoNegativoTest() {
		new Vertice(-5);
	}

}
