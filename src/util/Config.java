package util;

import java.awt.Color;

public class Config {
	public static int WIDTH_BOTON = 230;
	public static int HEIGHT_BOTON = 25;
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
				size: 25px, 25px;
				fill-mode:gradient-diagonal1 ;
				fill-color: rgb(106, 226, 246), rgb(156, 255, 255);
				
				text-offset: 0px, 20px;
				
				text-background-color: rgb(86, 206, 226);
				text-background-mode: rounded-box;
				text-padding: 2px, 4px;
				
				stroke-color: rgb(86, 206, 226);
				stroke-width: 3px;
				stroke-mode: plain;
			}
			
			node:clicked {
				fill-color: rgb(66, 186, 206);
			}
			
			node.clique {
				fill-color: #5ce56c;
				stroke-color: #5ce56c;
				stroke-width: 3px;
				stroke-mode: plain;
			}
			
			edge{
				fill-color: rgb(66, 186, 206);
				size: 2px;
			}
			
			edge.clique{
				fill-color: #5ce56c;
				size: 4px;
			}
			
			sprite {
				text-color: #111;
				text-size: 14px;
				text-style: bold-italic;
				size: 0px, 0px;
				text-offset: 0px, -3px;
			}
			""";
	
}
