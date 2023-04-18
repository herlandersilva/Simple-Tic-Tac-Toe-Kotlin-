fun main() {
    val studentsMarks = mutableMapOf<String, Int>()

    var name = readln()
    while (!name.equals("stop", true)) {
        studentsMarks.putIfAbsent(name, readln().toInt())
        name = readln()
    }

    studentsMarks.let(::println)
}