package leet.code.medium

import leet.code.Solution
import kotlin.math.max

class P621TaskScheduler : Solution {

    override fun test() {

    }

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counter = IntArray(26)
        var max = 0
        var maxCount = 0
        for (task in tasks) {
            counter[task - 'A']++
            if (max == counter[task - 'A']) {
                maxCount++
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A']
                maxCount = 1
            }
        }

        val partCount = max - 1
        val partLength = n - (maxCount - 1)
        val emptySlots = partCount * partLength
        val availableTasks = tasks.size - max * maxCount
        val idles = max(0, emptySlots - availableTasks)

        return tasks.size + idles
    }
}
