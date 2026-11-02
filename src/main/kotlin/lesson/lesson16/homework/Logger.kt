package lesson.lesson16.homework

class Logger {

    private val reset = "\u001B[0m"
    private val yellow = "\u001B[33m"
    private val whiteOnRed = "\u001B[37;41m"

    // 1. Обычный вывод с INFO
    fun log(message: String) {
        println("INFO: $message")
    }

    // 2. Вывод с указанным уровнем
    fun log(level: String, message: String) {
        when (level.uppercase()) {
            "WARNING" -> println(
                "${yellow}WARNING: $message$reset"
            )

            "ERROR" -> println(
                "${whiteOnRed}ERROR: $message$reset"
            )

            "DEBUG" -> println("DEBUG: $message")

            else -> println("$level: $message")
        }
    }

    // 3. Вывод списка сообщений
    fun log(messages: List<String>) {
        for (message in messages) {
            log(message)
        }
    }

    // 4. Вывод ошибки Exception
    fun log(exception: Exception) {
        log("ERROR", exception.message ?: "Неизвестная ошибка")
    }
}