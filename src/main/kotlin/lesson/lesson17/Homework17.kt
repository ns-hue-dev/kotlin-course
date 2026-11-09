package lesson.lesson17


class GameMachine(
    val color: String,
    val model: String,
    val owner: String,
    val supportPhone: String,
    val sessionPrice: Double,
    private val pinCode: String
) {
    // Состояние автомата
    var isPoweredOn: Boolean = false
        private set

    var isOsLoaded: Boolean = false
        private set

    var hasJoystick: Boolean = true

    var isSessionPaid: Boolean = false
        private set

    var balance: Double = 0.0
        private set

    // Установленные игры
    private val installedGames = mutableListOf<String>()

    // Включить автомат
    fun turnOn(): Boolean {
        if (isPoweredOn) return false

        isPoweredOn = true
        println("Автомат включен")
        return true
    }

    // Выключить автомат
    fun turnOff(): Boolean {
        if (!isPoweredOn) return false

        isOsLoaded = false
        isSessionPaid = false
        isPoweredOn = false

        println("Автомат выключен")
        return true
    }

    // Загрузить операционную систему
    fun loadOS(): Boolean {
        if (!isPoweredOn) return false

        isOsLoaded = true
        println("ОС загружена")
        return true
    }

    // Завершить работу ОС
    fun shutdownOS(): Boolean {
        if (!isOsLoaded) return false

        isOsLoaded = false
        isSessionPaid = false

        println("Работа ОС завершена")
        return true
    }

    // Показать список игр
    fun showGames(): List<String> {
        println("Установленные игры:")

        for (game in installedGames) {
            println(game)
        }

        return installedGames.toList()
    }

    // Добавить игру
    fun installGame(game: String): Boolean {
        if (game.isBlank() || game in installedGames) {
            return false
        }

        installedGames.add(game)
        return true
    }

    // Включить игру
    fun startGame(game: String): Boolean {
        if (!isPoweredOn || !isOsLoaded) return false
        if (!hasJoystick || !isSessionPaid) return false
        if (game !in installedGames) return false

        println("Игра $game запущена")
        return true
    }

    // Оплатить игровой сеанс
    fun paySession(amount: Double): Boolean {
        if (!isPoweredOn || !isOsLoaded) return false
        if (isSessionPaid || amount < sessionPrice) return false

        balance += amount
        isSessionPaid = true

        println("Игровой сеанс оплачен")
        return true
    }

    // Забрать наличные с помощью PIN-кода
    fun withdrawCash(pin: String): Double {
        if (pin != pinCode) {
            println("Неверный PIN-код")
            return 0.0
        }

        val cash = balance
        balance = 0.0

        println("Выдано наличных: $cash")
        return cash
    }

    // Открыть сейф и выдать наличные
    fun openSafeAndWithdraw(pin: String): Double {
        return withdrawCash(pin)
    }
}



abstract class BaseClass(
    // 1. Это поле доступно в main() для чтения из класса ChildrenClass,
    // потому что параметр объявлен с модификатором val и без private.
    private val privateVal: String,
    // 2. Это поле недоступно в main(), потому что protected
    // разрешает доступ только внутри класса и его наследников.
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"

    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate()
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. Функция не может быть публичной, потому что возвращает
    // protected-класс, который недоступен снаружи иерархии.
    protected open fun getProtectedClass() = ProtectedClass()

    protected fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. generate() является open и переопределяется в наследнике.
    // getAll() вызывает переопределённую версию через полиморфизм.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. Функция не может быть публичной или protected,
    // потому что возвращает private-класс.
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,

    // 10. Аргумент доступен в main(), потому что объявлен val.
    // Он становится публичным свойством ChildrenClass.
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // 11. getAll() доступен в main(), потому что унаследован
    // как публичный метод BaseClass.

    // 12. Выводится текст из BaseClass, потому что printText()
    // вызывает privatePrint() родителя.
    // Метод privatePrint() в ChildrenClass — новый метод,
    // а не переопределение: private-методы не наследуются.

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // 4. Изменение publicField через наследника.
    // Сеттер BaseClass пропускает только строки короче 3 символов.
    // Поэтому напрямую записать "Антонио Бандерас" нельзя.
    // Это ограничение невозможно обойти корректно,
    // не изменяя BaseClass.

    fun changePublicField(value: String) {
        publicField = value
    }

    // 5. Изменение protectedField через публичный сеттер.
    fun changeProtectedField(value: String) {
        protectedField = value
    }

    // 6. privateField родителя недоступен наследнику.
    // Без изменения BaseClass нельзя добавить сеттер
    // именно для этого поля.
    // Можно создать отдельное поле наследника,
    // но оно не изменит privateField в getAll().

    // Проверка собственного privatePrint()
    fun printChildText() {
        privatePrint()
    }
}

fun main() {
    val child = ChildrenClass(
        privateVal = "1",
        protectedVal = "2",
        publicVal = "3"
    )

    println("=== Начальное состояние ===")
    println(child.getAll())

    println("\n=== Задание 3 и 4 ===")
    child.changePublicField("Антонио Бандерас")
    println("После длинного значения:")
    println(child.publicField)

    child.changePublicField("AB")
    println("После короткого значения:")
    println(child.publicField)

    println("\n=== Задание 5 ===")
    child.changeProtectedField("Новое значение")
    println(child.getAll())

    println("\n=== Задание 6 ===")
    println("privateField нельзя изменить без правки BaseClass")

    println("\n=== Задание 8 ===")
    println(child.generate())

    println("\n=== Задание 12 ===")
    child.printText()
    child.printChildText()

    println("\n=== Итоговое состояние ===")
    println(child.getAll())
}
