package tictactoe

data class Board(val lines: Int, val cols: Int = lines) {
    val boardData: MutableList<MutableList<Char>> = emptyList<MutableList<Char>>().toMutableList()
    override fun toString(): String {
        val board = StringBuilder()
            .appendLine("-".repeat(cols + 6))
        boardData.forEach { board.appendLine(it.joinToString(" ", "| ", " |")) }
        board.appendLine("-".repeat(cols + 6))

        return board.toString()
    }

    fun draw() {
        toString().let(::println)
    }

    fun setMove(line: Int, col: Int, play: Char) {
        boardData[line][col] = play
    }

    fun setBoard(moves: List<List<Char>>) {
        var _moves: MutableList<MutableList<Char>> = mutableListOf()
        moves.forEach { _moves.add(it.toMutableList()) }
        boardData.addAll(_moves)
    }
}
