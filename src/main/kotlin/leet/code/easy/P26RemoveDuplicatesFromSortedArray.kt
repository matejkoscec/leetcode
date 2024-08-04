package leet.code.easy

import leet.code.Solution

object P26RemoveDuplicatesFromSortedArray : Solution {

    override fun test() {
        TODO("Not yet implemented")
    }

    fun removeDuplicates(nums: IntArray): Int {
        var k = 1

        for (i in 1..<nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i]
            }
        }

        return k
    }
}
