package leet.code.medium

import leet.code.Solution

class P62UniquePaths : Solution {

    override fun test() {

    }

    fun uniquePaths(m: Int, n: Int): Int {
        val paths = Array(m) { IntArray (n) { 1 } }

        for (i in 1..<m) {
            for (j in 1..<n) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
            }
        }

        return paths.last().last()
    }
}
