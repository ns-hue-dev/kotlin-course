package lesson.lesson18


import java.io.InputStream

// ========================================
// ИНТЕРФЕЙСЫ ИЗ УСЛОВИЯ
// ========================================

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensorValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun setLight()
    fun completeLightEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// ========================================
// ЗАДАНИЕ 1
// Абстрактные классы устройств
// ========================================

abstract class Refrigerator :
    Powerable,
    Openable,
    TemperatureRegulatable

abstract class WashingMachine :
    Powerable,
    WaterConnection,
    Drainable,
    Timable,
    Programmable

abstract class SmartLamp :
    Powerable,
    LightEmitting,
    Programmable

abstract class ElectronicWatch :
    BatteryOperated,
    Timable,
    LightEmitting

abstract class RobotVacuum :
    Powerable,
    Rechargeable,
    Movable,
    Cleanable,
    Programmable

abstract class MechanicalWatch :
    Mechanical

abstract class Flashlight :
    Powerable,
    BatteryOperated,
    LightEmitting

abstract class CoffeeMachine :
    Powerable,
    WaterContainer,
    TemperatureRegulatable,
    Programmable

abstract class SmartSpeaker :
    Powerable,
    SoundEmitting,
    Programmable

// ========================================
// ЗАДАНИЕ 2
// Абстрактный класс включаемого устройства
// ========================================

abstract class SwitchableDevice : Powerable {

    protected var isOn = false

    override fun powerOn() {
        isOn = true
        println("Устройство включено")
    }

    override fun powerOff() {
        isOn = false
        println("Устройство выключено")
    }
}

// ========================================
// ЗАДАНИЕ 3
// Абстрактный класс программируемого устройства
// ========================================

abstract class ProgrammableDevice :
    SwitchableDevice(),
    Programmable {

    protected var action = ""

    override fun programAction(action: String) {
        this.action = action
        println("Программа установлена: $action")
    }

    override fun execute() {
        if (!isOn) {
            println("Сначала включите устройство")
            return
        }

        if (action.isBlank()) {
            println("Программа не установлена")
        } else {
            println("Выполняется программа: $action")
        }
    }
}

// ========================================
// ЗАДАНИЕ 4
// Температура и открывание
// ========================================

abstract class TemperatureOpenableDevice :
    ProgrammableDevice(),
    TemperatureRegulatable,
    Openable {

    override val maxTemperature = 100

    protected var currentTemperature = 20
    protected var isOpen = false

    override fun setTemperature(temp: Int) {
        if (temp in 0..maxTemperature) {
            currentTemperature = temp
            println("Температура установлена: $temp")
        } else {
            println("Недопустимая температура")
        }
    }

    override fun open() {
        isOpen = true
        println("Устройство открыто")
    }

    override fun close() {
        isOpen = false
        println("Устройство закрыто")
    }
}

// ========================================
// ЗАДАНИЕ 5
// Конкретные классы устройств
// ========================================

// Холодильник
class Fridge : TemperatureOpenableDevice() {

    override val maxTemperature = 10

    override fun setTemperature(temp: Int) {
        if (temp in -25..maxTemperature) {
            currentTemperature = temp
            println("Температура холодильника: $temp °C")
        } else {
            println("Недопустимая температура холодильника")
        }
    }
}

// Умная духовка
class SmartOven : TemperatureOpenableDevice() {

    override val maxTemperature = 250

    override fun setTemperature(temp: Int) {
        if (temp in 0..maxTemperature) {
            currentTemperature = temp
            println("Температура духовки: $temp °C")
        } else {
            println("Недопустимая температура духовки")
        }
    }
}

// ========================================
// MAIN — ПРОВЕРКА ВСЕХ МЕТОДОВ
// ========================================

fun main() {

    println("=== ХОЛОДИЛЬНИК ===")

    val fridge = Fridge()

    fridge.powerOn()
    fridge.open()
    fridge.close()
    fridge.setTemperature(4)
    fridge.programAction("Экономичный режим")
    fridge.execute()
    fridge.powerOff()

    println()

    println("=== УМНАЯ ДУХОВКА ===")

    val oven = SmartOven()

    oven.powerOn()
    oven.open()
    oven.close()
    oven.setTemperature(180)
    oven.programAction("Выпечка")
    oven.execute()
    oven.powerOff()
}
