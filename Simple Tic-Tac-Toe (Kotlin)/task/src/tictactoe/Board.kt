package tictactoe

import kotlin.math.abs

const val CELL_EMPTY = ' '

const val BORDER_HORIZONTAL = "-"
const val BORDER_VERTICAL = "|"

data class Board(val lines: Int, val cols: Int = lines) {
    val board: MutableList<MutableList<Char>> = emptyList<MutableList<Char>>().toMutableList()
    override fun toString(): String {
        val drawing = StringBuilder()
        drawing.appendLine(BORDER_HORIZONTAL.repeat(cols * 2 + 3))
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
        drawing.appendLine(BORDER_HORIZONTAL.repeat(cols * 2 + 3))

        return drawing.toString()
    }

    fun draw() {
        toString().let(::print)
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


        return if (wins1) TicTacToeMove.PLAYER_1_WIN
            else
                if (wins2) TicTacToeMove.PLAYER_2_WIN
                else
                    if (numMovesOfPlayer1 + numMovesOfPlayer2 == lines * cols) TicTacToeMove.GAME_DRAW
                    else TicTacToeMove.GAME_NOT_ENDED
    }

    fun `Check if its free to play`(cordLine: Int, cordCol: Int): Boolean = board[cordLine][cordCol] == MOVE_NOT_PLAY_YET

    fun `Check next player to make a move`(): Char {
        var numOfEmptyCells = 0
        board.forEach {
            numOfEmptyCells += it.count { move -> move == MOVE_NOT_PLAY_YET }
        }

        return if (numOfEmptyCells % 2 == 0) MOVE_PLAYER_2 else MOVE_PLAYER_1
    }

    fun playing(cordLine: Int, cordCol: Int, move: Char) {
        this.board[cordLine][cordCol] = move
    }

    private fun replaceEmptyCells(_move: Char): CharSequence {
        return _move.toString().replace(MOVE_NOT_PLAY_YET, CELL_EMPTY)
    }

    private fun checkWinner(player: Char): Boolean {
        val size = board.size
        val rowWin = (0 until size).any { row -> board[row].all { it == player } }
        val colWin = (0 until size).any { col -> board.all { it[col] == player } }
        val diagWin = (0 until size).all { board[it][it] == player } || (0 until size).all { board[it][size - it - 1] == player }
        return rowWin || colWin || diagWin
    }
}
