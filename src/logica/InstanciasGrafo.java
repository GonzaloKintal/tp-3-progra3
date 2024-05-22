package logica;

public class InstanciasGrafo {

	public Solucion mejorSolucionGrafo1 = new Solucion();
	public Solucion mejorSolucionGrafo2 = new Solucion();
	public Solucion mejorSolucionGrafo3 = new Solucion();
	public Solucion mejorSolucionGrafo4 = new Solucion();

	public Grafo grafo_1() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(32);
		grafo.agregarVertice(1);
		grafo.agregarVertice(12);
		grafo.agregarVertice(7);
		grafo.agregarVertice(34);
		grafo.agregarVertice(45);
		grafo.agregarVertice(50);
		grafo.agregarVertice(100);

		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);

		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);

		grafo.agregarArista(4, 3);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(4, 6);
		grafo.agregarArista(5, 9);
		grafo.agregarArista(5, 6);
		grafo.agregarArista(5, 7);
		grafo.agregarArista(5, 8);

		grafo.agregarArista(6, 7);
		grafo.agregarArista(6, 8);

		grafo.agregarArista(7, 8);

		mejorSolucionGrafo1.agregar(grafo.get(5));
		mejorSolucionGrafo1.agregar(grafo.get(6));
		mejorSolucionGrafo1.agregar(grafo.get(7));
		mejorSolucionGrafo1.agregar(grafo.get(8));

		return grafo;
	}

	public Grafo grafo_2() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(90);
		grafo.agregarVertice(50);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		grafo.agregarVertice(10);
		grafo.agregarVertice(80);
		grafo.agregarVertice(50);
		grafo.agregarVertice(40);

		grafo.agregarArista(0, 5);

		grafo.agregarArista(1, 5);
		grafo.agregarArista(1, 3);

		grafo.agregarArista(2, 5);

		grafo.agregarArista(3, 1);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(3, 7);

		grafo.agregarArista(4, 5);

		grafo.agregarArista(6, 8);

		mejorSolucionGrafo2.agregar(grafo.get(6));
		mejorSolucionGrafo2.agregar(grafo.get(8));

		return grafo;
	}

	public Grafo grafo_3() {
		Grafo grafo = new Grafo();

		// 1er clique
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);

		grafo.agregarVertice(50);

		// 2da clique
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);

		// Vertice mas pesado
		grafo.agregarVertice(60);

		grafo.agregarVertice(30);
		grafo.agregarVertice(30);
		grafo.agregarVertice(30);

		grafo.agregarVertice(45);

		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(0, 4);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);

		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);

		grafo.agregarArista(4, 3);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(4, 6);

		grafo.agregarArista(5, 6);

		grafo.agregarArista(6, 7);
		grafo.agregarArista(6, 8);
		grafo.agregarArista(6, 9);
		grafo.agregarArista(6, 10);
		grafo.agregarArista(6, 11);

		grafo.agregarArista(7, 8);
		grafo.agregarArista(7, 9);
		grafo.agregarArista(7, 10);
		grafo.agregarArista(7, 11);

		grafo.agregarArista(8, 9);
		grafo.agregarArista(8, 10);
		grafo.agregarArista(8, 11);

		grafo.agregarArista(9, 10);
		grafo.agregarArista(9, 11);

		grafo.agregarArista(10, 11);

		grafo.agregarArista(11, 16);

		grafo.agregarArista(13, 14);

		grafo.agregarArista(14, 15);

		mejorSolucionGrafo3.agregar(grafo.get(4));
		mejorSolucionGrafo3.agregar(grafo.get(5));
		mejorSolucionGrafo3.agregar(grafo.get(6));

		return grafo;
	}

	public Grafo grafo_4() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(20);
		
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(5);
		
		grafo.agregarVertice(0);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);
		grafo.agregarVertice(10);

		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);

		grafo.agregarArista(2, 3);

		grafo.agregarArista(4, 5);
		grafo.agregarArista(4, 6);
		grafo.agregarArista(4, 7);
		grafo.agregarArista(4, 8);

		mejorSolucionGrafo4.agregar(grafo.get(1));
		mejorSolucionGrafo4.agregar(grafo.get(2));
		mejorSolucionGrafo4.agregar(grafo.get(3));

		return grafo;
	}
}
