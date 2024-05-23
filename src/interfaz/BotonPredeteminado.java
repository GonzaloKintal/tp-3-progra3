package interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

import util.Config;

public class BotonPredeteminado {

	public static JButton crear(String text) {
		JButton boton = new JButton(text);
		boton.setFont(new Font("Arial", Font.BOLD, 14));
		boton.setBorder(null);
		boton.setBackground(Config.COLOR_BOTON);
		boton.setForeground(Color.WHITE);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton.setFocusPainted(false);
		return boton;
	}
}
