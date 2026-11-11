# Grafo no dirigido con DFS y BFS

## Descripcion de la actividad

Este ejercicio implementa en Java un grafo no dirigido usando una matriz de
adyacencia. El ejemplo representa lugares de una escuela y los caminos que
los conectan. Como el grafo no es dirigido, cada camino se puede recorrer en
ambos sentidos.

Se implementan dos recorridos desde un vertice inicial:

- **DFS (busqueda en profundidad):** visita un vertice, lo marca y explora
  recursivamente sus vecinos no visitados.
- **BFS (busqueda en anchura):** utiliza una cola para visitar primero los
  vecinos cercanos al punto de inicio.

El programa muestra en consola el orden de visita de ambos recorridos.

## Como ejecutar

Desde una terminal en la carpeta del proyecto, compila y ejecuta:

```text
javac GrafoNoDirigido.java
java GrafoNoDirigido
```

Los vertices del ejemplo van del `0` al `5`; el recorrido comienza en el
vertice `0`.
