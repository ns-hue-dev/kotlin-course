
package lessons.lesson14.homeworks

class Emotion(
    val type: String,
    val intensity: Int
) {
    fun express() {
        when (type.lowercase()) {
            "радость" -> {
                if (intensity >= 7) {
                    println("Огромная радость!")
                } else {
                    println("Небольшая радость.")
                }
            }
            "грусть" -> {
                if (intensity >= 7) {
                    println("Очень сильная грусть.")
                } else {
                    println("Немного грустно.")
                }
            }
            "злость" -> {
                if (intensity >= 7) {
                    println("Сильная злость!")
                } else {
                    println("Легкое раздражение.")
                }
            }
            else -> println("Эмоция: $type, интенсивность: $intensity")
        }
    }
}
