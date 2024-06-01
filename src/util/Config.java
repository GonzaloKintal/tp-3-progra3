package util;

import java.awt.Color;

public class Config {
	public static int WIDTH_BOTON = 230;
	public static int HEIGHT_BOTON = 30;
	public static int HEIGHT_FRAME = 650;
	public static int WIDTH_FRAME = 300;
	public static int WIDTH_PANEL_INTERACTIVO = 300;
	public static Color COLOR_PANEL = new Color(200, 241, 254);
	public static Color COLOR_BOTON = new Color(23, 90, 115);
	public static Color COLOR_BOTON_SALIR = new Color(179, 0, 0);
	public static Color COLOR_BOTON_REINICIAR = new Color(150, 226, 246);
	public static String[] CLASES_CSS = { "primera", "segunda", "tercera", "cuarta", "quinta" };
	public static String ESTILOS_GRAPHSTREAM = """
			graph {
				fill-color: rgb(200, 241, 254);
				padding: 80px;
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
			}

			node.primera {
				fill-color: #5ce56c;
				stroke-color: #5ce56c;
			}

			node.segunda {
				fill-color: #f485f0;
				stroke-color: #f485f0;
			}
			
			node.tercera {
				fill-color: red;
				stroke-color: red;
			}
			
			node.cuarta {
				fill-color: yellow;
				stroke-color: yellow;
			}
			
			node.quinta {
				fill-color: orange;
				stroke-color: orange;
			}

			edge{
				fill-color: rgb(66, 186, 206);
				size: 2px;
			}

			edge.clique{
				fill-color: #5ce56c;
				size: 4px;
			}

			edge.primera{
				fill-color: #5ce56c;
			}

			edge.segunda{
				fill-color: #f485f0;
			}
			
			edge.tercera{
				fill-color: red;
			}
			
			edge.cuarta{
				fill-color: yellow;
			}
			
			edge.quinta{
				fill-color: orange;
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
