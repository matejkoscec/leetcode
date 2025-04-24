package leet.code.medium

import leet.code.Solution
import java.util.PriorityQueue

class P33SearchInRotatedSortedArray : Solution {

    override fun test() {
        println(search(intArrayOf(), 0))
    }

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }

        var i = 0
        while (i < nums.size - 1 && nums[i] < nums[i + 1]) {
            i++
        }

        return when {
            i == nums.size - 1 -> binarySearch(nums, target, 0, nums.size - 1)
            target >= nums[0] -> binarySearch(nums, target, 0, i)
            else -> binarySearch(nums, target, i + 1, nums.size - 1)
        }
    }

    private fun binarySearch(nums: IntArray, target: Int, start: Int, end: Int): Int {
        var left = start
        var right = end

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

    fun searchFaster(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) {
                return mid
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }

        return -1
    }
}
