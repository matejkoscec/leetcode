package leet.code.medium

import leet.code.Solution

class P53MaximumSubarray : Solution {

    override fun test() {
        println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    // Kadane's algorithm
    fun maxSubArray(nums: IntArray): Int {
        var maxEndingHere = 0
        var maxSoFar = Int.MIN_VALUE

        for (i in nums.indices) {
            maxEndingHere += nums[i]
            if (maxEndingHere < nums[i]) {
                maxEndingHere = nums[i]
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere
            }
        }

        return maxSoFar
    }
}
