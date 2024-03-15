package org.practicatrim2

class Jugador(
    nombre: String,
    tipo: Tipo,
    vida: Int,
    velocidad: Int
) : Personaje(nombre, tipo, vida, velocidad), DarAtaques {

    override fun obtenerAtaques(): List<Ataque> {
        val ataquesJugador = mutableListOf<Ataque>()
        ataquesJugador.add(GestionAtaque.listaAtaques[3])
        ataquesJugador.add(GestionAtaque.listaAtaques[9])
        ataquesJugador.add(GestionAtaque.listaAtaques[13])
        ataquesJugador.add(GestionAtaque.listaAtaques[19])
        return ataquesJugador
    }

    override fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
        return this.tipo.calcularEfectividad(tipoAtaque)
    }

    fun atacar(enemigo: Enemigo) {
        println("Elige un ataque:")
        val ataquesDisponibles = obtenerAtaques()
        ataquesDisponibles.forEachIndexed { index, ataque ->
            println("${index + 1}. ${ataque.name}")
        }

        println("Ingresa el número del ataque que deseas usar: ")
        val opcion = readLine()?.toIntOrNull() ?: 1
        val indiceAtaque = opcion - 1
        val ataqueSeleccionado = ataquesDisponibles.getOrElse(indiceAtaque) { ataquesDisponibles.first() }

        val efectividad = enemigo.tipo.calcularEfectividad(ataqueSeleccionado.type)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> (ataqueSeleccionado.damage * 2)
            Efectividad.POCO_EFECTIVO -> (ataqueSeleccionado.damage / 2)
            Efectividad.SIN_EFECTO -> 0
            else -> ataqueSeleccionado.damage
        }
        println("$nombre utiliza ${ataqueSeleccionado.name} contra ${enemigo.nombre} y causa $danio puntos de daño.")
        enemigo.recibirAtaque(Ataque(ataqueSeleccionado.name, ataqueSeleccionado.type, danio))
        println("${enemigo.nombre} está a ${enemigo.vida} de vida")
    }
}

