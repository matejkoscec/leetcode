package leet.code.easy

import leet.code.Solution

class P1TwoSum : Solution {

    override fun test() {
        println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            map[target - nums[i]]?.let {
                return intArrayOf(it, i)
            }
            map[nums[i]] = i
        }

        return intArrayOf()
    }
}