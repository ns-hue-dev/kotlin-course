
package lessons.lesson14.homeworks

class Concert(
    val band: String,
    val location: String,
    val price: Double,
    val capacity: Int
) {
    private var soldTickets: Int = 0

    fun details() {
        println("Группа: $band")
        println("Место проведения: $location")
        println("Цена билета: $price")
        println("Вместимость зала: $capacity")
        println("Продано билетов: $soldTickets")
    }

    fun buyTicket() {
        if (soldTickets < capacity) {
            soldTickets++
            println("Билет успешно куплен!")
        } else {
            println("Все билеты проданы!")
        }
    }
}
