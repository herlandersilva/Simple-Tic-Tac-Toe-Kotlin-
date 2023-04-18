package tictactoe

const val PLAYER_X = 'X'
const val PLAYER_O = 'O'
const val PLAYER_EMPTY = '_'

class TicTacToe(val lines: Int, val cols: Int = lines) {
    private val board = Board(lines, cols)

    override fun toString(): String {
        return board.toString()
    }

    fun fillBoard(_moves: CharArray) {
        val moves = _moves.toMutableList().chunked(3)
        board.setBoard(moves)
    }

    fun drawTheBoard() = board.draw()

    fun checkWinner() {
        try {
            board.checkBoard(PLAYER_X, PLAYER_O).message.let(::println)
        } catch (e: IllegalMovesException) {
            e.message.let(::println)
        }
    }
}