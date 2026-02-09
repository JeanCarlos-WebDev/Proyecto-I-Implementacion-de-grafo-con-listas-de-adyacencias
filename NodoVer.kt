package proyecto1

import  java.util.HashMap

class NodoVer<T>(
    val ver: Vertice <T>,
    var prev: NodoVer<T>? = null, 
    var next: NodoVer<T>? = null,
    val ady: MutableMap<Int, NodoVer<T>> = mutableMapOf())
