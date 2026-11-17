package lesson.lesson19

import kotlin.collections.iterator

// ========================================
// ЗАДАНИЕ 1
// Получение среднего элемента списка
// ========================================

fun <T> getMiddleElement(list: List<T>): T? {
    return if (list.size % 2 != 0) {
        list[list.size / 2]
    } else {
        null
    }
}

// ========================================
// ЗАДАНИЕ 2
// Класс для хранения элементов типа T
// ========================================

class ListHolder<T> {

    private val elements = mutableListOf<T>()

    fun addElement(element: T) {
        elements.add(element)
    }

    fun getElements(): List<T> {
        return elements.toList()
    }
}

// ========================================
// ЗАДАНИЕ 3
// Интерфейс Mapper с двумя дженериками
// ========================================

interface Mapper<T, R> {

    fun map(element: T): R

    fun mapList(elements: List<T>): List<R>
}

// ========================================
// ЗАДАНИЕ 4
// Преобразование строк в списки слов
// ========================================

class PhrasesToListOfStrings :
    Mapper<String, List<String>> {

    override fun map(element: String): List<String> {
        return element.split(" ")
    }

    override fun mapList(
        elements: List<String>
    ): List<List<String>> {

        val result = mutableListOf<List<String>>()

        for (element in elements) {
            result.add(map(element))
        }

        return result
    }
}

// ========================================
// ЗАДАНИЕ 5
// Обмен ключей и значений словаря
// ========================================

fun <K, V> transposition(
    map: Map<K, V>
): Map<V, K> {

    val result = mutableMapOf<V, K>()

    for ((key, value) in map) {
        result[value] = key
    }

    return result
}

// ========================================
// ЗАДАНИЕ 6
// Интерфейс Validator
// ========================================

interface Validator<T> {

    fun validate(element: T): Boolean
}

// ========================================
// ЗАДАНИЕ 7
// Проверка строки
// ========================================

class StringValidator : Validator<String?> {

    override fun validate(element: String?): Boolean {
        return !element.isNullOrBlank()
    }
}

// ========================================
// ЗАДАНИЕ 8
// Проверка числа на чётность
// ========================================

class OddValidator : Validator<Int> {

    override fun validate(element: Int): Boolean {
        return element % 2 == 0
    }
}

// ========================================
// ЗАДАНИЕ 9
// Проверка списка чисел
// ========================================

class ListValidator<T : Number> :
    Validator<List<T?>> {

    override fun validate(element: List<T?>): Boolean {

        for (number in element) {

            if (number == null) {
                return false
            }

            if (number.toDouble() == 0.0) {
                return false
            }
        }

        return true
    }
}

// ========================================
// MAIN
// Проверка всех заданий
// ========================================

fun main() {

    // Задание 1
    println("===== ЗАДАНИЕ 1 =====")

    val numbers1 = listOf(1, 2, 3, 4, 5)
    val numbers2 = listOf(1, 2, 3, 4)

    println(getMiddleElement(numbers1))
    println(getMiddleElement(numbers2))


    // Задание 2
    println("\n===== ЗАДАНИЕ 2 =====")

    val holder = ListHolder<String>()

    holder.addElement("Kotlin")
    holder.addElement("Java")
    holder.addElement("Python")

    println(holder.getElements())


    // Задание 3 и 4
    println("\n===== ЗАДАНИЯ 3 И 4 =====")

    val mapper = PhrasesToListOfStrings()

    println(mapper.map("Kotlin лучший язык"))

    val phrases = listOf(
        "Hello World",
        "Kotlin Java Python",
        "Изучаем дженерики"
    )

    println(mapper.mapList(phrases))


    // Задание 5
    println("\n===== ЗАДАНИЕ 5 =====")

    val originalMap = mapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )

    val reversedMap = transposition(originalMap)

    println(reversedMap)


    // Задание 6 и 7
    println("\n===== ЗАДАНИЯ 6 И 7 =====")

    val stringValidator = StringValidator()

    println(stringValidator.validate("Hello"))
    println(stringValidator.validate(""))
    println(stringValidator.validate("   "))
    println(stringValidator.validate(null))


    // Задание 8
    println("\n===== ЗАДАНИЕ 8 =====")

    val oddValidator = OddValidator()

    println(oddValidator.validate(4))
    println(oddValidator.validate(7))
    println(oddValidator.validate(10))


    // Задание 9
    println("\n===== ЗАДАНИЕ 9 =====")

    val listValidator = ListValidator<Int>()

    val list1 = listOf<Int?>(1, 2, 3)
    val list2 = listOf<Int?>(1, null, 3)
    val list3 = listOf<Int?>(1, 0, 3)

    println(listValidator.validate(list1))
    println(listValidator.validate(list2))
    println(listValidator.validate(list3))

    val doubleValidator = ListValidator<Double>()

    println(
        doubleValidator.validate(
            listOf<Double?>(1.5, 2.5, 3.5)
        )
    )

    println(
        doubleValidator.validate(
            listOf<Double?>(1.5, 0.0, 3.5)
        )
    )
}
