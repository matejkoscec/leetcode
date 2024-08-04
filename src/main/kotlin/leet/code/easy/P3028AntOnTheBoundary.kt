package leet.code.easy

import leet.code.Solution

class P3028AntOnTheBoundary : Solution {

    override fun test() {
        println(returnToBoundaryCount(intArrayOf(2, 3, -5)))
    }

    fun returnToBoundaryCount(nums: IntArray): Int {
        var count = 0
        var current = 0
        for (num in nums) {
            current += num
            if (current == 0) {
                count++
            }
        }

        return count
    }
}