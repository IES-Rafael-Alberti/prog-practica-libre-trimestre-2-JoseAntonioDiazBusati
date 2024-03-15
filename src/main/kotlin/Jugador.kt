package org.practicatrim2

class Jugador(
    nombre:String,
    tipo:Tipo,
    vida:Int,
    velocidad:Int):Personaje(nombre,tipo,vida,velocidad) {
    override fun recibirAtaque(ataque: Ataque): Int {
        return super.recibirAtaque(ataque)
    }

    fun obtenerAtaquesJugador(): List<Ataque> {
        val ataquesJugador = mutableListOf<Ataque>()
        ataquesJugador.add(GestionAtaque.listaAtaques[3])
        ataquesJugador.add(GestionAtaque.listaAtaques[9])
        ataquesJugador.add(GestionAtaque.listaAtaques[13])
        ataquesJugador.add(GestionAtaque.listaAtaques[19])
        return ataquesJugador
    }

    fun ataquesDelJugador(): Ataque {
        println("Ataques disponibles:")
        obtenerAtaquesJugador().forEachIndexed { index, ataque ->
            println("${index + 1}. ${ataque.name}")
        }

        println("Elige un número de ataque (1-4): ")
        val opcion = readLine()?.toIntOrNull() ?: 1
        val indiceAtaque = opcion - 1
        return obtenerAtaquesJugador().getOrElse(indiceAtaque) { obtenerAtaquesJugador().first() }
    }

    fun atacar(ataque: Ataque, enemigo: Enemigo) {
        println("$nombre utiliza ${ataque.name}!")
        enemigo.recibirAtaque(ataque)
    }
}