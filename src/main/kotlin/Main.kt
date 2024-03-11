package org.practicatrim2

fun main() {

    val mbappe = Jugador("Mbappé", Tipo("Electrico"),350,91)
    val alkhelaifi = Jugador("Alkhelaifi",Tipo("Roca"),370,14)

    val jugador1 = mbappe
    val jugador2 = alkhelaifi

    while (jugador1.vida > 0 && jugador2.vida > 0) {}
}