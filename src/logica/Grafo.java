package logica;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice> _vertices;

	public Grafo() {
		_vertices = new ArrayList<Vertice>();
	}

	public void agregarVertice(int peso) {
		Vertice vertice = new Vertice(peso);
		vertice.setID(tamano());
		_vertices.add(vertice);
		System.out.println("Se agrego el vertice " + vertice);
	}
	
	public Vertice get(int indiceVertice) {
		verificarVertice(indiceVertice);
		return _vertices.get(indiceVertice);
	}

	public void agregarArista(int indiceVertice1, int indiceVertice2) {
		verificarVertices(indiceVertice1, indiceVertice2);

		_vertices.get(indiceVertice1).agregarVecino(_vertices.get(indiceVertice2));
		_vertices.get(indiceVertice2).agregarVecino(_vertices.get(indiceVertice1));
	}

	private void verificarVertices(int indiceVertice1, int indiceVertice2) {
		if (indiceVertice1 == indiceVertice2) {
			throw new IllegalArgumentException("Un vértice no puede estar conectado con sí mismo.");
		}
		verificarVertice(indiceVertice1);
		verificarVertice(indiceVertice2);
	}

	// HAY QUE VER SI LO VAMOS A NECESITAR
//	boolean existeVertice(int indiceVertice) {
//		return indiceVertice > 0 && indiceVertice < _vertices.size();
//	}

	private void verificarVertice(int indiceVertice) {
		if (indiceVertice < 0) {
			throw new IllegalArgumentException("El índice no puede ser negativo.");
		}

		if (indiceVertice >= tamano()) {
			throw new IllegalArgumentException("El índice está excedido.");
		}
	}

	public boolean existeArista(int indiceVertice1, int indiceVertice2) {
		return _vertices.get(indiceVertice1).tieneDeVecinoA(_vertices.get(indiceVertice2));
	}

	int tamano() {
		return _vertices.size();
	}

	public ArrayList<Vertice> getVertices() {
		return new ArrayList<>(_vertices);
	}

}
