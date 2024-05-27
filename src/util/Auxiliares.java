package util;

public class Auxiliares {

	public static boolean esNumero(String valor) {
		return valor.matches("^-?\\d+(\\.\\d+)?$");
	}

	public static int parsearInputText(String valor) {
		if (!esNumero(valor)) {
			throw new IllegalArgumentException("El valor ingresado debe ser un numero");
		}

		return Integer.parseInt(valor);
	}
}
