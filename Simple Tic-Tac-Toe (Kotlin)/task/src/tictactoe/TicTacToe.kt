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

    fun checkWinner(): Boolean {
        return try {
            when (val check = board.checkBoard(MOVE_PLAYER_1, MOVE_PLAYER_2)) {
                TicTacToeMove.PLAYER_1_WIN,
                TicTacToeMove.PLAYER_2_WIN,
                TicTacToeMove.GAME_DRAW -> {
                    check.message.let(::println)
                    true
                }

                else -> false
            }
        } catch (e: IllegalMovesException) {
            e.message.let(::println)
            true
        }
    }

    fun makeMove() {
        var makeMove = false
        var (first, second) = Pair(0, 0)
        do {
            try {
                val list = Util.readln().trim().split("\\s+".toRegex()).map (String::toInt)
                first = list.first()
                second = list.last()
            } catch (_: NumberFormatException) {
                "You should enter numbers!".let(::println)
                continue
            }

            if (first !in 1..board.lines || second !in 1..board.cols) {
                "Coordinates should be from 1 to %d!".format(cols).let(::println)
                continue
            }

            makeMove = if (!board.`Check if its free to play`(first - 1, second - 1)) {
                "This cell is occupied! Choose another one!".let(::println)
                false
            } else {
                board.playing(first - 1, second - 1 , board.`Check next player to make a move`())
                true
            }

        } while (!makeMove)
    }
}