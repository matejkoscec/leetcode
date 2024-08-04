package leet.code.medium

import leet.code.Solution

object P238ProductOfArrayExceptSelf : Solution {

    override fun test() {
        println(productExceptSelf(intArrayOf(1, 2, 3, 4)).contentToString())
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)

        ans[0] = 1
        for (i in 1..<nums.size) {
            ans[i] = ans[i - 1] * nums[i - 1]
        }

        var prod = 1
        for (i in nums.indices.reversed()) {
            ans[i] *= prod
            prod *= nums[i]
        }

        return ans
    }
}
