package lesson.lesson15.homework

// Базовый класс
open class EducationalInstitution(
    val name: String,
    val address: String
) {
    open fun info() {
        println("Учебное заведение: $name, адрес: $address")
    }
}

// Школа
open class School(
    name: String,
    address: String,
    val students: Int
) : EducationalInstitution(name, address) {
    override fun info() {
        println("Школа: $name, учеников: $students")
    }
}

// Университет
class University(
    name: String,
    address: String,
    val faculties: Int
) : EducationalInstitution(name, address) {
    override fun info() {
        println("Университет: $name, факультетов: $faculties")
    }
}

// Начальная школа
class PrimarySchool(
    name: String,
    address: String,
    students: Int,
    val classrooms: Int
) : School(name, address, students) {
    override fun info() {
        println("Начальная школа: $name, классов: $classrooms")
    }
}

// Старшая школа
class HighSchool(
    name: String,
    address: String,
    students: Int,
    val graduationClasses: Int
) : School(name, address, students) {
    override fun info() {
        println("Старшая школа: $name, выпускных классов: $graduationClasses")
    }
}

fun main() {
    val primary = PrimarySchool("Школа №1", "Москва", 500, 20)
    val high = HighSchool("Школа №2", "Москва", 600, 5)
    val university = University("МГУ", "Москва", 15)

    primary.info()
    high.info()
    university.info()
}