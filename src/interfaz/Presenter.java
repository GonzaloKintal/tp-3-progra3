
package interfaz;

import static logica.GeneradorGrafoRandom.agregarAristaRandom;
import static logica.GeneradorGrafoRandom.generarGrafoRandom;

import static util.EsNumero.esNumero;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
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

	private Grafo _grafo;
	private ArrayList<Observador> _observadores;

	public Presenter() {
		this._grafo = new Grafo();
		this._observadores = new ArrayList<>();
		GeneradorGrafoRandom.setGenerador(new GeneradorRandom());
	}

	public void inyectarListeners(HashMap<NombreBotones, JButton> botones, HashMap<NombreInputs, JTextField> inputs) {
		agregarVerticeListener(botones.get(NombreBotones.AGREGAR_VERTICE), inputs.get(NombreInputs.PESO_VERTICE));
		agregarAristaListener(botones.get(NombreBotones.AGREGAR_ARISTA), inputs.get(NombreInputs.VERTICE1),
				inputs.get(NombreInputs.VERTICE2));
		generarGrafoRandomListener(botones.get(NombreBotones.GENERAR_GRAFO_RANDOM));
		agregarAristaRandomListener(botones.get(NombreBotones.GENERAR_ARISTA_RANDOM));
		generarCliqueMaximaListener(botones.get(NombreBotones.DAME_CLIQUE_MAXIMA));
		generarVariasCliquesListener(botones.get(NombreBotones.GENERAR_VARIAS_CLIQUES));
		reiniciarListener(botones.get(NombreBotones.REINICIAR_GRAFO));
		botonSalirListener(botones.get(NombreBotones.SALIR));
	}

	private void agregarVerticeListener(JButton boton, JTextField input) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					_grafo.agregarVertice(parsearInputText(input.getText()));
					input.setText(null);
					notificarOberservers(_grafo);
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
			}
		});
	}

	private void agregarAristaListener(JButton boton, JTextField inputVertice1, JTextField inputVertice2) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int verticeOrigen = parsearInputText(inputVertice1.getText()) - 1;
					int verticeDestino = parsearInputText(inputVertice2.getText()) - 1;

					_grafo.agregarArista(verticeOrigen, verticeDestino);

					inputVertice1.setText(null);
					inputVertice2.setText(null);
					notificarOberservers(_grafo);
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
			}
		});
	}

	private void generarGrafoRandomListener(JButton boton) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_grafo = generarGrafoRandom(10);
				notificarOberservers(_grafo);
			}
		});
	}

	private void agregarAristaRandomListener(JButton boton) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					agregarAristaRandom(_grafo);
					notificarOberservers(_grafo);
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
			}
		});
	}

	private void generarCliqueMaximaListener(JButton boton) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Solucion solucion = Aplicacion.calcularClique(_grafo);
				notificarOberservers(solucion.obtener());
			}
		});
	}

	private void generarVariasCliquesListener(JButton boton) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Solucion> soluciones = Aplicacion.calcularVariasCliques(_grafo);
				notificarOberservers(soluciones);
			}
		});
	}

	private void reiniciarListener(JButton boton) {
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_grafo = new Grafo();
				notificarOberservers(_grafo);
			}
		});
	}

	private void botonSalirListener(JButton boton) {
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Window window : Window.getWindows()) {
					window.dispose();
				}
			}
		});
	}

	private int parsearInputText(String valor) {
		if (!esNumero(valor)) {
			throw new IllegalArgumentException("El valor ingresado debe ser un numero");
		}

		return Integer.parseInt(valor);
	}

	public void registrarObservador(Observador observador) {
		_observadores.add(observador);
	}

	private void notificarOberservers(Object dato) {
		for (Observador observador : _observadores) {
			observador.actualizar(dato);
		}
	};
}
