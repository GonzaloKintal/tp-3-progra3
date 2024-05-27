package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;

import logica.Grafo;
import logica.Solucion;

public class PanelEstadisticas extends JList<String> implements Observador {

	private static final long serialVersionUID = 1L;
	
	public PanelEstadisticas() {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setBounds(0, 0, 200, 200);
		setFont(new Font("Roboto", Font.BOLD, 14));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(Object dato) {
		String[] informacion = {};
		
		if(dato.getClass() == ArrayList.class) {
			String info = Solucion.obtenerInfo((ArrayList<Solucion>) dato);
			informacion = info.split("\n");
			
		}else if(dato.getClass() == Solucion.class){
			Solucion solucion =  (Solucion) dato;
			informacion = (solucion.toString()).split("\n");
			
		}else if(dato.getClass() == Grafo.class){
			informacion = ((String) dato.toString()).split("\n");
		}
		
		setListData(informacion);
	}
}
