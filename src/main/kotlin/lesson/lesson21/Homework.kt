package lesson.lesson21
// ЗАДАНИЕ 1
fun analyzeDataType(value: Any) {
    when (value) {
        is String -> println("Это строка: $value")
        is Number -> println("Это число: $value")
        is List<*> -> println(
            "Это список, количество элементов: ${value.size}"
        )
        is Map<*, *> -> println(
            "Это словарь, количество пар: ${value.size}"
        )
        else -> println("Неизвестный тип данных")
    }
}


// ЗАДАНИЕ 2
fun safeCastToList(value: Any): Int {
    val list = value as? List<*>
    return list?.size ?: -1
}


// ЗАДАНИЕ 3
fun getStringLengthOrZero(value: Any?): Int {
    val text = value as? String
    return text?.length ?: 0
}


// ЗАДАНИЕ 4
fun Any.toSquare(): Double {
    val number = when (this) {
        is Number -> this.toDouble()
        is String -> this.toDouble()
        else -> throw IllegalArgumentException(
            "Ожидалось число или строка с числом"
        )
    }

    return number * number
}


// ЗАДАНИЕ 5
fun sumIntOrDoubleValues(values: List<Any>): Double {
    var sum = 0.0

    for (value in values) {
        when (value) {
            is Int -> sum += value
            is Double -> sum += value
        }
    }

    return sum
}


// ЗАДАНИЕ 6
fun tryCastToListAndPrint(value: Any) {
    val list = value as? List<*>

    if (list == null) {
        println("Ошибка: переданный объект не является списком")
        return
    }

    for (element in list) {
        if (element is String) {
            println(element)
        } else {
            println(
                "Предупреждение: элемент '$element' не является строкой"
            )
        }
    }
}


