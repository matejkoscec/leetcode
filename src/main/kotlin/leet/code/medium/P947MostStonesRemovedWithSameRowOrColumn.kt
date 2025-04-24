package leet.code.medium

import leet.code.Solution

class P947MostStonesRemovedWithSameRowOrColumn : Solution {

    override fun test() {
        println(
            removeStones(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(2, 2),
                )
            )
        )
    }

    fun removeStones(stones: Array<IntArray>): Int {
        var group = 0
        val visited = BooleanArray(stones.size)

        for (i in stones.indices) {
            if (visited[i]) continue
            group += 1
            trace(stones, visited, i)
        }

        return stones.size - group
    }

    private fun trace(stones: Array<IntArray>, visited: BooleanArray, index: Int) {
        visited[index] = true
        for (i in stones.indices) {
            if (visited[i]) continue
            if (stones[index][0] != stones[i][0] && stones[index][1] != stones[i][1]) continue
            trace(stones, visited, i)
        }
    }
}