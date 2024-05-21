package logica;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AplicacionTest {

    @Test
    public void dameCliqueTest() {
        Grafo grafo = crearGrafo();
        Solucion clique = new Aplicacion(grafo).dameClique();
        
        assertEquals(136, clique.peso());
        assertEquals(4, clique.cantidadVertices());
    }

    private Grafo crearGrafo() {
        Grafo grafo = new Grafo();
        
        grafo.agregarVertice(4); // 0
        grafo.agregarVertice(5); // 1
        grafo.agregarVertice(32); // 2
        grafo.agregarVertice(1); // 3
        grafo.agregarVertice(12); // 4
        grafo.agregarVertice(7); // 5
        grafo.agregarVertice(34); // 6
        grafo.agregarVertice(45); // 7
        grafo.agregarVertice(50); // 8
        grafo.agregarVertice(100); // 9
        
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
        
        return grafo;
    }
}