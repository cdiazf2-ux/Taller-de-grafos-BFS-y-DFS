import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Representa un mapa sencillo de lugares conectados dentro de una escuela.
 * Cada vertice es un lugar y cada arista representa un camino entre dos lugares.
 * DFS explora un camino lo mas lejos posible; BFS visita primero los lugares
 * que estan a menos conexiones del punto de inicio.
 */
public class GrafoNoDirigido {
    private final int[][] adjMat;
    private final boolean[] visited;

    public GrafoNoDirigido(int cantidadVertices) {
        if (cantidadVertices <= 0) {
            throw new IllegalArgumentException("El grafo debe tener al menos un vertice.");
        }

        adjMat = new int[cantidadVertices][cantidadVertices];
        visited = new boolean[cantidadVertices];
    }

    public void agregarArista(int origen, int destino) {
        validarVertice(origen);
        validarVertice(destino);

        adjMat[origen][destino] = 1;
        adjMat[destino][origen] = 1;
    }

    public void dfs(int vertice) {
        validarVertice(vertice);
        reiniciarVisitados();
        dfsRecursivo(vertice);
        System.out.println();
    }

    private void dfsRecursivo(int vertice) {
        visited[vertice] = true;
        mostrarVertice(vertice);

        for (int vecino = 0; vecino < adjMat.length; vecino++) {
            boolean existeArista = adjMat[vertice][vecino] == 1;
            boolean noVisitado = !visited[vecino];

            if (existeArista && noVisitado) {
                dfsRecursivo(vecino);
            }
        }
    }

    public void bfs(int verticeInicial) {
        validarVertice(verticeInicial);
        reiniciarVisitados();

        Queue<Integer> cola = new ArrayDeque<>();
        visited[verticeInicial] = true;
        cola.add(verticeInicial);

        while (!cola.isEmpty()) {
            int vertice = cola.remove();
            mostrarVertice(vertice);

            for (int vecino = 0; vecino < adjMat.length; vecino++) {
                boolean existeArista = adjMat[vertice][vecino] == 1;
                boolean noVisitado = !visited[vecino];

                if (existeArista && noVisitado) {
                    visited[vecino] = true;
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    private void reiniciarVisitados() {
        for (int vertice = 0; vertice < visited.length; vertice++) {
            visited[vertice] = false;
        }
    }

    private void mostrarVertice(int vertice) {
        System.out.print(vertice + " ");
    }

    private void validarVertice(int vertice) {
        if (vertice < 0 || vertice >= adjMat.length) {
            throw new IllegalArgumentException("Vertice fuera del rango: " + vertice);
        }
    }

    public static void main(String[] args) {
        System.out.println("Situacion: recorridos entre lugares de una escuela.");
        System.out.println("Vertices: 0=Entrada, 1=Biblioteca, 2=Cafeteria,");
        System.out.println("          3=Laboratorio, 4=Aula, 5=Gimnasio");
        System.out.println("Cada conexion representa un camino que se puede recorrer en ambos sentidos.");
        System.out.println();

        GrafoNoDirigido grafo = new GrafoNoDirigido(6);

        // Caminos entre los lugares de la escuela.
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);

        System.out.print("DFS desde el vertice 0: ");
        grafo.dfs(0);

        System.out.print("BFS desde el vertice 0: ");
        grafo.bfs(0);
    }
}
