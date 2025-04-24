package leet.code.hard

import leet.code.Solution
import java.util.*


class P1235MaximumProfitInJobScheduling : Solution {

    override fun test() {
//        println(
//            jobScheduling(
//                intArrayOf(1, 2, 3, 3),
//                intArrayOf(3, 4, 5, 6),
//                intArrayOf(50, 10, 40, 70),
//            )
//        )
        println(
            jobScheduling(
                intArrayOf(1, 2, 3, 4, 6),
                intArrayOf(3, 5, 10, 6, 9),
                intArrayOf(20, 20, 100, 70, 60),
            )
        )
        println(
            jobScheduling(
                intArrayOf(1, 1, 1),
                intArrayOf(2, 3, 4),
                intArrayOf(5, 6, 4),
            )
        )
    }

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs = startTime.indices.sortedBy { endTime[it] }

        val map = TreeMap<Int, Int>()
        map[0] = 0
        for (j in jobs) {
            val cur = map.floorEntry(startTime[j]).value + profit[j]
            if (cur > map.lastEntry().value) {
                map[endTime[j]] = cur
            }
        }

        return map.lastEntry().value
    }

    // Time limit exceeded
//    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
//        val jobsByStart = startTime.indices.sortedBy { startTime[it] }
//        val map = jobsByStart.associateWithTo(mutableMapOf()) { profit[it] }
//
//        var max = profit.max()
//
//        for (i in jobsByStart.indices) {
//            val job = jobsByStart[i]
//            val prevSum = map[job]!!
//
//            for (k in i - 1 downTo 0) {
//                val j = jobsByStart[k]
//                if (startTime[job] < endTime[j]) {
//                    continue
//                }
//                val localMax = max(map[job]!!, prevSum + map[j]!!)
//                map[job] = localMax
//                max = max(max, localMax)
//            }
//        }
//
//        return max
//    }
}
