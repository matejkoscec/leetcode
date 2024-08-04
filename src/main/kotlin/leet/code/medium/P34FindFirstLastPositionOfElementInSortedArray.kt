package leet.code.medium

import leet.code.Solution

object P34FindFirstLastPositionOfElementInSortedArray : Solution {

    override fun test() {
        println(searchRange(intArrayOf(1), 1).contentToString())
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val i = binarySearch(nums, target)
        if (i == -1) {
            return intArrayOf(-1, -1)
        }

        var left = i
        var right = i
        while (left > 0 && nums[left - 1] == target) {
            left--
        }
        while (right < nums.size - 1 && nums[right + 1] == target) {
            right++
        }

        return intArrayOf(left, right)
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val num = nums[mid]

            if (num == target) {
                return mid
            }

            if (num < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return -1
    }
}
