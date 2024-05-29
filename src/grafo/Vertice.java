package grafo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertice {

	Set<Vertice> _vecinos;
	int _peso;
	int _ID;
	int _pesoVecinos;

	public Vertice(int peso) {
		verificarPeso(peso);
		_vecinos = new HashSet<Vertice>();
		_peso = peso;
	}

	private void verificarPeso(int peso) {
		if (peso < 0) {
			throw new IllegalArgumentException("El peso del vértice debe ser positivo.");
		}
	}

	public Set<Vertice> getVecinos() {
		return _vecinos;
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

	private Set<Vertice> clonar(Set<Vertice> vecinos) {
		HashSet<Vertice> ret = new HashSet<>();

		for (Vertice v : vecinos) {
			ret.add(v);
		}
		return ret;
	}

	public void agregarVecino(Vertice vertice) {
		if (tieneDeVecinoA(vertice)) {
			throw new IllegalArgumentException("Arista ya existente");
		}

		if (vertice == null)
			throw new NullPointerException("El vértice no puede ser null.");

		_pesoVecinos += vertice._peso;
		_vecinos.add(vertice);
	}

	public Set<Vertice> obtenerVecinos() {
		return clonar(_vecinos);
	}

	public boolean tieneDeVecinoA(Vertice vertice) {
		return _vecinos.contains(vertice);
	}

	public int getPesoVecinos() {
		return _pesoVecinos;
	}

	public int getPesoTotalVecindario() {
		return _peso + getPesoVecinos();
	}

	public int promedioVecindario() {
		return getPesoTotalVecindario() / (_vecinos.size() + 1);
	}

	public int sumaPromedioVecindarioVecinos() {
		int aux = 0;

		for (Vertice vertice : _vecinos) {
			aux += vertice.promedioVecindario();
		}

		return aux / (_vecinos.size() + 1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		return _ID == other._ID;
	}

	// Metodo usado en el toString.
	String getIDVecinos() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		for (Vertice vertice : _vecinos) {
			sb.append(" ");
			sb.append(vertice._ID);
			sb.append(" ");
		}
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toString() {
		return "\nVertice [_peso=" + _peso + ", _ID=" + _ID + ", vecinosID= " + getIDVecinos() + ", _pesoVecinos="
				+ _pesoVecinos + "]";
	}

	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append("Peso:");
		sb.append(getPeso());

		return sb.toString();
	}

}
