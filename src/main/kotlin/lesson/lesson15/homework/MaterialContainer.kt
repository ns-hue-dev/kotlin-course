package lesson.lesson15.homework

abstract class MaterialContainer {
    protected val materials = mutableListOf<String>()

    abstract fun addMaterial(material: String)

    fun showMaterials() {
        println(materials)
    }
}

class BottomContainer : MaterialContainer() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }
}

fun main() {
    val container = BottomContainer()

    container.addMaterial("Первый")
    container.addMaterial("Второй")
    container.addMaterial("Третий")

    container.showMaterials()
}