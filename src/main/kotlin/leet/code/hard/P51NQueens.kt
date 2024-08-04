package leet.code.hard

import leet.code.Solution

class P51NQueens : Solution {

    override fun test() {
        println(solveNQueens(4))
    }

    private val result = mutableListOf<List<String>>()

    fun solveNQueens(n: Int): List<List<String>> {
        val board = Array(n) { CharArray(n) { '.' } }

        track(board, n, 0)

        return result
    }

    private fun track(board: Array<CharArray>, n: Int, row: Int) {
        if (row == n) {
            result.add(board.map { it.joinToString("") })
            return
        }
        for (col in 0..<n) {
            if (qInCol(board, col) || qInDiagonal(board, row, col)) {
                continue
            }

            board[row][col] = 'Q'
            track(board, n, row + 1)
            board[row][col] = '.'
        }
    }

    private fun qInCol(board: Array<CharArray>, col: Int): Boolean = board.indices.any { i -> board[i][col] == 'Q' }

    private fun qInDiagonal(board: Array<CharArray>, row: Int, col: Int): Boolean {
        var i = row - 1
        var j = col - 1
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') {
                return true
            }
        }

        i = row - 1
        j = col + 1
        while (i >= 0 && j < board.size) {
            if (board[i--][j++] == 'Q') {
                return true
            }
        }

        return false
    }

    private fun Array<CharArray>.print() = forEach { println(it.contentToString()) }

    private fun print(vararg any: Any) = any.forEach(::println)
}
