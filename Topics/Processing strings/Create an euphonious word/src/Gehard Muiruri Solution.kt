fun main() {
    println(
        Regex("[aeiouy]{3,}|[^aeiouy]{3,}")
            .findAll(readLine()!!)
            .sumOf { matchResult -> (matchResult.value.length - 1) / 2 }
    )
}