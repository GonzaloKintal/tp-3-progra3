
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import logica.Aplicacion;
import logica.Grafo;
import logica.Vertice;
import util.Config;
import util.MensajeWarning;
import util.NombreBotones;
import util.NombreInputs;

import static util.GeneradorGrafoRandom.generarGrafoRandom;
import static util.EsNumero.esNumero;

public class Presenter{

	private HashMap<NombreBotones, JButton> _botones;
	private HashMap<NombreInputs, JTextField> _inputs;
	private Grafo _grafo;
	private Graph _vistaGrafo;

	public Presenter() {
		this._grafo = new Grafo();
		configurarVisorGrafo();
	}

	public Grafo getGrafo() {
		return _grafo;
	}

	public void agregarVerticeListener() {
		_botones.get(NombreBotones.AGREGAR_VERTICE).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					_grafo.agregarVertice(parsearInputText(NombreInputs.PESO_VERTICE));
					_inputs.get(NombreInputs.PESO_VERTICE).setText(null);
					actualizarGrafo();
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
			}
		});
	}

	public void agregarAristaListener() {
		_botones.get(NombreBotones.AGREGAR_ARISTA).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int verticeOrigen = parsearInputText(NombreInputs.VERTICE1) - 1;
					int verticeDestino = parsearInputText(NombreInputs.VERTICE2) - 1;

					_grafo.agregarArista(verticeOrigen, verticeDestino);
					
					_inputs.get(NombreInputs.VERTICE1).setText(null);
					_inputs.get(NombreInputs.VERTICE2).setText(null);
					actualizarGrafo();
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
			}
		});
	}

	public void agregarGenerarRandomListener() {
		_botones.get(NombreBotones.GENERAR_GRAFO_RANDOM).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_grafo = generarGrafoRandom(10);
			}
		});
	}
	
	public void agregarDameCliqueMaximaListener() {
		_botones.get(NombreBotones.DAME_CLIQUE_MAXIMA).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Aplicacion.calcularClique(_grafo));
			}
		});
	}

	public void setComponentes(HashMap<NombreBotones, JButton> listaBotones, HashMap<NombreInputs, JTextField> inputs) {
		this._botones = listaBotones;
		this._inputs = inputs;

		agregarVerticeListener();
		agregarAristaListener();
		agregarGenerarRandomListener();
		agregarDameCliqueMaximaListener();
		actualizarGrafo();
	}

	public int parsearInputText(NombreInputs nombre) {
		String valor = _inputs.get(nombre).getText();
		if (!esNumero(valor)) {
			throw new IllegalArgumentException("El valor ingresado debe ser un numero");
		}

		return Integer.parseInt(valor);
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
	
	private void actualizarGrafo() {
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
