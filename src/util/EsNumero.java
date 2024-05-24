package util;

public class EsNumero {

	public static boolean esNumero(String valor) {
		return valor.matches("^-?\\d+(\\.\\d+)?$");
	}

}
