package org.practicatrim2
/**
 * Interfaz que define los métodos para proporcionar ataques y calcular efectividad.
 */
interface DarAtaques {
    /**
     * Obtiene la lista de ataques disponibles.
     * @return Una lista de objetos Ataque.
     */
    fun obtenerAtaques(): List<Ataque>
    /**
     * Calcula la efectividad del tipo de ataque especificado.
     * @param tipoAtaque El tipo de ataque a calcular.
     * @return La efectividad del tipo de ataque.
     */
    fun calcularEfectividad(tipoAtaque: Tipo): Efectividad
}