package logica;

import java.util.Random;

public class GeneradorRandom implements Generador{

	private Random rd = new Random();
	
	@Override
	public int nextInt(int max) {
		return rd.nextInt(max);
	}

	@Override
	public double nextDouble(int max) {
		return rd.nextDouble(max);
	}
	
}
