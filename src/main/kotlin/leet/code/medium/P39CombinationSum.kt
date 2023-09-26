package leet.code.medium

import leet.code.Solution

class P39CombinationSum : Solution {

    override fun test() {
        println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        trace(candidates, target, list, mutableListOf(), 0)
        return list
    }

    private fun trace(nums: IntArray, target: Int, list: MutableList<List<Int>>, prefix: MutableList<Int>, skip: Int) {
        if (target == 0) {
            list.add(ArrayList(prefix))
            return
        }
        if (skip >= nums.size || target < 0) {
            return
        }

        for (i in skip..<nums.size) {
            prefix.add(nums[i])
            trace(nums, target - nums[i], list, prefix, i)
            prefix.removeAt(prefix.size - 1)
        }
    }

    // First solution (extremely slow)
//    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
//        val list = mutableSetOf<List<Int>>()
//        trace(candidates, target, list, mutableListOf())
//        return list.toList()
//    }
//
//    private fun trace(candidates: IntArray, target: Int, list: MutableSet<List<Int>>, prefix: MutableList<Int>) {
//        for (num in candidates) {
//            prefix.add(num)
//            val sum = prefix.sum()
//            if (sum < target) {
//                trace(candidates, target, list, prefix)
//            } else if (sum == target) {
//                list.add(prefix.sorted())
//            }
//            prefix.remove(num)
//        }
//    }
}
