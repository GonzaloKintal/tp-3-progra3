package logica;

import java.util.HashSet;
import java.util.Set;

public class Vertice {
	
	Set<Vertice> _vecinos;
	int _peso;
	int _ID;

	
	public Vertice(int peso) {
		verificarPeso(peso);
		_vecinos = new HashSet<Vertice>();
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
	
	
	public int getID() {
		return _ID;
	}
	
	public void setID(int id) {
		_ID = id;
	}
	
	
	public void actualizarPeso(int peso) {
		verificarPeso(peso);
		_peso = peso;
	}
	
	
	public Set<Vertice> obtenerVecinos() {
		return clonar(_vecinos);
	}


	private Set<Vertice> clonar(Set<Vertice> vecinos) {
		HashSet<Vertice> ret = new HashSet<>();
		
		for (Vertice v: vecinos) {
			ret.add(v);
		}
		return ret;
	}
	
	
	public void agregarVecino(Vertice vertice) {
		_vecinos.add(vertice);
	}
	
	
	public boolean vecinoDe(Vertice vertice) {
		return _vecinos.contains(vertice);
	}
	
}
