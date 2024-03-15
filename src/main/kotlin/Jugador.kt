package org.practicatrim2
/**
 * Clase que representa al jugador en el juego.
 * @property nombre El nombre del jugador.
 * @property tipo El tipo del jugador.
 * @property vida La cantidad de vida del jugador.
 * @property velocidad La velocidad del jugador.
 * @constructor Crea un nuevo jugador con los parámetros especificados.
 */
class Jugador(
    nombre: String,
    tipo: Tipo,
    vida: Int,
    velocidad: Int
) : Personaje(nombre, tipo, vida, velocidad), DarAtaques {
    /**
     * Función que permite al jugador obtener una lista de ataques disponibles.
     * @return La lista de ataques del jugador.
     */
    override fun obtenerAtaques(): List<Ataque> {
        val ataquesJugador = mutableListOf<Ataque>()
        ataquesJugador.add(GestionAtaque.listaAtaques[3])
        ataquesJugador.add(GestionAtaque.listaAtaques[9])
        ataquesJugador.add(GestionAtaque.listaAtaques[13])
        ataquesJugador.add(GestionAtaque.listaAtaques[19])
        return ataquesJugador
    }
    /**
     * Función que calcula la efectividad del ataque del jugador contra un tipo de ataque específico.
     * @param tipoAtaque El tipo de ataque a calcular su efectividad.
     * @return La efectividad del ataque.
     */
    override fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
        return this.tipo.calcularEfectividad(tipoAtaque)
    }
    /**
     * Función que permite al jugador atacar a un enemigo.
     * @param enemigo El enemigo al que se va a atacar.
     */
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
            Efectividad.MUY_EFECTIVO -> (ataqueSeleccionado.damage)
            Efectividad.POCO_EFECTIVO -> (ataqueSeleccionado.damage)
            Efectividad.SIN_EFECTO -> 0
            else -> ataqueSeleccionado.damage
        }
        println("$nombre utiliza ${ataqueSeleccionado.name} contra ${enemigo.nombre}")
        enemigo.recibirAtaque(Ataque(ataqueSeleccionado.name, ataqueSeleccionado.type, danio))
        println("${enemigo.nombre} está a ${enemigo.vida} de vida")
    }
}

