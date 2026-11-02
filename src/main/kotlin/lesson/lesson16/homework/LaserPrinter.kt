package lesson.lesson16.homework

class LaserPrinter : Printer() {

    override fun print(text: String) {
        val words = text.split(" ")

        for (word in words) {
            println("\u001B[30;47m$word\u001B[0m")
        }
    }
}