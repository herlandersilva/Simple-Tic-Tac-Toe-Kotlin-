fun main() = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    .windowed(3)
    .filter { it[0] + 1 == it[1] && it[1] + 1 == it[2] }
    .size
    .let(::println)