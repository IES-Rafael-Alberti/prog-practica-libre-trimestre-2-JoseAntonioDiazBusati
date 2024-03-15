package org.practicatrim2

class Jugador(
    nombre: String,
    tipo: Tipo,
    vida: Int,
    velocidad: Int
) : Personaje(nombre, tipo, vida, velocidad), DarAtaques {
    override fun recibirAtaque(ataque: Ataque): Int {
        return super.recibirAtaque(ataque)
    }

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

    fun ataquesDelJugador(): Ataque {
        println("Ataques disponibles:")
        obtenerAtaques().forEachIndexed { index, ataque ->
            println("${index + 1}. ${ataque.name}")
        }

        println("Elige un número de ataque (1-4): ")
        val opcion = readLine()?.toIntOrNull() ?: 1
        val indiceAtaque = opcion - 1
        val ataqueSeleccionado = obtenerAtaques().getOrElse(indiceAtaque) { obtenerAtaques().first() }

        val efectividad = calcularEfectividad(ataqueSeleccionado.type)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> (ataqueSeleccionado.damage * 2)
            Efectividad.POCO_EFECTIVO -> (ataqueSeleccionado.damage / 2)
            Efectividad.SIN_EFECTO -> 0
            else -> ataqueSeleccionado.damage
        }
        return Ataque(ataqueSeleccionado.name, ataqueSeleccionado.type, danio)
    }

    fun atacar(ataque: Ataque, enemigo: Enemigo) {
        println("$nombre utiliza ${ataque.name}!")
        val efectividad = enemigo.tipo.calcularEfectividad(ataque.type)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> (ataque.damage * 2)
            Efectividad.POCO_EFECTIVO -> (ataque.damage / 2)
            Efectividad.SIN_EFECTO -> 0
            else -> ataque.damage
        }
        enemigo.recibirAtaque(Ataque(ataque.name, ataque.type, danio))
    }

}