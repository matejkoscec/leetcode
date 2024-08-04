package leet.code.medium

import leet.code.Solution
import kotlin.math.max

class P57InsertInterval : Solution {

    override fun test() {
        val insert = insert(
            arrayOf(
                intArrayOf(2, 4), intArrayOf(5, 7), intArrayOf(8, 10), intArrayOf(11, 13)
            ),
            intArrayOf(3, 6)
        )
        println(insert.joinToString { it.contentToString() })
    }

    /**
     * @see <img src="https://preview.redd.it/benefits-of-having-a-job-woo-moneyyyy-yippie-bad-parts-of-v0-dgezhrvzz4vb1.jpg?width=640&crop=smart&auto=webp&s=565fd167ff524428a54cf731b1b6e4aa5f100c7d"/>
     */
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)

        val output = mutableListOf<IntArray>()
        val left = newInterval[0]
        val right = newInterval[1]

        var mergedLeft = -1
        var inInterval = false
        for ((i, interval) in intervals.withIndex()) {
            if (mergedLeft == -1 && left <= interval[1]) {
                mergedLeft = if (left < interval[0]) left else interval[0]
                inInterval = true
            }
            if (mergedLeft != -1 && inInterval) {
                if (right < interval[1] && right == interval[0]) {
                    output.add(intArrayOf(mergedLeft, interval[1]))
                    inInterval = false
                    continue
                }
                if (right < interval[0]) {
                    output.add(intArrayOf(left, right))
                    output.add(interval)
                    inInterval = false
                    continue
                }

                val next = if (i == intervals.lastIndex) null else intervals[i + 1]
                if (next == null || right < next[0]) {
                    output.add(intArrayOf(mergedLeft, max(right, interval[1])))
                    inInterval = false
                    continue
                }
            }

            if (!inInterval) {
                output.add(interval)
            }
        }

        if (mergedLeft == -1) {
            output.add(newInterval)
        }

        return output.toTypedArray()
    }
}
