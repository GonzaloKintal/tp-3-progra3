package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import util.NombreBotones;
import util.NombreInputs;

public class Presenter {

	private HashMap<NombreBotones, JButton> _botones;
	private HashMap<NombreInputs, JTextField> _inputs;
	
	public Presenter(HashMap<NombreBotones, JButton> listaBotones, HashMap<NombreInputs, JTextField> inputs) {
		this._botones = listaBotones;
		this._inputs = inputs;
		
		agregarVerticeListener();
	}

	public void agregarVerticeListener() {
		_botones.get(NombreBotones.AGREGAR_VERTICE).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(_inputs.get(NombreInputs.PESO_VERTICE).getText());
			}
			
		});
		
	}
}
