package org.practicatrim2

open class Tipo(var tipo: String) {
    fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
        return when (this.tipo) {
            "Roca" -> when (tipoAtaque.tipo) {
                "Fuego" -> Efectividad.MUY_EFECTIVO
                "Tierra","Acero" -> Efectividad.POCO_EFECTIVO
                else -> Efectividad.NORMAL
            }
            "Fuego" -> when (tipoAtaque.tipo) {
                "Planta","Acero" -> Efectividad.MUY_EFECTIVO
                "Agua","Tierra","Roca" -> Efectividad.POCO_EFECTIVO
                else -> Efectividad.NORMAL
            }
            "Agua" -> when (tipoAtaque.tipo) {
                "Fuego","Tierra","Roca" -> Efectividad.MUY_EFECTIVO
                "Acero", "Electrico","Planta" -> Efectividad.POCO_EFECTIVO
                else -> Efectividad.NORMAL
            }
            "Tierra" -> when (tipoAtaque.tipo) {
                "Electrico","Fuego","Acero","Roca" -> Efectividad.MUY_EFECTIVO
                "Agua","Planta" -> Efectividad.POCO_EFECTIVO
                else -> Efectividad.NORMAL
            }
            "Electrico" -> when (tipoAtaque.tipo) {
                "Agua" -> Efectividad.MUY_EFECTIVO
                "Roca" -> Efectividad.POCO_EFECTIVO
                "Tierra" -> Efectividad.SIN_EFECTO
                else -> Efectividad.NORMAL
            }
            "Planta" -> when (tipoAtaque.tipo) {
                "Agua","Roca","Tierra" -> Efectividad.MUY_EFECTIVO
                "Fuego","Acero" -> Efectividad.POCO_EFECTIVO
                else -> Efectividad.NORMAL
            }
            "Acero" -> when (tipoAtaque.tipo){
                "Roca" -> Efectividad.MUY_EFECTIVO
                "Fuego","Tierra" -> Efectividad.POCO_EFECTIVO
                else ->Efectividad.NORMAL
            }
            else -> Efectividad.NORMAL
        }
    }
}