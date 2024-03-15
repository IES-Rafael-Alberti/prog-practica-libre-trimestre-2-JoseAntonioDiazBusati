package org.practicatrim2

class Enemigo(
    nombre: String,
    tipo: Tipo,
    vida: Int,
    velocidad: Int
) : Personaje(nombre, tipo, vida, velocidad), DarAtaques {

    override fun obtenerAtaques(): List<Ataque> {
        return GestionAtaque.listaAtaques.shuffled().take(4)
    }

    override fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
        return this.tipo.calcularEfectividad(tipoAtaque)
    }

    fun atacar(jugador: Jugador) {
        val ataqueSeleccionadoE = obtenerAtaques().random()
        val efectividad = jugador.tipo.calcularEfectividad(ataqueSeleccionadoE.type)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> (ataqueSeleccionadoE.damage * 2)
            Efectividad.POCO_EFECTIVO -> (ataqueSeleccionadoE.damage / 2)
            Efectividad.SIN_EFECTO -> 0
            else -> ataqueSeleccionadoE.damage
        }
        println("$nombre utiliza ${ataqueSeleccionadoE.name} contra ${jugador.nombre} y causa $danio puntos de daño.")
        jugador.recibirAtaque(Ataque(ataqueSeleccionadoE.name, ataqueSeleccionadoE.type, danio))
        println("${jugador.nombre} está a ${jugador.vida} de vida")
    }
}