package interfaz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;

import logica.Grafo;
import logica.Solucion;
import logica.Vertice;
import util.Config;

public class VisualizadorGrafo implements Observador {

	private Graph _vistaGrafo;

	public VisualizadorGrafo() {
		System.setProperty("org.graphstream.ui", "swing");
		_vistaGrafo = new SingleGraph("Grafo");
		asignarAtributosVisor();
	}

	private void asignarAtributosVisor() {
		_vistaGrafo.clear();
		_vistaGrafo.setAttribute("ui.layout", "springbox");
		_vistaGrafo.setAttribute("layout.quality", 4);
		_vistaGrafo.setAttribute("layout.stabilization-limit", 0.9);
		_vistaGrafo.setAttribute("layout.force", 0.1);
		_vistaGrafo.setAttribute("ui.default.title", "Visualizador del grafo");
		_vistaGrafo.setAttribute("ui.stylesheet", Config.ESTILOS_GRAPHSTREAM);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(Object dato) {
		if(dato.getClass() == Grafo.class) {
			dibujarGrafo((Grafo)dato);
		}else if (dato.getClass() == HashSet.class) {
			resaltarVerticesClique((Set<Vertice>) dato, "primera");
		}else {
			resaltarTodasLasCliques((ArrayList<Solucion>) dato);
		}
	}
	
	private void dibujarGrafo(Grafo grafo) {
		asignarAtributosVisor();
		SpriteManager spriteManager = new SpriteManager(_vistaGrafo);
		
		// Dibuja vertice con dos textos
		for (Vertice vertice : grafo.getVertices()) {
			String id = String.valueOf(vertice.getID());
			
			Node node = _vistaGrafo.addNode(id);
			node.setAttribute("ui.label", vertice.getText());
			
			Sprite aSprite = spriteManager.addSprite(id);
			aSprite.attachToNode(id);
			aSprite.setAttribute("ui.label", id);
		}
		
		// Dibuja aristas
		for (Vertice vertice : grafo.getVertices()) {
			for (Vertice vecino : vertice.getVecinos()) {
				String edgeId = vertice.getID() + "-" + vecino.getID();
				if (_vistaGrafo.getEdge(edgeId) == null
						&& _vistaGrafo.getEdge(vecino.getID() + "-" + vertice.getID()) == null) {
					_vistaGrafo.addEdge(edgeId, String.valueOf(vertice.getID()), String.valueOf(vecino.getID()));
				}
			}
		}
	}

	public void resaltarVerticesClique(Set<Vertice> vertices, String clase) {
		// Resaltar vertice
		for (Vertice vertice : vertices) {
			Node node = _vistaGrafo.getNode(vertice.getID() - 1);
			node.setAttribute("ui.class", clase);
		}

		// Resaltar Arista
		for (Vertice vertice : vertices) {
			for (Vertice vecino : vertice.getVecinos()) {
				Edge arista = obtenerArista(vertice.getID(), vecino.getID());
				if (arista != null && vertices.contains(vecino)) {
					arista.setAttribute("ui.class", clase);
				}
			}
		}
	}

	public void resaltarTodasLasCliques(ArrayList<Solucion> soluciones) {
		// Lo reccore de manera inversa asi se asegura que el ultimo
		// estilo css en aplicarse es al de la clique de mayor peso
		for (int i = soluciones.size() - 1; i >= 0; i--) {
			resaltarVerticesClique(soluciones.get(i).obtener(), Config.CLASES_CSS[i]);
		}
	}

	private Edge obtenerArista(int verticeOrigen, int verticeDestino) {
		// Arista Ejemplo: 3-5
		if (_vistaGrafo.getEdge(verticeOrigen + "-" + verticeDestino) != null) {
			return _vistaGrafo.getEdge(verticeOrigen + "-" + verticeDestino);
		}

		// Arista Ejemplo: 5-3
		if (_vistaGrafo.getEdge(verticeDestino + "-" + verticeOrigen) != null) {
			return _vistaGrafo.getEdge(verticeDestino + "-" + verticeOrigen);
		}

		return null;
	}
	
	public Graph getGrafo() {
		return this._vistaGrafo;
	}
}