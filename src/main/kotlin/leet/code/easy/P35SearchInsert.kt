package leet.code.easy

import leet.code.Solution

object P35SearchInsert : Solution {

    override fun test() {
        val res = searchInsert(intArrayOf(1, 3, 5, 6), 5)
        println(res)
    }

    private fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var middle = right / 2

        while (left <= right) {
            if (nums[middle] == target) {
                return middle
            }
            if (nums[middle] < target) {
                left = middle + 1
            } else {
                right = middle - 1
            }

            middle = left + (right - left) / 2
        }

        return middle
    }
}
