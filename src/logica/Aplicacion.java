package logica;

import java.util.ArrayList;
import java.util.Comparator;

public class Aplicacion {

	private Grafo _grafo;
	private ArrayList<Solucion> _soluciones;

	public Aplicacion(Grafo grafo) {
		_grafo = grafo;
		_soluciones = new ArrayList<>();
	}

	public Solucion calcularClique() {
		_soluciones.add(solverPorVerticeMasPesado());
		_soluciones.add(solverPorPesoVecindario());
		_soluciones.add(solverPorCantidadDeVecinos());
		_soluciones.add(solverPorPromedioVecindario());
		_soluciones.add(solverPorSumaPromedioVecindarioVecinos());

		return elegirSolucionMasOptima();
	}
	
	private Solucion elegirSolucionMasOptima() {
		return _soluciones.stream().max(Comparator.comparingInt(Solucion::peso)).get();
	}

	private Solucion solverPorVerticeMasPesado() {
		Solver solver = new Solver(_grafo, Comparadores.porVerticeMasPesado);
		return solver.resolver();
	}

	private Solucion solverPorPesoVecindario() {
		Solver solver = new Solver(_grafo, Comparadores.porPesoDelVecindario);
		return solver.resolver();
	}

	private Solucion solverPorCantidadDeVecinos() {
		Solver solver = new Solver(_grafo, Comparadores.porCantidadDeVecinos);
		return solver.resolver();
	}

	private Solucion solverPorPromedioVecindario() {
		Solver solver = new Solver(_grafo, Comparadores.porPromedioVecindario);
		return solver.resolver();
	}
	
	private Solucion solverPorSumaPromedioVecindarioVecinos() {
		Solver solver = new Solver(_grafo, Comparadores.porSumaPromedioVecindarioVecinos);
		return solver.resolver();
	}

}
