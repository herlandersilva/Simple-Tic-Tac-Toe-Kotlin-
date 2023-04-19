fun main() = List(readln().toInt()) { readln().toInt() }
    .windowed(3)
    .count { it[0].inc() == it[1] && it[1].inc() == it[2] }
    .let(::println)