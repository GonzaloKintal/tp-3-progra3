package interfaz;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import grafo.Grafo;
import grafo.Vertice;
import logica.Solucion;
import util.Config;

public class VisualizadorGrafo implements Observador {

	private Graph _vistaGrafo;
	private JFrame _frame;

	public VisualizadorGrafo() {
		System.setProperty("org.graphstream.ui", "swing");
		_vistaGrafo = new SingleGraph("Grafo");
		asignarAtributosVisor();
		Viewer viewer = _vistaGrafo.display();
		moverVista(viewer);
		cambiarIconoVentana(viewer, "/icono.png");
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
		if (dato.getClass() == Grafo.class) {
			dibujarGrafo((Grafo) dato);
		} else if (dato.getClass() == Solucion.class) {
			Solucion solucion = (Solucion) dato;
			resaltarVerticesClique(solucion.obtener(), "primera");
		} else {
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
	
	private void moverVista(Viewer viewer) {
		SwingUtilities.invokeLater(() -> {
			View view = viewer.getDefaultView();
			Window window = SwingUtilities.windowForComponent((Component) view);
			if (window instanceof JFrame) {
				_frame = (JFrame) window;
				_frame.setLocation(new Point(390, 80));
				_frame.setSize(800, 650);
				_frame.setResizable(false);
				_frame.setVisible(false);
			}
		});
	}

	public void ver() {
		_frame.setVisible(true);
	}

	public void ocultar() {
		_frame.setVisible(false);
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