package org.practicatrim2

class Enemigo(
    nombre: String,
    tipo: Tipo,
    vida: Int,
    velocidad: Int
) : Personaje(nombre, tipo, vida, velocidad), DarAtaques {
    override fun recibirAtaque(ataque: Ataque): Int {
        return super.recibirAtaque(ataque)
    }

    override fun obtenerAtaques(): List<Ataque> {
        return GestionAtaque.listaAtaques.shuffled().take(4)
    }

    override fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
        return this.tipo.calcularEfectividad(tipoAtaque)
    }

    fun atacar(jugador: Jugador): Ataque {
        val ataqueSeleccionadoE = obtenerAtaques().random()
        println("$nombre utiliza ${ataqueSeleccionadoE.name}!")
        val efectividad = jugador.tipo.calcularEfectividad(ataqueSeleccionadoE.type)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> (ataqueSeleccionadoE.damage * 2)
            Efectividad.POCO_EFECTIVO -> (ataqueSeleccionadoE.damage / 2)
            Efectividad.SIN_EFECTO -> 0
            else -> ataqueSeleccionadoE.damage
        }
        jugador.recibirAtaque(Ataque(ataqueSeleccionadoE.name, ataqueSeleccionadoE.type, danio))
        return Ataque(ataqueSeleccionadoE.name, ataqueSeleccionadoE.type, danio)
    }
}