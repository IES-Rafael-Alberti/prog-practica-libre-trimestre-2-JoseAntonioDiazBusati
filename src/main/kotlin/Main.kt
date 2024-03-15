package org.practicatrim2

fun main() {
    val mbappe = Jugador("Mbappé", Tipo("Electrico"),600,10)
    val alkhelaifi = Enemigo("Al-Khelaïfi",Tipo("Tierra"),400,13)
    val luisenrique = Enemigo("Luis Enrique",Tipo("Roca"),170,3)
    val kloop = Enemigo("Jürgen Klopp",Tipo("Acero"),190,7)
    val macron = Enemigo("Emmanuel Macron",Tipo("Agua"),160,15)

    while (mbappe.vida > 0 && macron.vida > 0) {
        if (macron != null) {
            val ataqueSeleccionadoJugador = mbappe.ataquesDelJugador()
            mbappe.atacar(ataqueSeleccionadoJugador, macron)
            if (macron.vida <= 0) {
                println("${macron.nombre} ha sido derrotado.")
            } else {
                val ataqueSeleccionadoEnemigo = macron.atacar(mbappe)
                macron.recibirAtaque(ataqueSeleccionadoEnemigo)
                if (mbappe.vida <= 0) {
                    println("${mbappe.nombre} ha sido derrotado.")
                    return
                }
            }
        }
    }

    println("¡${mbappe.nombre} ha ganado!")
}