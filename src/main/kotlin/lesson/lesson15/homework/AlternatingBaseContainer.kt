package lesson.lesson15.homework

abstract class AlternatingBaseContainer {
    protected val materials = mutableListOf<String>()

    abstract fun addMaterial(material: String)

    fun showMaterials() {
        println(materials)
    }
}

class AlternatingContainer : AlternatingBaseContainer() {

    override fun addMaterial(material: String) {
        val newMaterials = mutableListOf<String>()
        newMaterials.add(material)

        var index = 0

        while (index < materials.size) {
            newMaterials.add(materials[index])
            index++

            if (index < materials.size) {
                newMaterials.add(material)
            }
        }

        materials.clear()
        materials.addAll(newMaterials)
    }

    fun addMaterials(newItems: List<String>) {
        for (item in newItems) {
            addMaterial(item)
        }
    }
}

fun main() {
    val container = AlternatingContainer()

    container.addMaterial("A")
    container.addMaterial("B")
    container.addMaterials(listOf("X", "Y"))

    container.showMaterials()
}