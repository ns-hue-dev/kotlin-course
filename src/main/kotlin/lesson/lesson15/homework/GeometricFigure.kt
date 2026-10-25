package lesson.lesson15.homework

// Базовый класс
open class GeometricFigure(val color: String) {
    open fun info() {
        println("Геометрическая фигура. Цвет: $color")
    }
}

// Многоугольник
open class Polygon(
    color: String,
    val sides: Int
) : GeometricFigure(color) {
    override fun info() {
        println("Многоугольник. Сторон: $sides, цвет: $color")
    }
}

// Круг
class Circle(
    color: String,
    val radius: Double
) : GeometricFigure(color) {
    override fun info() {
        println("Круг. Радиус: $radius, цвет: $color")
    }
}

// Треугольник
class Triangle(color: String) : Polygon(color, 3)

// Четырехугольник
class Quadrilateral(color: String) : Polygon(color, 4)

fun main() {
    val circle = Circle("Красный", 5.0)
    val triangle = Triangle("Синий")
    val quadrilateral = Quadrilateral("Зеленый")

    circle.info()
    triangle.info()
    quadrilateral.info()
}