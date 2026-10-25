package lesson.lesson15.homework

abstract class MapBaseContainer {
    protected val materials = mutableListOf<String>()

    abstract fun addMaterial(material: String)

    fun showMaterials() {
        println(materials)
    }
}

class MapContainer : MapBaseContainer() {

    override fun addMaterial(material: String) {
        materials.add(material)
    }

    fun addMap(data: Map<String, String>) {
        val keys = data.keys.sortedDescending()
        val values = data.values.toList()

        val result = mutableListOf<String>()

        result.addAll(keys)
        result.addAll(materials)
        result.addAll(values)

        materials.clear()
        materials.addAll(result)
    }
}

fun main() {
    val container = MapContainer()

    container.addMaterial("Старый материал")

    container.addMap(
        mapOf(
            "A" to "Apple",
            "C" to "Cat",
            "B" to "Banana"
        )
    )

    container.showMaterials()
}