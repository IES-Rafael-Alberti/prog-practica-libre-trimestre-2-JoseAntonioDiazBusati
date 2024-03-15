package org.practicatrim2
open class Personaje(
    val nombre:String,
    val tipo: Tipo,
    var vida:Int,
    val velocidad:Int) {
    fun recibirAtaque(ataque: Ataque): Int {
        val efectividad = tipo.calcularEfectividad(ataque.type)
        val danio = (ataque.damage * efectividad.valor).toInt()
        vida -= danio
        return danio
    }
}