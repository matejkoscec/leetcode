package leet.code.medium

import leet.code.Solution

class P416PartitionEqualSubsetSum : Solution {

    override fun test() {

    }

    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 == 1) return false

        val target = sum / 2
        val dp = BooleanArray(target + 1)
        dp[0] = true

        for (num in nums) {
            for (curr in dp.lastIndex downTo num) {
                if (dp[curr]) continue
                dp[curr] = dp[curr - num]
            }
        }

        return dp.last()
    }
}
