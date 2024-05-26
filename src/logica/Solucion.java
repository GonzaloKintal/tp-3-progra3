package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solucion {

	private Set<Vertice> _vertices;
	private int _peso;
	private long _tiempoEjecucion;

	public Solucion() {
		this._vertices = new HashSet<>();
		this._peso = 0;
		this._tiempoEjecucion = 0;
	}

	public void agregar(Vertice vertice) {
		_vertices.add(vertice);
		_peso += vertice.getPeso();
	}

	public int peso() {
		return _peso;
	}

	public void setTiempoEjecucion(long tiempoEjecucion) {
		this._tiempoEjecucion = tiempoEjecucion;
	}

	public long getTiempoEjecucion() {
		return _tiempoEjecucion;
	}

	public int cantidadVertices() {
		return _vertices.size();
	}

	public Set<Vertice> obtener() {
		return _vertices;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Clique máxima:");
		ret.append("\n");
		ret.append("Peso: ");
		ret.append(_peso);
		ret.append("\n");
		for (Vertice v : _vertices) {
			ret.append("Vertice: ");
			ret.append(v.getID());
			ret.append(" - ");
			ret.append(" Peso: ");
			ret.append(v.getPeso());
			ret.append("\n");
			ret.append("\n");
		}
		ret.append("Tiempo de ejecución: ");
		ret.append(_tiempoEjecucion);
		ret.append("ms");
		ret.append("\n");
		return ret.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(_peso, _vertices);
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

		boolean mismosVertices = _vertices.equals(other._vertices);

		return _peso == other._peso && mismosVertices;
	}

	public static String obtenerInfo(ArrayList<Solucion> soluciones) {
		StringBuilder ret= new StringBuilder();
		int opcion=1;
		for(Solucion solucion:soluciones) {
			ret.append("Opcion ");
			ret.append(opcion++);
			ret.append("\n");
			ret.append(solucion.toString());
			ret.append("\n\n\n");
		}
		return ret.toString();
	}

}

