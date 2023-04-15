package tictactoe

fun main() {
    val board = mutableListOf(
        mutableListOf('X', 'O', 'X'),
        mutableListOf('O', 'X', 'O'),
        mutableListOf('X', 'X', 'O')
    ).forEach { line -> line.joinToString(" ").let(::println) }
}