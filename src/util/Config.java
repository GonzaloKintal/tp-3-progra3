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
				text-style: bold-italic;
				size: 40px, 40px;
				fill-mode:gradient-diagonal1 ;
				fill-color: rgb(106, 226, 246), rgb(156, 255, 255);
				
				text-offset: 0px, 40px;
				
				text-background-color: rgb(86, 206, 226);
				text-background-mode: rounded-box;
				text-padding: 4px;
				
				stroke-color: rgb(86, 206, 226);
				stroke-width: 3px;
				stroke-mode: plain;
			}
			
			node:clicked {
				fill-color: rgb(66, 186, 206);
			}
			
			node:selected {
				fill-color: red;
			}
			
			edge{
				fill-color: rgb(66, 186, 206);
				size: 2px;
			}
			""";
}
