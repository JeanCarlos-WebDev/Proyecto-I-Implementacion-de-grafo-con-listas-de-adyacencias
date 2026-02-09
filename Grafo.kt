package proyecto1

import java.util.HashMap

class Grafo<T>{
    private val vertices: MutableMap<Int, NodoVer<T>> = mutableMapOf()

    private val head: NodoVer<T> = NodoVer(Vertice(Int.MIN_VALUE)) // centinela head
    private val tail: NodoVer<T> = NodoVer(Vertice(Int.MAX_VALUE)) // centinela tail
    var tamanio: Int = 0
        private set

        init{
            head.next = tail
            tail.prev = head
        }


        fun agregarVertice(key: Int, valor: T): Boolean{

            
        }
        fun conectar(idVer1: Int, idVer2: Int): Boolean{

        }

        fun obtenerArcosEntrada(keyVer: Int): List<T>{
            val list: MutableList<T> = mutableListOf()
            for (i in vertices.keys){
                val nodo = vertices[i]
                if (nodo?.ady?.containsKey(keyVer) == true){
                    nodo.ver.value?.let { list.add(it) } 
                }
            }
            return list

        }

        fun eliminarVertice(keyVer: Int): Boolean{
            val nodo = vertices[keyVer] ?: return false
            
            for (i in nodo.ady.keys){
                vertices[i]?.ady?.remove(keyVer)
            }
            nodo.prev?.next = nodo.next
            nodo.next?.prev = nodo.prev
            vertices.remove(keyVer)
            tamanio--
            return true 
        }


        fun tamano(): Int {
            return this.tamanio
        }

    fun subgrafo(subVertices: Collection<Int>): Grafo<T>{
        val sub = Grafo<T>()

    val setSub = subVertices.toSet()
    for (i in subVertices){
        if (vertices.containsKey(i)){
            sub.agregarVertice(i, vertices[i]?.ver?.value)
        }
    } 
    for (i in subVertices){
        val nodo = vertices[i] ?: continue
        for (j in nodo.ady.keys){
            if (setSub.contains(j)){
                sub.conectar(i,j)
            }
        }
    }
    return sub
    }
}
