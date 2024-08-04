package leet.code.medium

import leet.code.Solution

object P79WordSearch : Solution {

    override fun test() {
        println(
            exist(
                arrayOf(
                    "ABCE".toCharArray(),
                    "SFCS".toCharArray(),
                    "ADEE".toCharArray(),
                ), "ABCCED"
            )
        )
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size

        val visited = Array(m) { BooleanArray(n) }

        fun trace(i: Int, j: Int, index: Int): Boolean {
            if (index == word.length) {
                return true
            }

            if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || visited[i][j] || board[i][j] != word[index]) {
                return false
            }

            visited[i][j] = true

            if (trace(i + 1, j, index + 1) ||
                trace(i - 1, j, index + 1) ||
                trace(i, j + 1, index + 1) ||
                trace(i, j - 1, index + 1)
            ) {
                return true
            }

            visited[i][j] = false
            return false
        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (board[i][j] != word[0]) continue
                if (trace(i, j, 0)) {
                    return true
                }
            }
        }

        return false
    }
}
