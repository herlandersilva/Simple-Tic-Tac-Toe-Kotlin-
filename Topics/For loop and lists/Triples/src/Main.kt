const val TRIPLES = 3
fun main() = generateSequence { readln().toInt() }
    .take(readln().toInt())
    .toList()
    .windowed(TRIPLES)
    .count { it.component3() == it.component1() + 2 && it.component3() == it.component2() + 1 }
    .let(::println)