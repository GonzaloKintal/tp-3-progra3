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
		
		_soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porVerticeMasPesado));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porPesoDelVecindario));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porCantidadDeVecinos));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porPromedioVecindario));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porSumaPromedioVecindarioVecinos));
		

		return _soluciones.stream().max(Comparator.comparingInt(Solucion::peso)).get();
	}

	public static ArrayList<Solucion> calcularVariasCliques(Grafo grafo) {
		Set<Solucion> _soluciones = new HashSet<>();

		_soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porVerticeMasPesado));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porPesoDelVecindario));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porCantidadDeVecinos));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porPromedioVecindario));
        _soluciones.add(resolverYMedirTiempo(grafo, Comparadores.porSumaPromedioVecindarioVecinos));
		

		List<Solucion> solucionesOrdeanadasPorPeso = _soluciones.stream().sorted((o1, o2) -> -o1.peso() + o2.peso())
				.collect(Collectors.toList());

		return new ArrayList<>(solucionesOrdeanadasPorPeso);
	}

	private static Solucion resolverYMedirTiempo(Grafo grafo, Comparator<Vertice> comparador) {
		Solver solver = new Solver(grafo, comparador);
        long inicio = System.nanoTime();
        Solucion solucion = solver.resolver();
        long fin = System.nanoTime();
        long tiempoEjecucionMs = (fin - inicio) / 1000; // Convertir nanosegundos a milisegundos
        solucion.setTiempoEjecucion(tiempoEjecucionMs);
        return solucion;
    }
	
}
