package leet.code.medium

import leet.code.Solution

class P128LongestConsecutiveSequence : Solution {

    override fun test() {
        println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }

    fun longestConsecutive(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            if (map.containsKey(num - 1)) {
                map[num - 1] = num
            }

            if (map.containsKey(num + 1)) {
                map[num] = num + 1
            } else {
                map[num] = Int.MIN_VALUE
            }
        }

        var max = 0
        for ((k, v) in map) {
            if (v != Int.MIN_VALUE) continue

            var len = 1
            var current = k - 1
            var next = map[current]
            while (next != null) {
                len++
                next = map[--current]
            }
            if (len > max) {
                max = len
            }
        }

        return max
    }
}
