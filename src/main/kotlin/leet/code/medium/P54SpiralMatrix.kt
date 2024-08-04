package leet.code.medium

import leet.code.Solution

object P54SpiralMatrix : Solution {

    override fun test() {
        println(
            spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                )
            )
        )
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val rows = matrix.size
        val cols = matrix[0].size
        val n = rows * cols
        val list = ArrayList<Int>(n)

        var i = 0
        var j = 0
        var direction = 0 // 0 - RIGHT, 1 - DOWN, 2 - LEFT, 3 - UP
        repeat(n) {
            list.add(matrix[i][j])
            matrix[i][j] = Int.MIN_VALUE
            when (direction) {
                0 -> {
                    if (j == cols - 1 || matrix[i][j + 1] == Int.MIN_VALUE) {
                        direction = 1
                        i++
                    } else {
                        j++
                    }
                }
                1 -> {
                    if (i == rows - 1 || matrix[i + 1][j] == Int.MIN_VALUE) {
                        direction = 2
                        j--
                    } else {
                        i++
                    }
                }
                2 -> {
                    if (j == 0 || matrix[i][j - 1] == Int.MIN_VALUE) {
                        direction = 3
                        i--
                    } else {
                        j--
                    }
                }
                3 -> {
                    if (i == 0 || matrix[i - 1][j] == Int.MIN_VALUE) {
                        direction = 0
                        j++
                    } else {
                        i--
                    }
                }
            }
        }

        return list
    }
}
