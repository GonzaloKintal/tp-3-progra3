package logica;

import java.util.Comparator;

public class Comparadores {
	
	public static Comparator<Vertice> porPesoDelVecindario = (uno, otro) -> -uno.getPesoTotalVecindario() + otro.getPesoTotalVecindario();

	public static Comparator<Vertice> porCantidadDeVecinos = (uno, otro) -> -uno.obtenerVecinos().size() + otro.obtenerVecinos().size();

	public static Comparator<Vertice> porVerticeMasPesado = (uno, otro) -> -uno.getPeso() + otro.getPeso();

	public static Comparator<Vertice> porPromedioVecindario = (uno, otro) -> -uno.promedioVecindario() + otro.promedioVecindario();

	public static Comparator<Vertice> porSumaPromedioVecindarioVecinos = (uno, otro) -> -uno.sumaPromedioVecindarioVecinos() + otro.sumaPromedioVecindarioVecinos();

}
