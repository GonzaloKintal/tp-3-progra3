package generadores;

public class GeneradorPrefijado implements Generador {
	private int _valor;

	public GeneradorPrefijado(int valor) {
		_valor = valor;
	}

	@Override
	public int nextInt(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El valor debe ser positivo");
		}

		if (_valor == n) {
			_valor = 0;
		}

		return _valor++;
	}

	@Override
	public double nextDouble(int max) {
		return 1;
	}
}
