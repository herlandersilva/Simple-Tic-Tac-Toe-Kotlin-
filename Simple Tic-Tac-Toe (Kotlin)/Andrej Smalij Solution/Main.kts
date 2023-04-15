package tictactoe

class TicTacToe {
    companion object {
        const val ROWS = 3
        const val COLS = 3
        const val EMPTY_CELL = " "
        const val PLAYER1_SIGN = "X"
        const val PLAYER2_SIGN = "O"
    }

    private val board = MutableList(ROWS) {
        MutableList(COLS) { EMPTY_CELL }
    }

    fun makeTurn(row: Int, col: Int, sign: String) {
        board[row - 1][col - 1] = sign
    }

    fun getBoardStr(): String {
        val stringBuilder = StringBuilder()
        for (row in board) {
            stringBuilder.append(row.joinToString(EMPTY_CELL, postfix = "\n"))
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val ticTacToe = TicTacToe()

    // Imitating player
    for (i in 1..TicTacToe.ROWS) {
        for (j in 1..TicTacToe.COLS) {
            ticTacToe.makeTurn(i, j, if ((i * TicTacToe.ROWS + j) % 2 == 0) {
                TicTacToe.PLAYER1_SIGN
            } else {
                TicTacToe.PLAYER2_SIGN
            })
        }
    }

    println(ticTacToe.getBoardStr())
}