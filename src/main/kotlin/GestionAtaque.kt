package org.practicatrim2

class GestionAtaque {
    companion object {
        val listaAtaques = mutableListOf<Ataque>()
        private val tipoFuego = Tipo("Fuego")
        private val tipoAgua = Tipo("Agua")
        private val tipoRoca = Tipo("Roca")
        private val tipoTierra = Tipo("Tierra")
        private val tipoPlanta = Tipo("Planta")
        private val tipoAcero = Tipo("Acero")
        private val tipoElectrico = Tipo("Electrico")

        init {
            listaAtaques.add(Ataque("Lanzallamas", tipoFuego,90))
            listaAtaques.add(Ataque("Hidroariete", tipoAgua,85))
            listaAtaques.add(Ataque("Mazazo", tipoPlanta,110))
            listaAtaques.add(Ataque("Puño trueno", tipoElectrico,70))
            listaAtaques.add(Ataque("Foco resplandor", tipoAcero,85))
            listaAtaques.add(Ataque("Hoja aguda", tipoPlanta,85))
            listaAtaques.add(Ataque("Patada ignea", tipoFuego,105))
            listaAtaques.add(Ataque("Pedrada", tipoRoca,90))
            listaAtaques.add(Ataque("Surf", tipoAgua,90))
            listaAtaques.add(Ataque("Pataleta", tipoTierra,80))
            listaAtaques.add(Ataque("Roca afilada", tipoRoca,110))
            listaAtaques.add(Ataque("Colmillo rayo", tipoElectrico,65))
            listaAtaques.add(Ataque("Garra metal", tipoAcero,60))
            listaAtaques.add(Ataque("Hidropulso", tipoAgua,70))
            listaAtaques.add(Ataque("Puño fuego", tipoFuego,70))
            listaAtaques.add(Ataque("Latigazo", tipoPlanta,65))
            listaAtaques.add(Ataque("Fuerza equina", tipoTierra,90))
            listaAtaques.add(Ataque("Avalancha", tipoRoca,75))
            listaAtaques.add(Ataque("Rayo", tipoElectrico,90))
            listaAtaques.add(Ataque("Cabeza de hierro", tipoAcero,80))
            listaAtaques.add(Ataque("Terremoto", tipoTierra,100))
        }
    }
}