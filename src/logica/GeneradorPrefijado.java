package logica;

public class GeneradorPrefijado implements Generador {

	@Override
	public int nextInt(int max) {
		return max;
	}

	@Override
	public double nextDouble(int max) {
		return 1;
	}
	
}
