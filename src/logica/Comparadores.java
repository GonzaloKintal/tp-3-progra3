package logica;

import java.util.Comparator;

public class Comparadores {
	
	
	public Comparator<Vertice> porPesoDelVecindario = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPesoTotalVecindario() + otro.getPesoTotalVecindario();
		}
	};
	
	
	public Comparator<Vertice> porPesoDeLaListaDeVecinos = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPesoVecinos() + otro.getPesoVecinos();
		}
	};
	
	
	public Comparator<Vertice> porCantidadDeVecinos = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.obtenerVecinos().size() + otro.obtenerVecinos().size();
		}
	};
	
	
	public Comparator<Vertice> porVerticeMasPesado = new Comparator<Vertice>() {

		@Override
		public int compare(Vertice uno, Vertice otro) {
			return -uno.getPeso() + otro.getPeso();
		}
	};
	
	

}
