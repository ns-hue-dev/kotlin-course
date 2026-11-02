package lesson.lesson16.homework

class ShoppingCart {

    private val products = mutableMapOf<Int, Int>()

    // 1. Добавление одного товара
    fun addToCart(itemId: Int, amount: Int) {
        if (amount <= 0) return

        products[itemId] = (products[itemId] ?: 0) + amount
    }

    // 2. Добавление словаря товаров
    fun addToCart(items: Map<Int, Int>) {
        for ((itemId, amount) in items) {
            addToCart(itemId, amount)
        }
    }

    // 3. Добавление списка товаров
    fun addToCart(items: List<Int>) {
        for (itemId in items) {
            addToCart(itemId, 1)
        }
    }

    // Вывод корзины
    fun showCart() {
        println("Корзина товаров:")

        for ((id, amount) in products) {
            println("Товар $id: $amount шт.")
        }
    }

    // Итоговая информация
    fun showCartSummary() {
        println("Итоговая корзина:")

        val sortedProducts = products.toSortedMap()

        for ((id, amount) in sortedProducts) {
            println("Товар $id: $amount шт.")
        }

        val total = products.values.sum()

        println("Всего разных товаров: ${products.size}")
        println("Общее количество товаров: $total")
    }
}