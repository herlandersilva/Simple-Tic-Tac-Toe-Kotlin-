fun main() {
    val input = readLine()!!
    val pattern = "([aeiouy]{3,}|[bcdfghjklmnpqrstvwxz]{3,})"
    print(Regex(pattern).findAll(input).sumBy { (it.value.length - 1) / 2 })
}
