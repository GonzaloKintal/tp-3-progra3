package logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	public static ArrayList<Solucion> calcularVariasCliques(Grafo grafo) {
		Set<Solucion> _soluciones = new HashSet<>();

		_soluciones.add(solverPorVerticeMasPesado(grafo));
		_soluciones.add(solverPorPesoVecindario(grafo));
		_soluciones.add(solverPorCantidadDeVecinos(grafo));
		_soluciones.add(solverPorPromedioVecindario(grafo));
		_soluciones.add(solverPorSumaPromedioVecindarioVecinos(grafo));

		List<Solucion> solucionesOrdeanadasPorPeso = _soluciones.stream().sorted((o1, o2) -> -o1.peso() + o2.peso())
				.collect(Collectors.toList());

		return new ArrayList<>(solucionesOrdeanadasPorPeso);
	}

	private static Solucion solverPorVerticeMasPesado(Grafo grafo) {
		Solver solver = new Solver(grafo, Comparadores.porVerticeMasPesado);
		return solver.resolver();
	}

	private static Solucion solverPorPesoVecindario(Grafo grafo) {
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
