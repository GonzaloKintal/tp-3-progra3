package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JList;

public class PanelEstadisticas extends JList<String> implements Observador {

	private static final long serialVersionUID = 1L;
	
	public PanelEstadisticas() {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setBounds(0, 0, 200, 200);
		setFont(new Font("Roboto", Font.BOLD, 14));
	}

	@Override
	public void actualizar(Object dato) {
		String[] infoString = ((String) dato.toString()).split("\n");
		setListData(infoString);
	}

}
