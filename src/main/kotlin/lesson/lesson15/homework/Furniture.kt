package lesson.lesson15.homework

// Базовый класс
open class Furniture(val material: String) {
    open fun info() {
        println("Мебель. Материал: $material")
    }
}

// Стол
open class Table(
    material: String,
    val legs: Int
) : Furniture(material) {
    override fun info() {
        println("Стол. Материал: $material, ножек: $legs")
    }
}

// Стул
open class Chair(
    material: String,
    val hasBackrest: Boolean
) : Furniture(material) {
    override fun info() {
        println("Стул. Материал: $material, спинка: $hasBackrest")
    }
}

// Письменный стол
class WritingDesk(
    material: String,
    legs: Int,
    val drawers: Int
) : Table(material, legs) {
    override fun info() {
        println("Письменный стол. Ящиков: $drawers")
    }
}

// Обеденный стол
class DiningTable(
    material: String,
    legs: Int,
    val seats: Int
) : Table(material, legs) {
    override fun info() {
        println("Обеденный стол. Мест: $seats")
    }
}

// Офисный стул
class OfficeChair(
    material: String,
    hasBackrest: Boolean,
    val wheels: Int
) : Chair(material, hasBackrest) {
    override fun info() {
        println("Офисный стул. Колес: $wheels")
    }
}

fun main() {
    val desk = WritingDesk("Дерево", 4, 3)
    val table = DiningTable("Дерево", 4, 6)
    val chair = OfficeChair("Пластик", true, 5)

    desk.info()
    table.info()
    chair.info()
}