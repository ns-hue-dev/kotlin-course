
package lesson.lesson22

// Задание 1 — NullPointerException
fun task1() {
    val text: String? = null
    println(text!!.length)
}

// Задание 2 — IndexOutOfBoundsException
fun task2() {
    val numbers = listOf(1, 2, 3)
    println(numbers[10])
}

// Задание 3 — ClassCastException
fun task3() {
    val value: Any = "Hello"
    val number = value as Int
    println(number)
}

// Задание 4 — IllegalArgumentException
fun task4() {
    require(5 > 10) {
        "Некорректный аргумент"
    }
}

// Задание 5 — NumberFormatException
fun task5() {
    val number = "abc".toInt()
    println(number)
}

// Задание 6 — IllegalStateException
fun task6() {
    check(false) {
        "Недопустимое состояние"
    }
}

// Задание 7 — OutOfMemoryError
// Опасно: запуск может исчерпать память JVM.
fun task7() {
    val data = mutableListOf<ByteArray>()

    while (true) {
        data.add(ByteArray(10_000_000))
    }
}

// Задание 8 — StackOverflowError
// Опасно: бесконечная рекурсия.
fun task8() {
    task8()
}

// Задание 9 — Обработка исключений
fun task9() {
    try {
        task1()
    } catch (e: NullPointerException) {
        println("NullPointerException: ${e.message}")
    }

    try {
        task2()
    } catch (e: IndexOutOfBoundsException) {
        println("IndexOutOfBoundsException: ${e.message}")
    }

    try {
        task3()
    } catch (e: ClassCastException) {
        println("ClassCastException: ${e.message}")
    }

    try {
        task4()
    } catch (e: IllegalArgumentException) {
        println("IllegalArgumentException: ${e.message}")
    }

    try {
        task5()
    } catch (e: NumberFormatException) {
        println("NumberFormatException: ${e.message}")
    }

    try {
        task6()
    } catch (e: IllegalStateException) {
        println("IllegalStateException: ${e.message}")
    }

    // Демонстрация обработки OutOfMemoryError.
    // Запускать только отдельно.
    /*
    try {
        task7()
    } catch (e: OutOfMemoryError) {
        println("OutOfMemoryError")
    }
    */

    // Демонстрация обработки StackOverflowError.
    // Запускать только отдельно.
    /*
    try {
        task8()
    } catch (e: StackOverflowError) {
        println("StackOverflowError")
    }
    */
}

// Задание 10 — Проверка nullable Any
fun task10(value: Any?) {
    try {
        // 1. NullPointerException
        val notNull = value!!

        // 2. IndexOutOfBoundsException
        if (notNull is List<*>) {
            println(notNull[10])
        }

        // 3. ClassCastException
        if (notNull is String && notNull == "cast") {
            val number = notNull as Any as Int
            println(number)
        }

        // 4. IllegalArgumentException
        if (notNull is Int) {
            require(notNull > 0) {
                "Число должно быть положительным"
            }
        }

        // 5. NumberFormatException
        if (notNull is String && notNull != "cast") {
            val number = notNull.toInt()
            println(number)
        }

        // 6. IllegalStateException
        if (notNull is Int) {
            check(notNull < 100) {
                "Число должно быть меньше 100"
            }
        }

        println("Переданный аргумент фантастически хорош!")

    } catch (e: Throwable) {
        when (e) {
            is NullPointerException ->
                println("NullPointerException")

            is IndexOutOfBoundsException ->
                println("IndexOutOfBoundsException")

            is ClassCastException ->
                println("ClassCastException")

            is NumberFormatException ->
                println("NumberFormatException")

            is IllegalArgumentException ->
                println("IllegalArgumentException")

            is IllegalStateException ->
                println("IllegalStateException")

            else ->
                println("Другая ошибка: ${e.message}")
        }
    }
}

// Задание 11 — Собственное исключение
class MyAssertionException(
    message: String
) : AssertionError(message)

fun task11() {
    try {
        throw MyAssertionException(
            "Моя собственная ошибка"
        )
    } catch (e: MyAssertionException) {
        println("Перехвачено исключение: ${e.message}")
    }
}

// Задание 12 — Собственное RuntimeException
class MyRuntimeException(
    cause: IndexOutOfBoundsException
) : RuntimeException(
    "Ошибка индекса",
    cause
)

fun task12() {
    try {
        val numbers = listOf(1, 2, 3)
        println(numbers[10])

    } catch (e: IndexOutOfBoundsException) {
        println("Перехвачена ошибка: ${e.message}")

        try {
            throw MyRuntimeException(e)

        } catch (custom: MyRuntimeException) {
            println("Моё исключение: ${custom.message}")
            println("Причина: ${custom.cause}")
        }
    }
}

// Главная функция
fun main() {

    println("===== ЗАДАНИЕ 9 =====")
    task9()

    println("\n===== ЗАДАНИЕ 10 =====")
    task10(null)
    task10(listOf(1, 2, 3))
    task10("cast")
    task10(-5)
    task10("abc")
    task10(150)
    task10(10)

    println("\n===== ЗАДАНИЕ 11 =====")
    task11()

    println("\n===== ЗАДАНИЕ 12 =====")
    task12()
}
