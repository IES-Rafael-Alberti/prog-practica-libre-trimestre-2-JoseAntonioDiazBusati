package org.practicatrim2

class Tipo(var tipo: String) {
    companion object {
        private val listaTipo = mutableListOf<Tipo>()
        init {
            listaTipo.add(Tipo("Roca"))
            listaTipo.add(Tipo("Fuego"))
            listaTipo.add(Tipo("Agua"))
            listaTipo.add(Tipo("Tierra"))
            listaTipo.add(Tipo("Electrico"))
            listaTipo.add(Tipo("Planta"))
            listaTipo.add(Tipo("Acero"))
        }
        fun obtenerTipos(): List<Tipo> {
            return listaTipo.toList()
        }
        fun calcularEfectividad(tipoAtaque: Tipo, tipoActual: Tipo): Efectividad {
            return when (tipoActual.tipo) {
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
}