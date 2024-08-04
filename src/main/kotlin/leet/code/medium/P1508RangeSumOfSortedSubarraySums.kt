package leet.code.medium

import leet.code.Solution

class P1508RangeSumOfSortedSubarraySums : Solution {

    override fun test() {
        println(rangeSum(IntArray(1000) { 100 }, 1000, 1, 500500))
    }

    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val arr = IntArray(n * (n + 1) / 2)

        var index = 0
        for (k in nums.indices) {
            var sum = 0
            for (i in k..<n) {
                sum += nums[i]
                arr[index++] = sum
            }
        }

        arr.sort()
        var sum = 0L
        for (i in left - 1..<right) {
            sum += arr[i]
        }

        return (sum % 1_000_000_007).toInt()
    }
}