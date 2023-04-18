fun main() = mutableMapOf<String, Int>().apply {
    while (true) this.putIfAbsent(readln().takeIf { it != "stop" } ?: break, readln().toInt())
}.let(::print)