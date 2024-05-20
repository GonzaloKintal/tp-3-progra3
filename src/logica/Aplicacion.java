package logica;

import java.util.ArrayList;

public class Aplicacion {

	
	private Grafo _grafo;
	private ArrayList<Solucion> _soluciones;
	private Comparadores _comparadores;
	
	
	public Aplicacion(Grafo grafo) {
		_grafo = grafo;
		_soluciones = new ArrayList<>();
		_comparadores = new Comparadores();
	}
	
	
	public Solucion dameClique() {
		_soluciones.add(solverPorCantidadDeVecinos());
		_soluciones.add(solverPorPesoDeLaListaDeVecinos());
		_soluciones.add(solverPorPesoVecindario());
		_soluciones.add(solverPorVerticeMasPesado());
		
		return elegirSolucionMasOptima();
	}


	private Solucion elegirSolucionMasOptima() {
		Solucion ret = new Solucion();
		
		for (Solucion solucion: _soluciones) {
			if (solucion.peso() > ret.peso()) {
				ret = solucion;
			}
		}
		return ret;
	}


	private Solucion solverPorVerticeMasPesado() {
		Solver solver = new Solver(_grafo, _comparadores.porVerticeMasPesado);
		return solver.resolver();
	}


	private Solucion solverPorPesoVecindario() {
		Solver solver = new Solver(_grafo, _comparadores.porPesoDelVecindario);
		return solver.resolver();
	}


	private Solucion solverPorPesoDeLaListaDeVecinos() {
		Solver solver = new Solver(_grafo, _comparadores.porPesoDeLaListaDeVecinos);
		return solver.resolver();
	}


	private Solucion solverPorCantidadDeVecinos() {
		Solver solver = new Solver(_grafo, _comparadores.porCantidadDeVecinos);
		return solver.resolver();
	}
	
	
}
