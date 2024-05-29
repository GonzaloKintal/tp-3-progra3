package logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import grafo.Grafo;

public class Aplicacion {

	public static Solucion calcularClique(Grafo grafo) {
		Set<Solucion> _soluciones = new HashSet<>();
		
		resolverHeurísticas(grafo, _soluciones);
		
		return _soluciones.stream().max(Comparator.comparingInt(Solucion::peso)).get();
	}


	public static ArrayList<Solucion> calcularVariasCliques(Grafo grafo) {
		Set<Solucion> _soluciones = new HashSet<>();

		resolverHeurísticas(grafo, _soluciones);
		
		List<Solucion> solucionesOrdeanadasPorPeso = _soluciones.stream().sorted((o1, o2) -> -o1.peso() + o2.peso())
				.collect(Collectors.toList());

		return new ArrayList<>(solucionesOrdeanadasPorPeso);
	}

	private static void resolverHeurísticas(Grafo grafo, Set<Solucion> _soluciones) {
		_soluciones.add(new Solver(grafo, Comparadores.porVerticeMasPesado).resolver());
		_soluciones.add(new Solver(grafo, Comparadores.porPesoDelVecindario).resolver());
		_soluciones.add(new Solver(grafo, Comparadores.porCantidadDeVecinos).resolver());
		_soluciones.add(new Solver(grafo, Comparadores.porPromedioVecindario).resolver());
		_soluciones.add(new Solver(grafo, Comparadores.porSumaPromedioVecindarioVecinos).resolver());
	}
	
}
