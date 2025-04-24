package leet.code.medium

import leet.code.Solution
import java.util.PriorityQueue

class P973KClosestPointsToOrigin : Solution {

    override fun test() {
        kClosest(
            arrayOf(
                intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)
            ), 2
        ).forEach { println(it.contentToString()) }
    }

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray>(compareBy { (x, y) -> x * x + y * y })
        for (p in points) pq.add(p)
        return Array(k) { pq.poll() }
    }
}