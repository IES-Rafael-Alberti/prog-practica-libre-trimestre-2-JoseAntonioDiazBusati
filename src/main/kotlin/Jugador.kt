package org.practicatrim2

class Jugador(
    nombre:String,
    tipo:Tipo,
    vida:Int,
    velocidad:Int):Personaje(nombre,tipo,vida,velocidad){
    override fun recibirAtaque(ataque: Ataque): Int {
        return super.recibirAtaque(ataque)
    }
    fun obtenerAtaquesJugador(): List<Ataque> {
        val ataquesJugador = mutableListOf<Ataque>()
        ataquesJugador.add(GestionAtaque.listaAtaques[3])
        ataquesJugador.add(GestionAtaque.listaAtaques[9])
        ataquesJugador.add(GestionAtaque.listaAtaques[13])
        ataquesJugador.add(GestionAtaque.listaAtaques[19])
        return ataquesJugador
    }
    fun atacar(enemigo: Enemigo) {
    }
}