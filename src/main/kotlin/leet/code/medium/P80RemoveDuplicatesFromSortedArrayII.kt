package leet.code.medium

import leet.code.Solution

object P80RemoveDuplicatesFromSortedArrayII : Solution {

    override fun test() {
        val array = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        removeDuplicates(array)
        println(array.contentToString())
    }

    fun removeDuplicates(nums: IntArray): Int {
        var k = 0

        for (num in nums) {
            if (k == 0 || k == 1 || nums[k - 2] != num) {
                nums[k] = num
                k++
            }
        }

        return k
    }
}
