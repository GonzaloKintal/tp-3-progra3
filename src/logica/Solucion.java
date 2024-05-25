package logica;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solucion {

    private Set<Vertice> vertices;
    private int peso;

    public Solucion() {
        this.vertices = new HashSet<>();
        this.peso = 0;
    }

    public void agregar(Vertice vertice) {
        vertices.add(vertice);
        peso += vertice.getPeso();
    }

    public int peso() {
        return peso;
    }

    public int cantidadVertices() {
        return vertices.size();
    }

    public Set<Vertice> obtener() {
        return vertices;
    }

	@Override
	public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Clique máxima:");
        ret.append("\n");
        ret.append("Peso: ");
        ret.append(peso);
        ret.append("\n");
        for (Vertice v : vertices) {
        	ret.append("Vertice: ");
            ret.append(v.getID());
            ret.append(" - ");
            ret.append(" Peso: ");
            ret.append(v.getPeso());
            ret.append("\n");
        }
        return ret.toString();
    }

	@Override
	public int hashCode() {
		return Objects.hash(peso, vertices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solucion other = (Solucion) obj;
		
		boolean mismosVertices = vertices.equals(other.vertices);
		
		return peso == other.peso && mismosVertices;
	}
    
    
}
