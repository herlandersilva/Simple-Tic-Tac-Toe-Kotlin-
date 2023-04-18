package tictactoe

fun main() {
    Util.enableToSend()

    with(TicTacToe(3)) {
        fillBoard(Util.readln().toCharArray())
        drawTheBoard()
        checkWinner()
    }
}