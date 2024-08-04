package leet.code.medium

import leet.code.Solution

class P63UniquePaths : Solution {

    override fun test() {
        println(
            uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0),
                )
            )
        )
    }

    fun uniquePathsWithObstacles(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        val pathsMatrix = Array(n) { IntArray(m) }

        pathsMatrix[0][0] = if (grid[0][0] == 1) 0 else 1

        for (i in 1..<m) {
            pathsMatrix[0][i] = if (grid[0][i] == 1) 0 else pathsMatrix[0][i - 1]
        }

        for (i in 1..<n) {
            pathsMatrix[i][0] = if (grid[i][0] == 1) 0 else pathsMatrix[i - 1][0]
        }

        for (i in 1..<n) {
            for (j in 1..<m) {
                pathsMatrix[i][j] = if (grid[i][j] == 1) 0 else pathsMatrix[i][j - 1] + pathsMatrix[i - 1][j]
            }
        }

        return pathsMatrix[n - 1][m - 1]
    }

    // Too slow
//    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
//        val n = obstacleGrid.size - 1
//        val m = obstacleGrid[0].size - 1
//        var num = 0
//
//        fun trace(row: Int, col: Int) {
//            if (obstacleGrid[row][col] == 1) {
//                return
//            }
//
//            if (row == n && col == m) {
//                num++
//                return
//            }
//
//            if (row < n) {
//                trace(row + 1, col)
//            }
//            if (col < m) {
//                trace(row, col + 1)
//            }
//        }
//
//        trace(0, 0)
//
//        return num
//    }
}
