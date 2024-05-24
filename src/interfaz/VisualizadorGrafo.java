package interfaz;

import javax.swing.JFrame;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import logica.Grafo;
import logica.Vertice;
import util.Config;

@SuppressWarnings("serial")
public class VisualizadorGrafo extends JFrame {

	
//	private JFrame _frameVistaGrafo;
	private Grafo _grafo;
	private Graph _vistaGrafo;
	
	
	public VisualizadorGrafo(Grafo grafo) {
		_grafo = grafo;
		crearFrameVistaGrafo();
		configurarVisorGrafo();
	}


	private void crearFrameVistaGrafo() {
		this.setSize(600, 600);
		this.setLocation(670, 80);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
	}


	private void configurarVisorGrafo() {
		System.setProperty("org.graphstream.ui", "swing");
		_vistaGrafo = new SingleGraph("Grafo");
		asignarAtributosVisor();
//		_vistaGrafo.display();
	}
	
	public void visualizar() {
//		_vistaGrafo.display();
		this.setVisible(true);
	}
	
	public void ocultar() {
//		_vistaGrafo.close();
		this.setVisible(false);
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


}