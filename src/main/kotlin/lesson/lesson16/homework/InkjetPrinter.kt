package lesson.lesson16.homework

class InkjetPrinter : Printer() {

    private val colors = listOf(
        "\u001B[31m",
        "\u001B[32m",
        "\u001B[33m",
        "\u001B[34m",
        "\u001B[35m",
        "\u001B[36m"
    )

    private val backgrounds = listOf(
        "\u001B[47m",
        "\u001B[40m",
        "\u001B[43m",
        "\u001B[44m",
        "\u001B[45m",
        "\u001B[46m"
    )

    override fun print(text: String) {
        val words = text.split(" ")

        for (i in words.indices) {
            val color = colors[i % colors.size]
            val background = backgrounds[i % backgrounds.size]

            println("$color$background${words[i]}\u001B[0m")
        }
    }
}