package leet.code.hard

import leet.code.Solution

class P4MedianOfTwoSortedArrays : Solution {

    override fun test() {
        println(findMedianSortedArrays(intArrayOf(1), intArrayOf()))
    }

    // O(log(m+n))
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        if (n == 0 && m == 0) {
            return 0.0
        }

        val max = if (n >= m) nums1 else nums2
        val min = if (n < m) nums1 else nums2
        val maxLen = maxOf(n, m)
        val minLen = minOf(n, m)
        val isOdd = (n + m) % 2 != 0

        val nums = IntArray(n + m)
        var numsSize = 0
        var i = 0
        var j = 0
        while (j < minLen) {
            if (i < maxLen && max[i] <= min[j]) {
                nums[numsSize++] = (max[i++])
            } else {
                nums[numsSize++] = (min[j++])
            }
            if (numsSize == (n + m) / 2 + 1) {
                return if (isOdd) {
                    nums[numsSize - 1].toDouble()
                } else {
                    (nums[numsSize - 1] + nums[numsSize - 2]) / 2.0
                }
            }
        }
        while (numsSize < (n + m) / 2 + 1) {
            nums[numsSize++] = (max[i++])
        }

        return if (isOdd) {
            nums[numsSize - 1].toDouble()
        } else {
            (nums[numsSize - 1] + nums[numsSize - 2]) / 2.0
        }
    }

    // O(m*n)
//    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//        val nums = ArrayList<Int>()
//        val n = nums1.size
//        val m = nums2.size
//        val max = if (n >= m) nums1 else nums2
//        val min = if (n < m) nums1 else nums2
//
//        var i = 0
//        var j = 0
//        while (j < minOf(n, m)) {
//            if (i < maxOf(n, m) && max[i] < min[j]) {
//                nums.add(max[i++])
//            } else {
//                nums.add(min[j++])
//            }
//        }
//        while (i < maxOf(n, m)) {
//            nums.add(max[i++])
//        }
//
//        if (nums.size % 2 != 0) {
//            return nums[nums.size / 2].toDouble()
//        }
//
//        return (nums[nums.size / 2 - 1] + nums[nums.size / 2]) / 2.0
//    }
}
