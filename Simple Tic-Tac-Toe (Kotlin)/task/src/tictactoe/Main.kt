package tictactoe

fun main() {
    Util.enableToSend()

    with(TicTacToe(3)) {
        fillBoard(Util.readln().take(9).toCharArray())
        drawTheBoard()
        makeMove()
        drawTheBoard()
    }
}