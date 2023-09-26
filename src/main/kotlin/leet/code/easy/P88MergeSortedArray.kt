package leet.code.easy

import leet.code.Solution

class P88MergeSortedArray : Solution {

    override fun test() {
        var nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        var nums2 = intArrayOf(2, 5, 6)
        merge(nums1, 3, nums2, 3)
        println(nums1.contentToString())
        println(nums2.contentToString())
        nums1 = intArrayOf(4, 0, 0, 0, 0, 0)
        nums2 = intArrayOf(1, 2, 3, 5, 6)
        merge(nums1, 1, nums2, 5)
        println(nums1.contentToString())
        println(nums2.contentToString())
    }

    // Lazy solution
//    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
//        if (nums2.isEmpty() || n == 0) return
//
//        for (i in m until m + n) {
//            nums1[i] = nums2[i - m]
//        }
//        nums1.sort()
//    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
