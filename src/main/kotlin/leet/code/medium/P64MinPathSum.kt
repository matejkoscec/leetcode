package leet.code.medium

import leet.code.Solution
import kotlin.math.min

object P64MinPathSum : Solution {

    override fun test() {
        println(
            minPathSum(
                arrayOf(
                    intArrayOf(1, 3, 1),
                    intArrayOf(1, 5, 1),
                    intArrayOf(4, 2, 1),
                )
            )
        )
    }

    fun minPathSum(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val paths = Array(rows) { IntArray(cols) }

        paths[0][0] = grid[0][0]
        for (i in 1..<rows) paths[i][0] = grid[i][0] + paths[i - 1][0]
        for (j in 1..<cols) paths[0][j] = grid[0][j] + paths[0][j - 1]

        for (i in 1..<rows) {
            for (j in 1..<cols) {
                paths[i][j] = min(grid[i][j] + paths[i - 1][j], grid[i][j] + paths[i][j - 1])
            }
        }

        paths.forEach { println(it.contentToString()) }

        return paths[rows - 1][cols - 1]
    }
}