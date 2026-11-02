package lesson.lesson16.homework

class Square(val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}