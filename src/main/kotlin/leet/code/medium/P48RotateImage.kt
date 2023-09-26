package leet.code.medium

import leet.code.Solution

class P48RotateImage : Solution {

    override fun test() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
        rotate(matrix)
        matrix.forEach { println(it.contentToString()) }
    }

    fun rotate(matrix: Array<IntArray>) {
        for (diagonalIndex in 0..<matrix.size / 2) {
            for (i in diagonalIndex..<matrix.size - diagonalIndex - 1) {
                // temp = topLeft
                val temp = matrix[diagonalIndex][i]

                // topLeft = bottomLeft
                matrix[diagonalIndex][i] = matrix[matrix.size - i - 1][diagonalIndex]

                // bottomLeft = bottomRight
                matrix[matrix.size - i - 1][diagonalIndex] =
                    matrix[matrix.size - diagonalIndex - 1][matrix.size - i - 1]

                // bottomRight = topRight
                matrix[matrix.size - diagonalIndex - 1][matrix.size - i - 1] =
                    matrix[i][matrix.size - diagonalIndex - 1]

                // topRight = temp
                matrix[i][matrix.size - diagonalIndex - 1] = temp
            }
        }
    }
}
