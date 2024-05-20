package logica;

import java.util.HashSet;
import java.util.Set;

public class Solucion {

	
	Set<Vertice> _vertices;
	
	
	public Solucion() {
		_vertices = new HashSet<Vertice>();
	}


	public void agregar(Vertice vertice) {
		_vertices.add(vertice);
	}

	
	public Set<Vertice> obtener() {
		return _vertices;
	}
	

}
