package proyecto1

import java.util.HashMap

class ListaAdyacenciaGrafo<T> : Grafo<T> {
    val vertices: MutableMap<Int, NodoVer<T>> = mutableMapOf()

    private val head: NodoVer<T> = NodoVer(Vertice(Int.MIN_VALUE)) // centinela head
    private val tail: NodoVer<T> = NodoVer(Vertice(Int.MAX_VALUE)) // centinela tail
    var tamanio: Int = 0
        private set

        init{
            head.next = tail
            tail.prev = head
        }



        fun agregarVertice(key: Int, valor: T): Boolean{
            for (vertice in vertices) {
                if (vertice.key == key || vertice.value == valor){
                    return false
                }
            }
            vertices[key] = NodoVer(Vertice(key, valor))
            vertices[key]?.next = tail
            vertices[key]?.prev = tail.prev
            tail.prev = vertices[key]
            tamanio++
            return true
        }
        //mío


        fun contiene(idVer: Int): Boolean{
            if (vertices.containsKey(idVer) == false){
                return false
            }
            return true
        }

        fun conectar(idVer1: Int, idVer2: Int): Boolean{
            // Como el grafo es no dirigido tenemos que añadir información redundante
            val listaLad1 = vertices[idVer1] 
            val listaLad2 = vertices[idVer2]
            if (listaLad1 == null || listaLad2 == null){
                return false
            }

            listaLad1.ady[idVer2] = listaLad2
            listaLad2.ady[idVer1] = listaLad1

            return true
            

        }

        fun obtenerArcosSalida(idVer: Int): List<T>{
            val list: MutableList<T> = mutableListOf()
            if(vertices.containsKey(idVer)){
                vertices[idVer]!!.ady.values.forEach {it -> if(it.ver.value != null ) list.add(it.ver.value)}
            }
            
            return list

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
        val sub = ListaAdyacenciaGrafo<T>()

    val setSub = subVertices.toSet()
    var value: T?
    for (i in subVertices){
        value = vertices[i]?.ver?.value
        if (vertices.containsKey(i) && value != null){
            sub.agregarVertice(i, value)
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
