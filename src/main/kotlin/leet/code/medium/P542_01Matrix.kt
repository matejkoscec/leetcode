package leet.code.medium

import leet.code.Solution
import kotlin.math.min

class P542_01Matrix : Solution {

    override fun test() {
        val res = updateMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1),
            )
        )
        println()
        res.forEach { println(it.contentToString()) }
    }

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val maxValue = mat.size + mat[0].size
        val distances = Array(mat.size) { IntArray(mat[0].size) { maxValue } }

        for (i in mat.indices) {
            for (j in mat[0].indices) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0
                } else {
                    val left = if (j - 1 < 0) maxValue else distances[i][j - 1] + 1
                    val up = if (i - 1 < 0) maxValue else distances[i - 1][j] + 1
                    distances[i][j] = min(left, up)
                }
            }
        }
        distances.forEach { println(it.contentToString()) }
        for (i in mat.indices.reversed()) {
            for (j in mat[0].indices.reversed()) {
                if (distances[i][j] == 0) {
                    continue
                }

                val right = if (j + 1 > mat[0].lastIndex) maxValue else distances[i][j + 1]
                val down = if (i + 1 > mat.lastIndex) maxValue else distances[i + 1][j]
                distances[i][j] = min(distances[i][j], min(right + 1, down + 1))
            }
        }

        return distances
    }
}