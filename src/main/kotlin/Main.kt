package org.practicatrim2

fun main() {
    val mbappe = Jugador("Mbappé", Tipo("Electrico"),600,10)
    val alkhelaifi = Enemigo("Al-Khelaïfi",Tipo("Tierra"),400,13)
    val luisenrique = Enemigo("Luis Enrique",Tipo("Roca"),170,3)
    val kloop = Enemigo("Jürgen Klopp",Tipo("Acero"),190,7)
    val macron = Enemigo("Emmanuel Macron",Tipo("Agua"),160,15)

    val enemigos = mutableListOf(macron,luisenrique, kloop, alkhelaifi)

    while (mbappe.vida > 0 && enemigos.any { it.vida > 0 }) {
        val enemigoActivo = enemigos.firstOrNull { it.vida > 0 }
        if (enemigoActivo != null) {
            mbappe.atacar(enemigoActivo)
            if (enemigoActivo.vida <= 0) {
                println("${enemigoActivo.nombre} ha sido derrotado.")
                enemigos.remove(enemigoActivo)
            } else {
                enemigoActivo.atacar(mbappe)
                if (mbappe.vida <= 0) {
                    println("${mbappe.nombre} ha sido derrotado.")
                    return
                }
            }
        }
    }

    println("¡${mbappe.nombre} ha ganado!")
}