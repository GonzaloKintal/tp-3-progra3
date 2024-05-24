package interfaz;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import logica.Grafo;
import logica.Vertice;
import util.Config;

public class VisualizadorGrafo {

	private Graph _vistaGrafo;

	public VisualizadorGrafo() {
		System.setProperty("org.graphstream.ui", "swing");
		_vistaGrafo = new SingleGraph("Grafo");
		asignarAtributosVisor();
		Viewer viewer = _vistaGrafo.display();
		moverVista(viewer);
		cambiarTituloVentana(viewer, "Visualizador del grafo");
		cambiarIconoVentana(viewer, "/icono.png");
	}

	private void asignarAtributosVisor() {
		_vistaGrafo.clear();
		_vistaGrafo.setAttribute("ui.layout", "springbox");
		_vistaGrafo.setAttribute("layout.quality", 4);
		_vistaGrafo.setAttribute("layout.stabilization-limit", 0.9);
		_vistaGrafo.setAttribute("layout.force", 0.5);
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
				if (_vistaGrafo.getEdge(edgeId) == null
						&& _vistaGrafo.getEdge(vecino.getID() + "-" + vertice.getID()) == null) {
					_vistaGrafo.addEdge(edgeId, String.valueOf(vertice.getID()), String.valueOf(vecino.getID()));
				}
			}
		}
	}

	public void resaltarVerticesClique(Set<Vertice> vertices) {
		// Resaltar vertice
		for (Vertice vertice : vertices) {
			Node node = _vistaGrafo.getNode(vertice.getID() - 1);
			node.setAttribute("ui.class", "clique");
		}
		
		// Resaltar Arista
		for (Vertice vertice : vertices) {
			for(Vertice vecino: vertice.getVecinos()) {
				Edge arista = _vistaGrafo.getEdge(vertice.getID() + vecino.getID());
				if(arista != null) {
					arista.setAttribute("ui.class", "clique");
				}
			}
		}
	}

	private void moverVista(Viewer viewer) {
		SwingUtilities.invokeLater(() -> {
			View view = viewer.getDefaultView();
			Window window = SwingUtilities.windowForComponent((Component) view);
			window.setLocation(new Point(390, 80));
		});
	}

	private void cambiarTituloVentana(Viewer viewer, String string) {
		SwingUtilities.invokeLater(() -> {
			View view = viewer.getDefaultView();
			JFrame frame = (JFrame) SwingUtilities.windowForComponent((Component) view);
			if (frame != null) {
				frame.setTitle(string);
			}
		});
	}

	private void cambiarIconoVentana(Viewer viewer, String iconPath) {
		SwingUtilities.invokeLater(() -> {
			View view = viewer.getDefaultView();
			JFrame frame = (JFrame) SwingUtilities.windowForComponent((Component) view);
			if (frame != null) {
				ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
				if (icon.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
					frame.setIconImage(icon.getImage());
				} else {
					System.err.println("No se pudo cargar el ícono: " + iconPath);
				}
			}
		});
	}

}