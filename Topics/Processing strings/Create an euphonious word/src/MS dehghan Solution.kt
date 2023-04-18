fun main() {
    val word = readLine()!!.trim()
    var sum = word.split(Regex("[aeiouy]+")).filter { it.length > 2 }.map { (it.length - 1) / 2 }.sum()
    sum += word.split(Regex("[^aeiouy]+")).filter { it.length > 2 }.map { (it.length - 1) / 2 }.sum()
    println(sum)
}