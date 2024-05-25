package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotonPredeterminado extends JButton {
	
	public BotonPredeterminado(String text) {
		this.setText(text);
		propiedasPorDefecto(0, 0);
	}
	
	public BotonPredeterminado(String text, int x, int y) {
		this.setText(text);
		propiedasPorDefecto(x, y);
	}
	
	private void propiedasPorDefecto(int x, int y) {
		this.setFont(new Font("Roboto", Font.BOLD, 15));
		this.setBorder(null);
		this.setBackground(Config.COLOR_BOTON);
		this.setForeground(Color.WHITE);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFocusPainted(false);
		this.setBounds(x, y, Config.WIDTH_BOTON, Config.HEIGHT_BOTON);
	}
	
}
