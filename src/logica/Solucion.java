package logica;

import java.util.HashSet;
import java.util.Set;

public class Solucion {

	int _peso;
	Set<Vertice> _vertices;
	
	public Solucion() {
		_vertices = new HashSet<Vertice>();
	}


	public void agregar(Vertice vertice) {
		_vertices.add(vertice);
		_peso+=vertice.getPeso();
	}

	
	public Set<Vertice> obtener() {
		return _vertices;
	}
	
	public int peso() {
		return _peso;
	}
	
	public int cantidadVertices() {
		return _vertices.size();
	}

}
