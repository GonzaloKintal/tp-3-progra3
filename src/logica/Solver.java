package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
		
		Solucion ret = new Solucion();
		
		Vertice mejorOpcion = ordenarVertices().get(0);
		ret.agregar(mejorOpcion);
		
		for (Vertice verticeVecino: ordenarVecinosPorPeso(mejorOpcion.obtenerVecinos())) {
			if (vecinoDeTodos(verticeVecino, ret.obtener())) {
				ret.agregar(verticeVecino);
			}
		}
		
		return ret;
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
