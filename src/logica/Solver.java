package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class Solver {
	
	
	private Grafo _grafo;
	private Comparator<Vertice> _comparador;
	
	
	public Solver(Grafo grafo, Comparator<Vertice> comparador) {
		_grafo = grafo;
		_comparador = comparador;
	}
	
	
	public Solucion resolver() {
		if(_grafo.tamano() == 0) {
			return new Solucion();
		}
		
		Solucion solucionOrdenandoVecinos = new Solucion();
		Solucion solucionSinOrdenarVecinos = new Solucion();
		
		Vertice mejorOpcion = ordenarVertices().get(0);
		solucionOrdenandoVecinos.agregar(mejorOpcion);
		solucionSinOrdenarVecinos.agregar(mejorOpcion);
		
		for (Vertice verticeVecino: ordenarVecinosPorPeso(mejorOpcion.obtenerVecinos())) {
			if (vecinoDeTodos(verticeVecino, solucionOrdenandoVecinos.obtener())) {
				solucionOrdenandoVecinos.agregar(verticeVecino);
			}
		}
		
		for (Vertice verticeVecino: mejorOpcion.obtenerVecinos()) {
			if (vecinoDeTodos(verticeVecino, solucionSinOrdenarVecinos.obtener())) {
				solucionSinOrdenarVecinos.agregar(verticeVecino);
			}
		}
		System.out.println(solucionOrdenandoVecinos.peso());
		System.out.println("\n");
		System.out.println(solucionSinOrdenarVecinos.peso());
		return solucionOrdenandoVecinos.peso() > solucionSinOrdenarVecinos.peso() ? solucionOrdenandoVecinos : solucionSinOrdenarVecinos;
	}

	private ArrayList<Vertice> ordenarVecinosPorPeso(Set<Vertice> vecinos){
		ArrayList<Vertice> ret = new ArrayList<>(vecinos);
		Collections.sort(ret, comparadorPorPeso());
		return ret;
	}
	
	private boolean vecinoDeTodos(Vertice vecino, Set<Vertice> clique) {
		for (Vertice vertice: clique) {
			if (!vertice.vecinoDe(vecino)) {
				return false;
			}
		}
		return true;
	}


	public ArrayList<Vertice> ordenarVertices() {
		ArrayList<Vertice> ret = _grafo.getVertices();
		Collections.sort(ret, _comparador);
		return ret;
	}
	
	public Comparator<Vertice> comparadorPorPeso(){
		return new Comparator<Vertice>() {

			@Override
			public int compare(Vertice uno, Vertice otro) {
				return -uno.getPeso() + otro.getPeso();
			}
		};
	}
	
}
