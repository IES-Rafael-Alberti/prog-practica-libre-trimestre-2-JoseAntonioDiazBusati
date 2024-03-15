package org.practicatrim2
/**
 * Clase que representa el tipo de un personaje o ataque en el juego.
 * @property tipo El tipo del personaje o ataque.
 */
open class Tipo(var tipo: String) {
    /**
     * Calcula la efectividad de un tipo de ataque contra otro tipo.
     * @param tipoAtaque El tipo del ataque contra el que se quiere calcular la efectividad.
     * @return El nivel de efectividad del ataque.
     */
    fun calcularEfectividad(tipoAtaque: Tipo): Efectividad {
            return when (this.tipo) {
                "Roca" -> when (tipoAtaque.tipo) {
                    "Tierra","Acero","Agua","Planta" -> Efectividad.MUY_EFECTIVO
                    "Fuego" -> Efectividad.POCO_EFECTIVO
                    else -> Efectividad.NORMAL
                }
                "Fuego" -> when (tipoAtaque.tipo) {
                    "Agua","Tierra","Roca"-> Efectividad.MUY_EFECTIVO
                    "Planta","Fuego" -> Efectividad.POCO_EFECTIVO
                    else -> Efectividad.NORMAL
                }
                "Agua" -> when (tipoAtaque.tipo) {
                    "Electrico","Planta" -> Efectividad.MUY_EFECTIVO
                    "Acero","Agua","Fuego" -> Efectividad.POCO_EFECTIVO
                    else -> Efectividad.NORMAL
                }
                "Tierra" -> when (tipoAtaque.tipo) {
                    "Agua","Planta" -> Efectividad.MUY_EFECTIVO
                    "Roca" -> Efectividad.POCO_EFECTIVO
                    "Electrico" -> Efectividad.SIN_EFECTO
                    else -> Efectividad.NORMAL
                }
                "Electrico" -> when (tipoAtaque.tipo) {
                    "Tierra" -> Efectividad.MUY_EFECTIVO
                    "Acero","Electrico" -> Efectividad.POCO_EFECTIVO
                    else -> Efectividad.NORMAL
                }
                "Planta" -> when (tipoAtaque.tipo) {
                    "Fuego" -> Efectividad.MUY_EFECTIVO
                    "Agua","Planta","Electrico" -> Efectividad.POCO_EFECTIVO
                    else -> Efectividad.NORMAL
                }
                "Acero" -> when (tipoAtaque.tipo){
                    "Fuego","Tierra" -> Efectividad.MUY_EFECTIVO
                    "Acero","Roca","Planta" -> Efectividad.POCO_EFECTIVO
                    else ->Efectividad.NORMAL
                }
                else -> Efectividad.NORMAL
            }
        }
}