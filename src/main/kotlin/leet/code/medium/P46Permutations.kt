package leet.code.medium

import leet.code.Solution

class P46Permutations : Solution {

    override fun test() {
        println(permute(intArrayOf(1, 2, 3)))
    }

    private var res = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        permuteRec(nums, 0, ArrayList())
        return res
    }

    private fun permuteRec(nums: IntArray, used: Int, list: MutableList<Int>) {
        if (list.size == nums.size) {
            res.add(ArrayList(list))
            return
        }

        for (i in nums.indices) {
            if ((used or (1 shl i)) != used) {
                list.add(nums[i])
                permuteRec(nums, used or (1 shl i), list)
                list.remove(nums[i])
            }
        }
    }
}
