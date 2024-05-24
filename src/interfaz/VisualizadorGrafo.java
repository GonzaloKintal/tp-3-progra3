package interfaz;

import java.util.Set;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import logica.Grafo;
import logica.Vertice;
import util.Config;

public class VisualizadorGrafo{
	
	private Grafo _grafo;
	private Graph _vistaGrafo;
	
	
	public VisualizadorGrafo(Grafo grafo) {
		_grafo = grafo;
		configurarVisorGrafo();
	}

	private void configurarVisorGrafo() {
		System.setProperty("org.graphstream.ui", "swing");
		_vistaGrafo = new SingleGraph("Grafo");
		asignarAtributosVisor();
		_vistaGrafo.display();
	}
	
	private void asignarAtributosVisor() {
		_vistaGrafo.clear();
		_vistaGrafo.setAttribute("ui.layout.force", true);
		_vistaGrafo.setAttribute("layout.force", 0.0);
		_vistaGrafo.setAttribute("ui.layout", "linlog");
		_vistaGrafo.setAttribute("layout.weight", 1);
		_vistaGrafo.setAttribute("ui.stylesheet", Config.ESTILOS_GRAPHSTREAM);
	}
	
	public void actualizar() {
		asignarAtributosVisor();

		for (Vertice vertice : _grafo.getVertices()) {
			Node node = _vistaGrafo.addNode(String.valueOf(vertice.getID()));
			node.setAttribute("ui.label", vertice.getText());
		}

		for (Vertice vertice : _grafo.getVertices()) {
			for (Vertice vecino : vertice.getVecinos()) {
				String edgeId = vertice.getID() + "-" + vecino.getID();
				if (_vistaGrafo.getEdge(edgeId) == null && _vistaGrafo.getEdge(vecino.getID() + "-" + vertice.getID()) == null) {
					_vistaGrafo.addEdge(edgeId, String.valueOf(vertice.getID()), String.valueOf(vecino.getID()));
				}
			}
		}
	}

	public void resaltarVerticesClique(Set<Vertice> vertices) {
		for (Vertice vertice : vertices) {
			Node node = _vistaGrafo.getNode(vertice.getID() - 1);
			node.setAttribute("ui.selected", true);
		}
	}
	public void reinciar(Grafo grafo) {
		this._grafo=grafo;
		actualizar();
	}

}