# Proyecto-I-Grafo-Implementacion-con-listas-de-adyacencias

Integrantes:

- Jean Sifontes carnet: 22-10387
- Cristina Puyosa carnet: 23-

## Complejidad

| Función             | Caso promedio         | Peor Caso                | justificación                                                                                                                                                |
| ------------------- | --------------------- | ------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| agregarVertice      | O(\|V\|)              | O(\|V\|)                 | Se debe iterar cada vértice para revisar que no está guardado                                                                                                |
| contiene            | O(1)                  | O(\|V\|)                 | Como se utilizan hashmaps en promedio verificar que un valor existe en la lista es de complejidad constante                                                  |
| conectar            | O(1)                  | O(\|V\|)                 | Como se utilizan hashmaps en promedio añadir nuevos elementos a las listas es de complejidad constante                                                       |
| obtenerArcosSalida  | O(\|E\|)              | O(\|V\| + \|E\|)         | Como se utilizan hashmaps en promedio encontrar el vértice nos toma tiempo constante y si el vértice tiene mucho lados entonces una cota superior es \|E\|   |
| obtenerArcosEntrada | O(\|V\|)              | O(\|V\| + \|E\|)         | Debemos iterar sobre cada vértice y como se utilizan hashmaps en promedio verificar si el vértice de salida está en la lista de lados del respectivo vértice |
| eliminarVertice     | O(\|V\|)              | O(\|V\|)                 | Debemos recorrer vértices vecinos para eliminar la conexión que existía con el vértice eliminado                                                             |
| tamanio             | O(1)                  | O(1)                     | Existe una propiedad que se actualiza constantemente                                                                                                         |
| subGrafo            | O(\|V~subgrafo~\|^2^) | O(\|V~subgrafo~\|x\|V\|) |

> **Nota:** Lo que diferencia entre el caso promedio y el peor caso es la complejidad del hashmap ya que sus operaciones en promedio es constante (O(1)); pero si hay muchas colisiones es tiempo lineal (O(n)) .

### Implementación:

Se utilizó listas doblementes enlazadas para facilitar acciones como la eliminación de nodos, además utilizamos colecciones nativas de Kotlin MutableMap, MutableList para la implementación. Se crearon 3 archivos diferentes:

1.\_ NodoVer.kt: Es la clase utilizada para representar los nodos de la lista doblemente enlazada contiene los apuntadores para el nodo anterior y siguiente, la información del vértice y la lista de lados.

2.\_Vertices.kt: Es la clase utilizada para representar el nodo, contiene el valor y el id del vértice

3.\_ ListaAdyacenciaGrafo.kt: Es la clase donde se implementó el grafo utilizando la implementación de lista de adyacencia.

Para los métodos de AdyacenciaGrafo.kt hicimos que las funciones recibieran un entero que represente el id en conjunto con el valor de tipo genérico, generalmente se utilizó solo el id para las funciones de práctica
