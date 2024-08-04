package leet.code.medium

import leet.code.Solution

class P74SearchA2DMatrix : Solution {

    override fun test() {
        println(
            searchMatrix(
                arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 60),
                ), 35
            )
        )
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        var col = matrix[0].size - 1

        while (row < matrix.size && col > -1) {
            val element = matrix[row][col]
            if (element == target) return true
            if (target > element) row++
            else col--
        }

        return false
    }
}
