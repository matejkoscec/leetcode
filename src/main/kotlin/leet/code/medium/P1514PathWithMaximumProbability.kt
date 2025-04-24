package leet.code.medium

import leet.code.Solution

class P1514PathWithMaximumProbability : Solution {

    override fun test() {
        println(
            maxProbability(
                n = 3,
                edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)),
                succProb = doubleArrayOf(0.5, 0.5, 0.2),
                start_node = 0,
                end_node = 2,
            )
        )
    }

    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val maxProb = DoubleArray(n)
        maxProb[start_node] = 1.0

        for (i in 0..<n - 1) {
            var updated = false
            for (j in edges.indices) {
                val u = edges[j][0]
                val v = edges[j][1]
                val prob = succProb[j]

                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob
                    updated = true
                }
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob
                    updated = true
                }
            }
            if (!updated) break
        }

        return maxProb[end_node]
    }
}