package logica;

import java.util.Comparator;

public class Comparadores {
	
	
	public static Comparator<Vertice> porPesoDelVecindario = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPesoTotalVecindario() + otro.getPesoTotalVecindario();
		}
	};
	
	
	public static Comparator<Vertice> porPesoDeLaListaDeVecinos = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPesoVecinos() + otro.getPesoVecinos();
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
	
	

}
