package org.practicatrim2

class GestionAtaque {
    private val listaAtaques = mutableListOf<Ataque>()

    fun anadirAtaque(ataque: Ataque) {
        listaAtaques.add(ataque)
    }

    fun eliminarAtaque(ataque: Ataque) {
        listaAtaques.remove(ataque)
    }

    fun obtenerAtaques(): List<Ataque> {
        return listaAtaques.toList()
    }
}