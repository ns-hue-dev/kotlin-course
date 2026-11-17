package lesson.lesson20


import kotlin.math.absoluteValue

// ========================================
// ЗАДАНИЕ 1
// Первый и последний элементы массива
// ========================================

fun Array<Int>.getFirstAndLast(): Pair<Int?, Int?> {
    if (isEmpty()) {
        return Pair(null, null)
    }

    return Pair(first(), last())
}

// ========================================
// ЗАДАНИЕ 2
// Сортировка изменяемого списка
// ========================================

fun <T : Comparable<T>> MutableList<T>.sortList(
    ascending: Boolean
): List<T> {

    if (ascending) {
        sort()
    } else {
        sortDescending()
    }

    return toList()
}

// ========================================
// ЗАДАНИЕ 3
// Преобразование nullable словаря
// ========================================

fun <K, V> Map<K, List<V>?>?.transformMap(
    index: Int
): Map<String, V?>? {

    if (this == null) {
        return null
    }

    val result = mutableMapOf<String, V?>()

    for ((key, values) in this) {
        val newKey = key.toString()
        val newValue = values?.getOrNull(index)

        result[newKey] = newValue
    }

    return result
}

// ========================================
// ЗАДАНИЕ 4
// Сравнение чисел с допустимым отклонением
// ========================================

fun Number.within(
    other: Number,
    deviation: Number
): Boolean {

    val difference =
        (this.toDouble() - other.toDouble()).absoluteValue

    return difference <= deviation.toDouble()
}

// ========================================
// ЗАДАНИЕ 5
// Шифрование и дешифрование строки
// ========================================

fun String.encrypt(base: Int): String {

    require(base >= 0) {
        "Сдвиг не может быть отрицательным"
    }

    return map { char ->
        (char.code + base).toChar()
    }.joinToString("")
}

fun String.decrypt(base: Int): String {

    require(base >= 0) {
        "Сдвиг не может быть отрицательным"
    }

    return map { char ->
        (char.code - base).toChar()
    }.joinToString("")
}

// ========================================
// ЗАДАНИЕ 6
// Вывод строки вертикально с авторами
// ========================================

fun String.printVertical(
    users: List<String>
) {

    val text = uppercase()

    for (i in text.indices) {

        val author = if (i < users.size) {
            users[i]
        } else {
            "Неизвестный"
        }

        println("$author")
        println(text[i])
        println()
    }
}

// ========================================
// MAIN
// Проверка всех заданий
// ========================================

fun main() {

    // Задание 1
    println("===== ЗАДАНИЕ 1 =====")

    val numbers = arrayOf(10, 20, 30, 40, 50)
    val emptyArray = arrayOf<Int>()

    println(numbers.getFirstAndLast())
    println(emptyArray.getFirstAndLast())


    // Задание 2
    println("\n===== ЗАДАНИЕ 2 =====")

    val numbersList = mutableListOf(5, 2, 8, 1, 3)

    println(numbersList.sortList(true))
    println(numbersList.sortList(false))


    // Задание 3
    println("\n===== ЗАДАНИЕ 3 =====")

    val dictionary: Map<Int, List<String>?> = mapOf(
        1 to listOf("Apple", "Banana", "Cherry"),
        2 to listOf("Kotlin", "Java"),
        3 to null
    )

    println(dictionary.transformMap(1))
    println(dictionary.transformMap(5))


    // Задание 4
    println("\n===== ЗАДАНИЕ 4 =====")

    println(10.within(12, 2))
    println(10.within(15, 2))
    println(5.5.within(5.8, 0.5))
    println(100L.within(105L, 10))


    // Задание 5
    println("\n===== ЗАДАНИЕ 5 =====")

    val originalText = "Hello Kotlin!"
    val shift = 3

    val encrypted = originalText.encrypt(shift)
    val decrypted = encrypted.decrypt(shift)

    println("Исходная строка: $originalText")
    println("Зашифрованная: $encrypted")
    println("Расшифрованная: $decrypted")
    println("Совпадают: ${originalText == decrypted}")


    // Задание 6
    println("\n===== ЗАДАНИЕ 6 =====")

    val users = listOf(
        "Алексей",
        "Мария",
        "Иван",
        "Ольга",
        "Дмитрий"
    )

    "ПИДМА".printVertical(users)
}
