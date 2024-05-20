package logica;

import java.util.HashSet;
import java.util.Set;

public class Vertice {
	
	Set<Integer> _vecinos;
	int _peso;

	
	public Vertice(int peso) {
		verificarPeso(peso);
		_vecinos = new HashSet<Integer>();
		_peso = peso;
	}
	
	
	private void verificarPeso(int peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("El peso del vértice debe ser positivo.");
		}
	}


	public int getPeso() {
		return _peso;
	}
	
	
	public void actualizarPeso(int peso) {
		verificarPeso(peso);
		_peso = peso;
	}
	
	
	public Set<Integer> obtenerVecinos() {
		return clonar(_vecinos);
	}


	private Set<Integer> clonar(Set<Integer> vecinos) {
		HashSet<Integer> ret = new HashSet<>();
		
		for (Integer n: vecinos) {
			ret.add(n);
		}
		return ret;
	}
	
	
	public void agregarVecino(int indiceVertice) {
		_vecinos.add(indiceVertice);
	}
	
	
	public boolean vecinoDe(int indiceVertice) {
		return _vecinos.contains(indiceVertice);
	}
	
}
