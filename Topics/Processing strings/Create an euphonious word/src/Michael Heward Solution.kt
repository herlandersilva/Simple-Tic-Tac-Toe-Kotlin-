fun main() {
    val word = readLine()!!
    val regex = Regex("([aeiouy]{3,}|[^aeiouy]{3,})")
    val ss = regex.findAll(word).map { (it.groupValues[0].length - 1) / 2 }.sum()

    println("$ss ")

}