package logica;

import java.util.ArrayList;

public class Aplicacion {

	
	private Grafo _grafo;
	private ArrayList<Solucion> _soluciones;
	
	public Aplicacion(Grafo grafo) {
		_grafo = grafo;
		_soluciones = new ArrayList<>();
	}
	
	
	public Solucion dameClique() {
		_soluciones.clear();
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
		Solver solver = new Solver(_grafo, Comparadores.porVerticeMasPesado);
		return solver.resolver();
	}


	private Solucion solverPorPesoVecindario() {
		Solver solver = new Solver(_grafo, Comparadores.porPesoDelVecindario);
		return solver.resolver();
	}


	private Solucion solverPorPesoDeLaListaDeVecinos() {
		Solver solver = new Solver(_grafo, Comparadores.porPesoDeLaListaDeVecinos);
		return solver.resolver();
	}


	private Solucion solverPorCantidadDeVecinos() {
		Solver solver = new Solver(_grafo, Comparadores.porCantidadDeVecinos);
		return solver.resolver();
	}
	
	
}
