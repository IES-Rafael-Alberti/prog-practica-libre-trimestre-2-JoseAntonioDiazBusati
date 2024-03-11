package org.practicatrim2

class Enemigo(
    nombre:String,
    tipo:Tipo,
    vida:Int,
    velocidad:Int):Personaje(nombre,tipo,vida) {
    override fun recibirAtaque(ataque: Ataque): Int {
        return super.recibirAtaque(ataque)
    }
}