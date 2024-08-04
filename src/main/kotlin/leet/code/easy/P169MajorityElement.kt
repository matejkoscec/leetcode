package leet.code.easy

import leet.code.Solution

object P169MajorityElement : Solution {

    override fun test() {
        println(majorityElement(intArrayOf(3, 2, 3)))
    }

    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }

        return map.maxBy { it.value }.key
    }
}