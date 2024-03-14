package org.practicatrim2
open class Personaje(
    val nombre:String,
    val tipo: Tipo,
    var vida:Int,
    velocidad:Int) {
    open fun recibirAtaque(ataque: Ataque): Int {
        val efectividad = Tipo.calcularEfectividad(ataque.type,this.tipo)
        val danio = when (efectividad) {
            Efectividad.MUY_EFECTIVO -> ataque.damage * 2
            Efectividad.POCO_EFECTIVO -> ataque.damage / 2
            Efectividad.SIN_EFECTO -> ataque.damage * 0
            else -> ataque.damage
        }
        vida =- danio
        return vida
    }

}