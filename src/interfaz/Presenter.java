
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import logica.Grafo;
import util.MensajeWarning;
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
				try {
					_grafo.agregarVertice(parsearInputText(NombreInputs.PESO_VERTICE));
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
					
				} catch (Exception e2) {
					new MensajeWarning(e2);
				}
			}
		});
	}
	
	public void setComponentes(HashMap<NombreBotones, JButton> listaBotones, HashMap<NombreInputs, JTextField> inputs) {
		this._botones = listaBotones;
		this._inputs = inputs;

		agregarVerticeListener();
		agregarAristaListener();
	}
	
	public int parsearInputText(NombreInputs nombre) {
		String valor = _inputs.get(nombre).getText();
		if(!esNumero(valor)) {
			throw new IllegalArgumentException("El valor ingresado debe ser un numero");
		}
		
		return Integer.parseInt(valor);
	}
	
	private boolean esNumero(String valor) {
		return valor.matches("^-?\\d+(\\.\\d+)?$");
	}
}
