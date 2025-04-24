package leet.code.medium

import leet.code.Solution

class P310MinimumHeightTrees : Solution {

    override fun test() {

    }

    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (edges.isEmpty()) {
            return listOf(0)
        }

        val degrees = IntArray(n)
        val edgeMap = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edges) {
            degrees[a]++
            degrees[b]++
            edgeMap.getOrPut(a) { mutableListOf() }.add(b)
            edgeMap.getOrPut(b) { mutableListOf() }.add(a)
        }

        val queue = mutableListOf<Int>()
        for (i in degrees.indices) {
            if (degrees[i] == 1) {
                queue.add(i)
            }
        }
        var processed = 0
        while (n - processed > 2) {
            processed += queue.size
            for (i in queue.indices) {
                val node = queue.removeFirst()
                for (c in edgeMap[node]!!) {
                    degrees[c]--
                    if (degrees[c] == 1) {
                        queue.add(c)
                    }
                }
            }
        }

        return queue
    }
}
