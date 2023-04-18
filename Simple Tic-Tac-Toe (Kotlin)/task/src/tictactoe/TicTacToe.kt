package tictactoe

const val MOVE_PLAYER_1 = 'X'
const val MOVE_PLAYER_2 = 'O'
const val MOVE_NOT_PLAY_YET = '_'

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
            board.checkBoard(MOVE_PLAYER_1, MOVE_PLAYER_2).message.let(::println)
        } catch (e: IllegalMovesException) {
            e.message.let(::println)
        }
    }
}