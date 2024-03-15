package org.practicatrim2
/**
 * Clase base que representa a un personaje en el juego.
 * @property nombre El nombre del personaje.
 * @property tipo El tipo del personaje.
 * @property vida La cantidad de vida del personaje.
 * @property velocidad La velocidad del personaje.
 * @constructor Crea un nuevo personaje con los parámetros especificados.
 */
open class Personaje(
    val nombre:String,
    val tipo: Tipo,
    var vida:Int,
    val velocidad:Int) {
    /**
     * Función que permite al personaje recibir un ataque y actualizar su vida en consecuencia.
     * @param ataque El ataque recibido por el personaje.
     * @return La cantidad de daño recibido por el personaje.
     */
    fun recibirAtaque(ataque: Ataque): Int {
        val efectividad = tipo.calcularEfectividad(ataque.type)
        val danio = (ataque.damage * efectividad.valor).toInt()
        vida -= danio
        return danio
    }
}