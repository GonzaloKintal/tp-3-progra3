
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import logica.Aplicacion;
import logica.Grafo;
import util.MensajeWarning;
import util.NombreBotones;
import util.NombreInputs;
import static util.GeneradorGrafoRandom.generarGrafoRandom;

public class Presenter {

	private HashMap<NombreBotones, JButton> _botones;
	private HashMap<NombreInputs, JTextField> _inputs;
	private Grafo _grafo;

	public Presenter() {
		this._grafo = new Grafo();
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
					int verticeOrigen = parsearInputText(NombreInputs.VERTICE1);
					int verticeDestino = parsearInputText(NombreInputs.VERTICE2);

					_grafo.agregarArista(verticeOrigen, verticeDestino);
					
					_inputs.get(NombreInputs.VERTICE1).setText(null);
					_inputs.get(NombreInputs.VERTICE2).setText(null);
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
	}

	public int parsearInputText(NombreInputs nombre) {
		String valor = _inputs.get(nombre).getText();
		if (!esNumero(valor)) {
			throw new IllegalArgumentException("El valor ingresado debe ser un numero");
		}

		return Integer.parseInt(valor);
	}

	private boolean esNumero(String valor) {
		return valor.matches("^-?\\d+(\\.\\d+)?$");
	}
}
