package util;

import java.awt.Color;

public class Config {
	public static Color COLOR_PANEL = new Color(200, 241, 254);
	public static Color COLOR_BOTON = new Color(23, 90, 115);
	public static Color COLOR_BOTON_SALIR = new Color(179, 0, 0);
	
	public static String ESTILOS_GRAPHSTREAM = """
			graph {
				fill-color: rgb(200, 241, 254);
			}
			
			node{
				text-color: #111;
				text-size: 14px;
				text-style: bold;
				size: 50px, 50px;
				fill-color: rgb(106, 226, 246);
				text-mode: normal;
			}
			""";
}
