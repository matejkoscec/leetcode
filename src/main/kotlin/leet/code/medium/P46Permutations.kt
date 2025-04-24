package leet.code.medium

import leet.code.Solution

class P46Permutations : Solution {

    override fun test() {
        println(permute(intArrayOf(1, 2, 3)))
    }

    private var res = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val sub = mutableListOf<Int>()
        val used = BooleanArray(nums.size)

        fun trace() {
            if (sub.size == nums.size) {
                res.add(sub.toList())
                return
            }

            for (i in nums.indices) {
                if (used[i]) continue

                used[i] = true
                sub.add(nums[i])
                trace()
                sub.removeLast()
                used[i] = false
            }
        }

        trace()

        return res
    }
}
