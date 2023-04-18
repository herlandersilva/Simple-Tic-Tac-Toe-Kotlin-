package tictactoe

const val ILLEGAL_MOVES = "Impossible"

class IllegalMovesException(message: String = ILLEGAL_MOVES) : Exception(message) {}