
package lessons.lesson14.homeworks

object Moon {
    var isVisible: Boolean = true
    var phase: String = "Full Moon"

    fun showPhase() {
        println("Текущая фаза Луны: $phase")

        if (isVisible) {
            println("Луна сейчас видна.")
        } else {
            println("Луна сейчас не видна.")
        }
    }
}
