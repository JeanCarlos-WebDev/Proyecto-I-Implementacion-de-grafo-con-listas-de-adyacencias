# Proyecto-I-Grafo-Implementacion-con-listas-de-adyacencias

Integrantes:

- Jean Sifontes carnet: 22-10387
- Cristina Puyosa carnet: 23-10395

## Complejidad

| Función             | Complejidad      | Justificación                                                                                    |
| ------------------- | ---------------- | ------------------------------------------------------------------------------------------------ |
| agregarVertice      | O(1)             | Las operaciones de los Hashmaps en promedio toman tiempo constante                               |
| contiene            | O(1)             | Acceso directo por uso de Hashmaps                                                               |
| conectar            | O(1)             | Las operaciones de añadir y consultar de los Hashmaps en promedio toman tiempo constante         |
| obtenerArcosSalida  | O(k)             | k = # de sucesores (Debemos recorrer la lista de vértices adyacente a un vértice v)              |
| obtenerArcosEntrada | O(\|V\|)         | Debemos iterar sobre cada vértice                                                                |
| eliminarVertice     | O(\|V\|)         | Debemos recorrer vértices vecinos para eliminar la conexión que existía con el vértice eliminado |
| tamanio             | O(1)             |                                                                                                  |
| subGrafo            | O(\|V\| + \|E\|) | Debemos recorrer el grafo.                                                                       |

### Implementación:

Se utilizó listas doblementes enlazadas para facilitar acciones como la eliminación de nodos, además utilizamos colecciones nativas de Kotlin MutableMap, MutableList para la implementación. Se crearon 3 archivos diferentes:

1.\_ NodoVer.kt: Es la clase utilizada para representar los nodos de la lista doblemente enlazada contiene los apuntadores para el nodo anterior y siguiente, la información del vértice y la lista de lados.

2.\_Vertices.kt: Es la clase utilizada para representar el nodo, contiene el valor y el id del vértice

3.\_ ListaAdyacenciaGrafo.kt: Es la clase donde se implementó el grafo utilizando la representación de lista de adyacencia. Utilizamos Hashmaps para hacer las operaciones más óptimas
