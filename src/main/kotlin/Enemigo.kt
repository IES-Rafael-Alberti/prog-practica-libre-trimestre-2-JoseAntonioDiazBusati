package org.practicatrim2

class Enemigo(
    nombre:String,
    tipo:Tipo,
    vida:Int,
    velocidad:Int):Personaje(nombre,tipo,vida,velocidad) {
    override fun recibirAtaque(ataque: Ataque): Int {
        return super.recibirAtaque(ataque)
    }
    fun obtenerAtaquesEnemigos():List<Ataque>{
        return GestionAtaque.listaAtaques.shuffled().take(4)
    }
    fun atacar(jugador: Jugador): Ataque {
        val ataqueSeleccionadoE = obtenerAtaquesEnemigos().random()
        println("$nombre utiliza ${ataqueSeleccionadoE.name}!")
        return ataqueSeleccionadoE
    }
}