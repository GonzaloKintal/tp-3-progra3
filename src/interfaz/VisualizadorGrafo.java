package interfaz;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.util.Set;

import javax.swing.SwingUtilities;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import logica.Grafo;
import logica.Vertice;
import util.Config;

public class VisualizadorGrafo{
	
	private Graph _vistaGrafo;
	
	public VisualizadorGrafo() {
		System.setProperty("org.graphstream.ui", "swing");
		_vistaGrafo = new SingleGraph("Grafo");
		asignarAtributosVisor();
        Viewer viewer = _vistaGrafo.display();
        moverVista(viewer);
	}

	private void moverVista(Viewer viewer) {
		SwingUtilities.invokeLater(() -> {
            View view = viewer.getDefaultView();
            Window window = SwingUtilities.windowForComponent((Component) view);
            window.setLocation(new Point(390, 80));
        });
	}
	
	private void asignarAtributosVisor() {
		_vistaGrafo.clear();
		_vistaGrafo.setAttribute("ui.layout.force", true);
		_vistaGrafo.setAttribute("layout.force", 0.5);
		_vistaGrafo.setAttribute("ui.layout", "linlog");
		_vistaGrafo.setAttribute("layout.weight", 1);
		_vistaGrafo.setAttribute("ui.stylesheet", Config.ESTILOS_GRAPHSTREAM);
	}
 
	public void actualizar(Grafo grafo) {
		asignarAtributosVisor();

		for (Vertice vertice : grafo.getVertices()) {
			Node node = _vistaGrafo.addNode(String.valueOf(vertice.getID()));
			node.setAttribute("ui.label", vertice.getText());
		}

		for (Vertice vertice : grafo.getVertices()) {
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
			node.setAttribute("ui.class", "clique");
		}
	}
}