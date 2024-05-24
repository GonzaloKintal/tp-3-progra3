package logica;

import java.util.Comparator;

public class Comparadores {

	public static Comparator<Vertice> porPesoDelVecindario = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPesoTotalVecindario() + otro.getPesoTotalVecindario();
		}
	};

	public static Comparator<Vertice> porCantidadDeVecinos = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.obtenerVecinos().size() + otro.obtenerVecinos().size();
		}
	};

	public static Comparator<Vertice> porVerticeMasPesado = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPeso() + otro.getPeso();
		}
	};

	public static Comparator<Vertice> porPromedioVecindario = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.promedioVecindario() + otro.promedioVecindario();
		}
	};

	public static Comparator<Vertice> porSumaPromedioVecindarioVecinos = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.sumaPromedioVecindarioVecinos() + otro.sumaPromedioVecindarioVecinos();
		}
	};

}
