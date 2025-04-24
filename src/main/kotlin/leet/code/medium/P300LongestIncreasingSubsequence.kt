package leet.code.medium

import leet.code.Solution

class P300LongestIncreasingSubsequence : Solution {

    override fun test() {

    }

    fun lengthOfLIS(nums: IntArray): Int {
        val res = mutableListOf<Int>()

        fun binSearch(num: Int): Int {
            var left = 0
            var right = res.lastIndex
            while (left <= right) {
                val mid = (left + right) / 2
                if (res[mid] == num) return mid

                if (res[mid] > num) right = mid - 1
                else left = mid + 1
            }
            return left
        }

        for (num in nums) {
            if (res.isEmpty() || res.last() < num) {
                res.add(num)
                continue
            }
            val index = binSearch(num)
            res[index] = num
        }

        return res.size
    }
}
