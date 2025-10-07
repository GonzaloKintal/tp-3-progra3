tp-3-progra3 — Buscador de cliques (algoritmo goloso)

¿Qué es?
Aplicación Java (Swing) para experimentar con heurísticas golosas que aproximan la clique máxima (o de mayor peso) en un grafo.

Qué hace
- Permite construir un grafo agregando vértices (con peso) y aristas, o generarlo aleatoriamente.
- Ejecuta variantes de un algoritmo goloso para obtener una clique a partir de diferentes criterios.
- Visualiza el grafo y muestra estadísticas básicas del proceso.

Tecnologías
- Java 8+ y Swing
- GraphStream para visualización

Requisitos
- Java 8 o superior
- Librerías GraphStream:
  - gs-core: https://github.com/graphstream/gs-core/releases/
  - gs-ui-swing: https://github.com/graphstream/gs-ui-swing/releases/tag/2.0

Ejecución
- En un IDE: abrir el proyecto y ejecutar el método main de interfaz.MainFrame.
- Por consola (ejemplo en Linux/macOS):
  1) Descargar las librerías de GraphStream y ubicarlas en un directorio lib/ en la raíz del proyecto.
  2) Compilar:
     mkdir -p out && javac -d out -cp 'lib/*' $(find src -name '*.java')
  3) Ejecutar (asegurando resources/ en el classpath para los íconos):
     java -cp 'out:lib/*:resources' interfaz.MainFrame

Notas
- Los recursos (iconos, etc.) se encuentran en resources/ y deben estar en el classpath.
- En imagenes_grafos/ hay imágenes de ejemplo de grafos utilizados para pruebas visuales.