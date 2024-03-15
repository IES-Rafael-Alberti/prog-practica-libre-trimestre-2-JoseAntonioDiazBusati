package org.practicatrim2
/**
 * Clase que representa un ataque con su nombre, tipo y daño.
 * @property nombre El nombre del ataque.
 * @property tipo El tipo de ataque.
 * @property danio El daño causado por el ataque.
 */
class Ataque(nombre:String,tipo:Tipo,danio:Int) {
    val name = nombre
    val type = tipo
    val damage = danio
}