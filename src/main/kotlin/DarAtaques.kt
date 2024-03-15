package org.practicatrim2

interface DarAtaques {
    fun obtenerAtaques(): List<Ataque>
    fun calcularEfectividad(tipoAtaque: Tipo): Efectividad
}