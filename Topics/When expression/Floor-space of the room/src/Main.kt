import kotlin.math.pow
import kotlin.math.sqrt

const val PI = 3.14
fun main() = when (readln()) {
    "triangle" -> areaOfTriangle(readln().toDouble(), readln().toDouble(), readln().toDouble())
    "rectangle" -> areaOfRectangle(readln().toDouble(), readln().toDouble())
    "circle" -> areOfCircle(readln().toDouble())
    else -> throw IllegalArgumentException("Shape not supported!")
}.let(::println)

fun areaOfTriangle(a: Double, b: Double, c: Double): Double =
    ((a + b + c) / 2).let { s -> sqrt(s * (s - a) * (s - b) * (s - c)) }

fun areaOfRectangle(a: Double, b: Double): Double = a * b

fun areOfCircle(r: Double): Double = PI * r.pow(2)