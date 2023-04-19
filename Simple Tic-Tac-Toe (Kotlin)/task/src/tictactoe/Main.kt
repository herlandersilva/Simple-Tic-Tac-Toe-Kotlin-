package tictactoe

fun main() {
    Util.enableToSend()

    with(TicTacToe(3)) {
        fillBoard("_".repeat(9).toCharArray())
        drawTheBoard()
        while (!checkWinner()) {
            makeMove()
            drawTheBoard()
        }
    }
}