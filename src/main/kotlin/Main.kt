package org.practicatrim2
fun main() {
    val mbappe = Jugador("Mbappé", Tipo("Electrico"),600,10)
    val alkhelaifi = Enemigo("Al-Khelaïfi",Tipo("Tierra"),400,13)
    val luisenrique = Enemigo("Luis Enrique",Tipo("Roca"),170,3)
    val kloop = Enemigo("Jürgen Klopp",Tipo("Acero"),200,7)
    val macron = Enemigo("Emmanuel Macron",Tipo("Agua"),140,15)

    var continuaCombate = true
    fun determinarMasRapido(enemigo: Enemigo, jugador: Jugador): Personaje {
        return if (enemigo.velocidad > jugador.velocidad) enemigo else jugador
    }


    println("Parece que te ha asaltado el presidente de Francia para detenerte y que no llegues a tu destino...")
    while (continuaCombate) {
        val masRapido = determinarMasRapido(macron, mbappe)
        if (masRapido is Jugador) {
            mbappe.atacar(macron)
            if (macron.vida <= 0) {
                println("${macron.nombre} ha sido derrotado.")
                continuaCombate = false
            } else {
                macron.atacar(mbappe)
                if (mbappe.vida <= 0) {
                    println("${mbappe.nombre} ha sido derrotado.")
                    continuaCombate = false
                }
            }
        } else if (masRapido is Enemigo) {
            macron.atacar(mbappe)
            if (mbappe.vida <= 0) {
                println("${mbappe.nombre} ha sido derrotado.")
                continuaCombate = false
            } else {
                mbappe.atacar(macron)
                if (macron.vida <= 0) {
                    println("${macron.nombre} ha sido derrotado.")
                    continuaCombate = false
                }
            }
        }
    }
    println("Una vez derrotado continuas...")
    println("Tu entrenador no quiere que te vayas y va a hacer todo lo posible para que te quedes...")
    var continuaCombate1 = true
    while (continuaCombate1) {
        val masRapido = determinarMasRapido(luisenrique, mbappe)
        if (masRapido is Jugador) {
            mbappe.atacar(luisenrique)
            if (luisenrique.vida <= 0) {
                println("${luisenrique.nombre} ha sido derrotado.")
                continuaCombate1 = false
            } else {
                luisenrique.atacar(mbappe)
                if (mbappe.vida <= 0) {
                    println("${mbappe.nombre} ha sido derrotado.")
                    continuaCombate1 = false
                }
            }
        } else if (masRapido is Enemigo) {
            luisenrique.atacar(mbappe)
            if (mbappe.vida <= 0) {
                println("${mbappe.nombre} ha sido derrotado.")
                continuaCombate1 = false
            } else {
                mbappe.atacar(luisenrique)
                if (luisenrique.vida <= 0) {
                    println("${luisenrique.nombre} ha sido derrotado.")
                    continuaCombate1 = false
                }
            }
        }
    }
    println("Una vez derrotado continuas...")
    println("Un entrenador te quiere fichar para su equipo en la liga inglesa pero sabes que ese no es tu lugar...")
    var continuaCombate2 = true
    while (continuaCombate2) {
        val masRapido = determinarMasRapido(kloop, mbappe)
        if (masRapido is Jugador) {
            mbappe.atacar(kloop)
            if (kloop.vida <= 0) {
                println("${kloop.nombre} ha sido derrotado.")
                continuaCombate2 = false
            } else {
                kloop.atacar(mbappe)
                if (mbappe.vida <= 0) {
                    println("${mbappe.nombre} ha sido derrotado.")
                    continuaCombate2 = false
                }
            }
        } else if (masRapido is Enemigo) {
            kloop.atacar(mbappe)
            if (mbappe.vida <= 0) {
                println("${mbappe.nombre} ha sido derrotado.")
                continuaCombate2 = false
            } else {
                mbappe.atacar(kloop)
                if (kloop.vida <= 0) {
                    println("${kloop.nombre} ha sido derrotado.")
                    continuaCombate2 = false
                }
            }
        }
    }
    println("Una vez derrotado continuas...")
    println("Finalmente estás cara a cara contra tu peor pesadilla, es el horrible presidente de tu club que no" +
            " te permite ir a tu destino: el Real Madrid. Espero que lo hayas hecho bien hasta llegar aquí.")
    var continuaCombate3 = true
    while (continuaCombate3) {
        val masRapido = determinarMasRapido(alkhelaifi, mbappe)
        if (masRapido is Jugador) {
            mbappe.atacar(alkhelaifi)
            if (alkhelaifi.vida <= 0) {
                println("${alkhelaifi.nombre} ha sido derrotado. Ahora eres libre.")
                continuaCombate3 = false
            } else {
                alkhelaifi.atacar(mbappe)
                if (mbappe.vida <= 0) {
                    println("${mbappe.nombre} ha sido derrotado.")
                    continuaCombate3 = false
                }
            }
        } else if (masRapido is Enemigo) {
            alkhelaifi.atacar(mbappe)
            if (mbappe.vida <= 0) {
                println("${mbappe.nombre} ha sido derrotado.")
                continuaCombate3 = false
            } else {
                mbappe.atacar(alkhelaifi)
                if (alkhelaifi.vida <= 0) {
                    println("${alkhelaifi.nombre} ha sido derrotado. Ahora eres libre.")
                    continuaCombate3 = false
                }
            }
        }
    }
}