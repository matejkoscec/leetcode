package leet.code.medium

import leet.code.Solution

class P200NumberOfIslands : Solution {

    override fun test() {
        println(
            numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                )
            )
        )
        println(
            numIslands(
                arrayOf(
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '1', '1'),
                )
            )
        )
        println(
            numIslands(
                arrayOf(
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '0', '1', '0', '1'),
                    charArrayOf('1', '1', '1', '0', '1'),
                )
            )
        )
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var num = 0
        for ((i, row) in grid.withIndex()) {
            for ((j, c) in row.withIndex()) {
                if (c == '0') continue
                trace(grid, i, j)
                num++
            }
        }

        return num
    }

    fun trace(grid: Array<CharArray>, row: Int, col: Int) {
        if (grid[row][col] != '1') return

        grid[row][col] = '0'

        if (row - 1 >= 0) {
            trace(grid, row - 1, col)
        }
        if (row + 1 < grid.size) {
            trace(grid, row + 1, col)
        }
        if (col - 1 >= 0) {
            trace(grid, row, col - 1)
        }
        if (col + 1 < grid[0].size) {
            trace(grid, row, col + 1)
        }
    }
}
