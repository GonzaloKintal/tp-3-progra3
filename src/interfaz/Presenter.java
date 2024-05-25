
package interfaz;

import static logica.GeneradorGrafoRandom.agregarAristaRandom;
import static logica.GeneradorGrafoRandom.generarGrafoRandom;
import static util.EsNumero.esNumero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import logica.Aplicacion;
import logica.GeneradorGrafoRandom;
import logica.GeneradorRandom;
import logica.Grafo;
import logica.Solucion;
import util.MensajeWarning;
import util.NombreBotones;
import util.NombreInputs;

public class Presenter {

	private HashMap<NombreBotones, JButton> _botones;
	private HashMap<NombreInputs, JTextField> _inputs;
	private Grafo _grafo;
	private VisualizadorGrafo _visualizadorGrafo;
	private JList<String> _info;

	public Presenter() {
		this._grafo = new Grafo();
		this._visualizadorGrafo = new VisualizadorGrafo();
		GeneradorGrafoRandom.setGenerador(new GeneradorRandom());
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
					_visualizadorGrafo.actualizar(_grafo);
					actualizarInfo();
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
					_visualizadorGrafo.actualizar(_grafo);
					actualizarInfo();
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
				_visualizadorGrafo.actualizar(_grafo);
				actualizarInfo();
			}
		});
	}

	public void agregarAristaRandomListener() {
		_botones.get(NombreBotones.GENERAR_ARISTA_RANDOM).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					agregarAristaRandom(_grafo);
					_visualizadorGrafo.actualizar(_grafo);
					actualizarInfo();
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
				
			}
		});
	}

	public void agregarDameCliqueMaximaListener() {
		_botones.get(NombreBotones.DAME_CLIQUE_MAXIMA).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Solucion solucion = Aplicacion.calcularClique(_grafo);
				_visualizadorGrafo.resaltarVerticesClique(solucion.obtener());
				actualizarInfoClique(solucion.toString());
			}
		});
	}

	public void reiniciarListener() {
		_botones.get(NombreBotones.REINICIAR_GRAFO).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_grafo = new Grafo();
				_visualizadorGrafo.actualizar(_grafo);
				actualizarInfo();
			}
		});

	}

	public String obtenerInformacionGrafo() {
		return _grafo.toString();
	}

	public void actualizarInfo() {
		String informacion = obtenerInformacionGrafo();
		String[] infoString = informacion.split("\n");
		_info.setListData(infoString);
	}

	public void actualizarInfoClique(String info) {
		String[] infoString = info.split("\n");
		_info.setListData(infoString);
	}

	public void setComponentes(HashMap<NombreBotones, JButton> listaBotones, HashMap<NombreInputs, JTextField> inputs) {
		this._botones = listaBotones;
		this._inputs = inputs;

		agregarVerticeListener();
		agregarAristaListener();
		agregarGenerarRandomListener();
		agregarDameCliqueMaximaListener();
		reiniciarListener();
		agregarAristaRandomListener();
		_visualizadorGrafo.actualizar(_grafo);
	}

	public void setearList(JList<String> info) {
		_info = info;
		actualizarInfo();
	}

	public int parsearInputText(NombreInputs nombre) {
		String valor = _inputs.get(nombre).getText();
		if (!esNumero(valor)) {
			throw new IllegalArgumentException("El valor ingresado debe ser un numero");
		}

		return Integer.parseInt(valor);
	}

	public void ver() {
		_visualizadorGrafo.ver();
	}

	public void ocultar() {
		_visualizadorGrafo.ocultar();
	}

}
