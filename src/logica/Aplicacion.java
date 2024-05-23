package logica;

import java.util.ArrayList;
import java.util.Comparator;

public class Aplicacion {

	public static Solucion calcularClique(Grafo grafo) {
		ArrayList<Solucion> _soluciones = new ArrayList<>();
		_soluciones.add(solverPorVerticeMasPesado(grafo));
		_soluciones.add(solverPorPesoVecindario(grafo));
		_soluciones.add(solverPorCantidadDeVecinos(grafo));
		_soluciones.add(solverPorPromedioVecindario(grafo));
		_soluciones.add(solverPorSumaPromedioVecindarioVecinos(grafo));

		return _soluciones.stream().max(Comparator.comparingInt(Solucion::peso)).get();
	}
	
	private static Solucion solverPorVerticeMasPesado(Grafo grafo) {
		Solver solver = new Solver(grafo, Comparadores.porVerticeMasPesado);
		return solver.resolver();
	}

	private static  Solucion solverPorPesoVecindario(Grafo grafo) {
		Solver solver = new Solver(grafo, Comparadores.porPesoDelVecindario);
		return solver.resolver();
	}

	private static Solucion solverPorCantidadDeVecinos(Grafo grafo) {
		Solver solver = new Solver(grafo, Comparadores.porCantidadDeVecinos);
		return solver.resolver();
	}

	private static Solucion solverPorPromedioVecindario(Grafo grafo) {
		Solver solver = new Solver(grafo, Comparadores.porPromedioVecindario);
		return solver.resolver();
	}
	
	private static Solucion solverPorSumaPromedioVecindarioVecinos(Grafo grafo) {
		Solver solver = new Solver(grafo, Comparadores.porSumaPromedioVecindarioVecinos);
		return solver.resolver();
	}

}
