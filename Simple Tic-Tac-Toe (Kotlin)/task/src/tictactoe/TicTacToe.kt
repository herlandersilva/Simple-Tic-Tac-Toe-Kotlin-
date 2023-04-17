package tictactoe

class TicTacToe(val lines: Int, val cols: Int = lines) {
    val board = Board(lines, cols)

    override fun toString(): String {
        return board.toString()
    }

    fun fillBoard(_moves: CharArray) {
        val moves = _moves.toMutableList().chunked(3)
        board.setBoard(moves)
    }
}