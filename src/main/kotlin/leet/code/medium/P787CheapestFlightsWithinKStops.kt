package leet.code.medium

import leet.code.Solution
import java.util.*


class P787CheapestFlightsWithinKStops : Solution {

    override fun test() {

    }

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val map = mutableMapOf<Int, MutableList<IntArray>>()
        for (f in flights) {
            map.putIfAbsent(f[0], mutableListOf())
            map[f[0]]!!.add(intArrayOf(f[1], f[2]))
        }

        val q = PriorityQueue<IntArray>(compareBy { it[0] })
        q.offer(intArrayOf(0, src, k + 1))
        while (!q.isEmpty()) {
            val (cost, curr, stop) = q.poll()
            if (curr == dst) return cost
            if (stop > 0) {
                if (!map.containsKey(curr)) continue
                for (next in map[curr]!!) {
                    q.add(intArrayOf(cost + next[1], next[0], stop - 1))
                }
            }
        }

        return -1
    }
}
