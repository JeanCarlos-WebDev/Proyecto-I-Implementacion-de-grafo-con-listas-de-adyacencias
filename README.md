## Proyecto-I-Grafo-Implementacion-con-listas-de-adyacencias

## Integrantes:

- Jean Sifontes carnet: 22-10387
- Cristina Puyosa carnet: 23-10395
----------------------------------------------------
## Descripción

Se implementó un grafo dirigido genérico en Kotlin utilizando listas de adyacencia, estructura que almacena para cada vértice el conjunto de sus vecinos.

---------------------------------------------------

## Estructuras usadas

# vertexMap<T, Int>
Asocia cada vértice con un índice interno.
→ Permite búsquedas en O(1) promedio.

# indexToVertex<Int, T>
Recupera el vértice desde su índice.

# adj: MutableMap<Int, MutableSet<Int>>
Representa la lista de adyacencia.

## Decisiones de Implementación

- El tamaño del grafo se obtiene con vertexMap.size para evitar inconsistencias.
- No se permiten vértices ni arcos duplicados.
- Al eliminar un vértice se reconstruyen los índices para mantener la estructura compacta.

-------------------------------------------------------------

## Complejidad de los Métodos

Sea:

- **V** = número de vértices del grafo  
- **E** = número de arcos  
- **k** = grado (cantidad de vecinos) de un vértice  

| Método | Orden | Justificación |
|--------|--------|---------------|
| **agregarVertice** | O(1) promedio | Insertar en el `HashMap`, agregar al `MutableList` y crear una lista de adyacencia son operaciones constantes sin recorridos. |
| **conectar** | O(1) promedio | Se buscan ambos vértices en la tabla hash y se inserta el destino en un `MutableSet`, cuya inserción es constante en promedio. |
| **contiene** | O(1) | La verificación se realiza directamente sobre el `HashMap`. |
| **obtenerArcosSalida** | O(k) | Solo se recorre la lista de adyacencia del vértice, cuyo tamaño es su grado. No depende del tamaño total del grafo. |
| **obtenerArcosEntrada** | O(V + E) | Es necesario inspeccionar todas las listas de adyacencia para determinar qué vértices apuntan al vértice objetivo. En el peor caso se recorren todos los arcos. |
| **eliminarVertice** | O(V + E) | Se eliminan los arcos de salida en tiempo proporcional a su grado y luego se revisan todas las listas para borrar arcos de entrada. |
| **tamano** | O(1) | Retorna el tamaño almacenado en la estructura sin realizar recorridos. |
| **subgrafo** | O(V + E) | Primero se filtran los vértices solicitados y luego se recorren únicamente sus listas de adyacencia para copiar los arcos existentes dentro del subconjunto. |


