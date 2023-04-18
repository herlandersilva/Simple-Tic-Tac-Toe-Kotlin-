fun main() {
    val studentsMarks = generateSequence { readln() }
        .takeWhile { it != "stop" }
        .map { it to readln().toInt() }
        .distinctBy { it.first }
        .toMap()
    println(studentsMarks)
}