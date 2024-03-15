package org.practicatrim2
import kotlin.random.Random
fun main() {
    val mbappe = Jugador("Mbappé", Tipo("Electrico"),600,10)
    val alkhelaifi = Enemigo("Al-Khelaïfi",Tipo("Tierra"),400,13)
    val luisenrique = Enemigo("Luis Enrique",Tipo("Roca"),180,3)
    val kloop = Enemigo("Jürgen Klopp",Tipo("Acero"),200,7)
    val macron = Enemigo("Emmanuel Macron",Tipo("Agua"),160,15)

    var continuaCombate = true

    val ataqueJugador = mbappe.ataquesDelJugador()
    val efectividadJugador = mbappe.calcularEfectividad(ataqueJugador.type)
    println("Efectividad del ataque de ${mbappe.nombre} (${ataqueJugador.type.tipo}) contra ${macron.nombre} (${macron.tipo.tipo}): $efectividadJugador")

    val ataqueEnemigo = macron.atacar(mbappe)
    val efectividadEnemigo = macron.calcularEfectividad(ataqueEnemigo.type)
    println("Efectividad del ataque de ${macron.nombre} (${ataqueEnemigo.type.tipo}) contra ${mbappe.nombre} (${mbappe.tipo.tipo}): $efectividadEnemigo")



    while (continuaCombate) {
        val ataqueJugador = mbappe.ataquesDelJugador()
        val danioJugador = calcularDanio(ataqueJugador, macron)
        macron.recibirAtaque(Ataque(ataqueJugador.name, ataqueJugador.type, danioJugador))

        println("${mbappe.nombre} utiliza ${ataqueJugador.name} contra ${macron.nombre} y causa $danioJugador puntos de daño.")

        if (macron.vida <= 0) {
            println("${macron.nombre} ha sido derrotado.")
            continuaCombate = false
        } else {
            val ataqueEnemigo = macron.atacar(mbappe)
            val danioEnemigo = calcularDanio(ataqueEnemigo, mbappe)
            mbappe.recibirAtaque(Ataque(ataqueEnemigo.name, ataqueEnemigo.type, danioEnemigo))

            println("${macron.nombre} utiliza ${ataqueEnemigo.name} contra ${mbappe.nombre} y causa $danioEnemigo puntos de daño.")

            if (mbappe.vida <= 0) {
                println("${mbappe.nombre} ha sido derrotado.")
                continuaCombate = false
            }
        }
    }
    if (mbappe.vida > 0) {
        println("¡${mbappe.nombre} ha ganado!")
        }
    }
    fun calcularDanio(ataque: Ataque, objetivo: Personaje): Int {
    val efectividad = objetivo.tipo.calcularEfectividad(ataque.type)
    return when (efectividad) {
        Efectividad.MUY_EFECTIVO -> (ataque.damage * 2)
        Efectividad.POCO_EFECTIVO -> (ataque.damage / 2)
        Efectividad.SIN_EFECTO -> 0
        else -> ataque.damage
    }
}