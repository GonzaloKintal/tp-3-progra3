
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Grafo;
import util.NombreBotones;
import util.NombreInputs;

public class Presenter {

	private HashMap<NombreBotones, JButton> _botones;
	private HashMap<NombreInputs, JTextField> _inputs;
	private Grafo _grafo;

	public Presenter() {
		this._grafo = new Grafo();
	}

	public void agregarVerticeListener() {
		_botones.get(NombreBotones.AGREGAR_VERTICE).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int peso = Integer.parseInt(_inputs.get(NombreInputs.PESO_VERTICE).getText());
				_grafo.agregarVertice(peso);
			}

		});

	}

	public void agregarAristaListener() {
		_botones.get(NombreBotones.AGREGAR_ARISTA).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int verticeOrigen = Integer.parseInt(_inputs.get(NombreInputs.VERTICE1).getText());
				int verticeDestino = Integer.parseInt(_inputs.get(NombreInputs.VERTICE2).getText());

				if (verticeOrigen < 5 || verticeDestino < 5) {
					JOptionPane.showMessageDialog(null, "Por favor, asigne similaridad entre provincias", "ATENCIÓN",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				_grafo.agregarArista(verticeOrigen, verticeDestino);
			}

		});

	}

	public void setComponentes(HashMap<NombreBotones, JButton> listaBotones, HashMap<NombreInputs, JTextField> inputs) {
		this._botones = listaBotones;
		this._inputs = inputs;
		agregarVerticeListener();
	}
}
