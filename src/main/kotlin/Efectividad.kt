package org.practicatrim2
/**
 * Enumeración que representa los niveles de efectividad de un ataque.
 * @property valor El valor de efectividad del ataque.
 */
enum class Efectividad(val valor: Double) {
    SIN_EFECTO(0.0),      // No hay efecto
    POCO_EFECTIVO(0.5),   // Efecto poco efectivo
    NORMAL(1.0),          // Efectividad normal
    MUY_EFECTIVO(2.0)     // Muy efectivo
}