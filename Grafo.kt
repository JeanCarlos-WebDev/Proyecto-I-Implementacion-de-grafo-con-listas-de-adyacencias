package proyecto1

interface Grafo<T> {
    fun agregarVertice(key: Int, v: T): Boolean
    fun eliminarVertice(keyVer: Int): Boolean
    fun conectar(idVer1: Int, idVer2: Int): Boolean
    fun contiene(idVer: Int): Boolean
    fun obtenerArcosSalida(idVer: Int): List<T>
    fun obtenerArcosEntrada(keyVer: Int): List<T>
    fun tamano(): Int
    fun subgrafo(vertices: Collection<T>): Grafo<T>
}