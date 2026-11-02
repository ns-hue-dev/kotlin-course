package lesson.lesson16.homework

import kotlin.math.sin

class Triangle(
    val sideA: Double,
    val sideB: Double,
    val angle: Double
) : Shape() {

    override fun area(): Double {
        val radians = Math.toRadians(angle)
        return 0.5 * sideA * sideB * sin(radians)
    }
}