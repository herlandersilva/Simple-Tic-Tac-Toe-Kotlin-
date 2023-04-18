package tictactoe

enum class TicTacToeMove(val state: Char, val message: String) {
    PLAYER_1_WIN('X', "X wins"),
    PLAYER_2_WIN('O', "O wins"),
    GAME_DRAW('D', "Draw"),
    GAME_NOT_ENDED('G', "Game not finished");
}