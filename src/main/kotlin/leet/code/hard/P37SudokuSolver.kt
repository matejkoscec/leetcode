package leet.code.hard

import leet.code.Solution

object P37SudokuSolver : Solution {

    override fun test() {
        val sudoku = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
        )

        solveSudoku(sudoku)
        sudoku.forEach { println(it.contentToString()) }
    }

    fun solveSudoku(board: Array<CharArray>) {
        solve(board)
    }

    private fun solve(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] != '.') {
                    continue
                }

                for (next in '1'..'9') {
                    if (!isValid(board, i, j, next)) {
                        continue
                    }
                    board[i][j] = next;
                    if (solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }

                return false
            }
        }

        return true
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int, char: Char): Boolean {
        for (i in 0..<9) {
            if (board[i][col] == char) {
                return false;
            }
            if (board[row][i] == char) {
                return false;
            }
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == char) {
                return false;
            }
        }

        return true
    }
}
