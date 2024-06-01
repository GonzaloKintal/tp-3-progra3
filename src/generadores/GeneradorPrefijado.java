package generadores;

public class GeneradorPrefijado implements Generador {
	int _valor;
	
	public GeneradorPrefijado(int valor) {
		_valor=valor;
	}
	@Override
	public int nextInt(int n) {
		return _valor++;
	}

	@Override
	public double nextDouble(int max) {
		return 1;
	}
	
}
