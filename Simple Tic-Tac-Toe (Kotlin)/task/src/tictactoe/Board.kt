package tictactoe

import kotlin.math.abs

const val CELL_EMPTY = ' '

const val BORDER_HORIZONTAL = "-"
const val BORDER_VERTICAL = "|"

data class Board(val lines: Int, val cols: Int = lines) {
    val board: MutableList<MutableList<Char>> = emptyList<MutableList<Char>>().toMutableList()
    override fun toString(): String {
        val drawing = StringBuilder()
        drawing.appendLine(BORDER_HORIZONTAL.repeat(cols + 6))
        this.board.forEach { it ->
            drawing.appendLine(
                it.joinToString(
                    prefix = BORDER_VERTICAL.padEnd(2, CELL_EMPTY),
                    postfix = BORDER_VERTICAL.padStart(2, CELL_EMPTY),
                    separator = " ",
                    transform = { replaceEmptyCells(it) }
                )
            )
        }
        drawing.appendLine(BORDER_HORIZONTAL.repeat(cols + 6))

        return drawing.toString()
    }

    fun draw() {
        toString().let(::print)
    }

    fun setMove(line: Int, col: Int, play: Char) {
        board[line][col] = play
    }

    fun setBoard(moves: List<List<Char>>) {
        var _moves: MutableList<MutableList<Char>> = mutableListOf()
        moves.forEach { _moves.add(it.toMutableList()) }
        board.addAll(_moves)
    }

    fun checkBoard(player1: Char, player2: Char): TicTacToeMove {
        var numMovesOfPlayer1 = 0
        var numMovesOfPlayer2 = 0
        board.forEach {
            numMovesOfPlayer1 += it.count { move -> move == player1 }
            numMovesOfPlayer2 += it.count { move -> move == player2 }
        }

        if (abs(numMovesOfPlayer2 - numMovesOfPlayer1) > 1) throw IllegalMovesException()

        val wins1: Boolean = checkWinner(player1)
        val wins2: Boolean = checkWinner(player2)
        if (wins1 && wins2) throw IllegalMovesException()


        return if (wins1) TicTacToeMove.X_WIN
            else
                if (wins2) TicTacToeMove.O_WIN
                else
                    if (numMovesOfPlayer1 + numMovesOfPlayer2 == lines * cols) TicTacToeMove.DRAW
                    else TicTacToeMove.NOT_ENDED
    }

    private fun replaceEmptyCells(_move: Char): CharSequence {
        return _move.toString().replace(PLAYER_EMPTY, CELL_EMPTY)
    }

    private fun checkWinner(player: Char): Boolean {
        val size = board.size
        val rowWin = (0 until size).any { row -> board[row].all { it == player } }
        val colWin = (0 until size).any { col -> board.all { it[col] == player } }
        val diagWin = (0 until size).all { board[it][it] == player } || (0 until size).all { board[it][size - it - 1] == player }
        return rowWin || colWin || diagWin
    }


}
