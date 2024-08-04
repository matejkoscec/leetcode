package leet.code.easy

import leet.code.Solution

class P217ContainsDuplicate : Solution {

    override fun test() {
        println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Boolean>()

        for (num in nums) {
            if (map[num] == true) return true
            map[num] = true
        }

        return false
    }
}
