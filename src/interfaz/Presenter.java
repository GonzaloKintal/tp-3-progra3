package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

import util.NombreBotones;

public class Presenter {

	private HashMap<NombreBotones, JButton> _botones;
	
	public Presenter(HashMap<NombreBotones, JButton> listaBotones) {
		this._botones = listaBotones;
		
		agregarVerticeListener();
	}

	public void agregarVerticeListener() {
		_botones.get(NombreBotones.AGREGAR_VERTICE).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Apretando el boton para agregar vertice");
			}
			
		});
	}
}
