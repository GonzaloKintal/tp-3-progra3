package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
	
	
	private Grafo _grafo;
	private Comparator<Vertice> _comparador;
	
	
	public Solver(Grafo grafo, Comparator<Vertice> comparador) {
		_grafo = grafo;
		_comparador = comparador;
	}
	
	
	public Solucion resolver() {
		Solucion ret = new Solucion();
		
		for (Vertice vertice: ordenarVertices()) {
			// IMPLEMENTAR
		}
		
		return ret;
	}

	
	public ArrayList<Vertice> ordenarVertices() {
		ArrayList<Vertice> ret = _grafo.getVertices();
		Collections.sort(ret, _comparador);
		return ret;
	}
	
}
