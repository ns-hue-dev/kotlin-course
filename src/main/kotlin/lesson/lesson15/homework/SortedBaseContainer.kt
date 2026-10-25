package lesson.lesson15.homework

abstract class SortedBaseContainer {
    protected val materials = mutableListOf<String>()

    abstract fun addMaterial(material: String)

    fun showMaterials() {
        println(materials)
    }
}

class SortedContainer : SortedBaseContainer() {

    override fun addMaterial(material: String) {
        materials.add(material)
        materials.sort()
    }
}

fun main() {
    val container = SortedContainer()

    container.addMaterial("Банан")
    container.addMaterial("Яблоко")
    container.addMaterial("Апельсин")

    container.showMaterials()
}