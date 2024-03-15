package org.practicatrim2
/**
 * Clase que representa a un enemigo en el juego.
 * @property nombre El nombre del enemigo.
 * @property tipo El tipo del enemigo.
 * @property vida La cantidad de vida del enemigo.
 * @property velocidad La velocidad del enemigo.
 * @constructor Crea un nuevo enemigo con los parámetros especificados.
 */
class Enemigo(
    nombre: String,
    tipo: Tipo,
    vida: Int,
    velocidad: Int
) : Personaje(nombre, tipo, vida, velocidad), DarAtaques {
    /**
     * Función que permite al enemigo obtener una lista de ataques disponibles.
     * @return La lista de ataques del enemigo.
     */
    override fun obtenerAtaques(): List<Ataque> {
        return GestionAtaque.listaAtaques.shuffled().take(4)
    }
    /**
     * Función que calcula la efectividad del ataque del enemigo contra un tipo de ataque específico.
     * @param tipoAtaque El tipo de ataque a calcular su efectividad.
     * @return La efectividad del ataque.
     */
    override fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
        return this.tipo.calcularEfectividad(tipoAtaque)
    }
    /**
     * Función que permite al enemigo atacar a un jugador.
     * @param jugador El jugador al que se va a atacar.
     */
    fun atacar(jugador: Jugador) {
        val ataqueSeleccionadoE = obtenerAtaques().random()
        val efectividad = jugador.tipo.calcularEfectividad(ataqueSeleccionadoE.type)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> (ataqueSeleccionadoE.damage)
            Efectividad.POCO_EFECTIVO -> (ataqueSeleccionadoE.damage)
            Efectividad.SIN_EFECTO -> 0
            else -> ataqueSeleccionadoE.damage
        }
        println("$nombre utiliza ${ataqueSeleccionadoE.name} contra ${jugador.nombre}")
        jugador.recibirAtaque(Ataque(ataqueSeleccionadoE.name, ataqueSeleccionadoE.type, danio))
        println("${jugador.nombre} está a ${jugador.vida} de vida")
    }
}