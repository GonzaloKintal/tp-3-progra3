package logica;

import java.util.ArrayList;

public class Grafo{

	private ArrayList<Vertice> _vertices;

	public Grafo() {
		_vertices = new ArrayList<Vertice>();
	}

	public void agregarVertice(int peso) {
		Vertice vertice = new Vertice(peso);
		_vertices.add(vertice);
		vertice.setID(tamano());
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

	private void verificarVertice(int indiceVertice) {
		if (indiceVertice < 0) {
			throw new IllegalArgumentException("El índice no puede ser negativo.");
		}

		if (indiceVertice >= tamano()) {
			throw new IllegalArgumentException("El índice " + indiceVertice +  " está excedido.");
		}
	}

	public boolean existeArista(int indiceVertice1, int indiceVertice2) {
		return _vertices.get(indiceVertice1).tieneDeVecinoA(_vertices.get(indiceVertice2));
	}

	public int tamano() {
		return _vertices.size();
	}

	public ArrayList<Vertice> getVertices() {
		return new ArrayList<>(_vertices);
	}

	@Override
	public String toString() {
		StringBuilder informacion = new StringBuilder();
        informacion.append("Vértices:\n");

        for (Vertice vertice : this.getVertices()) {
            informacion.append(vertice.getID()).append(" - Peso: ").append(vertice.getPeso()).append("\n");
        }
        
        informacion.append("\n\n\n\n");
        
        informacion.append("Aristas:\n");
        for (Vertice vertice : this.getVertices()) {
            for (Vertice vecino : vertice.getVecinos()) {
            	if(!informacion.toString().contains("(" + vecino.getID() + ", " + vertice.getID() + ")")) {
            		informacion.append("(").append(vertice.getID()).append(", ").append(vecino.getID()).append(")").append("\n");
            	}
            }
        }

        return informacion.toString();
	}

	public boolean estaCompleto() {
		for(Vertice vertice: _vertices) {
			if(vertice.getVecinos().size() != tamano() - 1) {
				return false;
			}
		}
		return true;
	}
	
	
}
