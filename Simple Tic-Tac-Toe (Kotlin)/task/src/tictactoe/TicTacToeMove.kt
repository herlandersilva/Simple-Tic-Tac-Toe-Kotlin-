package tictactoe

enum class TicTacToeMove(val state: Char, val message: String) {
    X_WIN('X', "X wins"),
    O_WIN('O', "O wins"),
    DRAW('D', "Draw"),
    NOT_ENDED('G', "Game not finished");


}