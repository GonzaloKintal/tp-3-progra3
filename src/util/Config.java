package util;

import java.awt.Color;

public class Config {
	public static Color COLOR_PANEL = new Color(200, 241, 254);
	public static Color COLOR_BOTON = new Color(23, 90, 115);
	public static Color COLOR_BOTON_SALIR = new Color(179, 0, 0);
	
	public static String ESTILOS_GRAPHSTREAM = "graph { fill-color: rgb(200, 241, 254);}" + 
    		"node{\n" +
    		"    text-color: #111;\n" +
    		"    text-size: 14px;\n" +
    		"    text-style: bold;\n" +
            "    size: 50px, 50px;\n" +
            "    fill-color: rgb(106, 226, 246);\n" +
            "    text-mode: normal; \n" +
            "}";
}
