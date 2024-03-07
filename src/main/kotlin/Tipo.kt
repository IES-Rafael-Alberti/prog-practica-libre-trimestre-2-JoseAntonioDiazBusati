package org.practicatrim2

class Tipo(var tipo: String) {
    companion object {
        fun calcularEfectividad(tipoAtaque: Tipo, tipoActual: Tipo): Efectividad {
            return when (tipoActual.tipo) {
                "" -> when (tipoAtaque.tipo) {
                    "" -> Efectividad.MUY_EFECTIVO
                    "" -> Efectividad.POCO_EFECTIVO
                    "" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                "" -> when (tipoAtaque.tipo) {
                    "" -> Efectividad.MUY_EFECTIVO
                    "" -> Efectividad.POCO_EFECTIVO
                    "" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                "" -> when (tipoAtaque.tipo) {
                    "" -> Efectividad.MUY_EFECTIVO
                    "" -> Efectividad.POCO_EFECTIVO
                    "" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                "" -> when (tipoAtaque.tipo) {
                    "" -> Efectividad.MUY_EFECTIVO
                    "" -> Efectividad.POCO_EFECTIVO
                    "" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                "" -> when (tipoAtaque.tipo) {
                    "" -> Efectividad.MUY_EFECTIVO
                    "" -> Efectividad.POCO_EFECTIVO
                    "" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                "" -> when (tipoAtaque.tipo) {
                    "" -> Efectividad.MUY_EFECTIVO
                    "" -> Efectividad.POCO_EFECTIVO
                    "" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                else -> Efectividad.NORMAL
            }
        }
    }
}