package leet.code.medium

import leet.code.Solution

class P75SortColors : Solution {

    override fun test() {
        val colors = intArrayOf(2, 0, 2, 1, 1, 0)
        sortColors(colors)
        println(colors.contentToString())
    }

    fun sortColors(nums: IntArray) {
        var left = 0
        var right = nums.lastIndex

        var i = 0
        while (i <= right) {
            val num = nums[i]
            if (num == 0) {
                nums[i] = nums[left]
                nums[left++] = 0
            } else if (num == 2) {
                nums[i] = nums[right]
                nums[right--] = 2
                i--
            }

            i++
        }
    }
}
