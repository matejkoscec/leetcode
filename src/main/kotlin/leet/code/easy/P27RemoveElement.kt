package leet.code.easy

import leet.code.Solution

class P27RemoveElement : Solution {

    override fun test() {
        TODO("Not yet implemented")
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0

        for (num in nums) {
            if (num != `val`) {
                nums[i++] = num
            }
        }

        return i
    }
}
