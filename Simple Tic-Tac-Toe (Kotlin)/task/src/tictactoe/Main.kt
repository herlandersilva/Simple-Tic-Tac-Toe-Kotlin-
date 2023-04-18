package tictactoe

fun main() {
    Util.enableToSend()

    val ticTacToe = TicTacToe(3)
    ticTacToe.fillBoard(Util.readln().toCharArray())
    ticTacToe.drawTheBoard()
    ticTacToe.checkWinner()
}