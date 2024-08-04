package leet.code.medium

import leet.code.Solution
import kotlin.math.max

object P45JumpGame2 : Solution {

    override fun test() {
        println(jump(intArrayOf(0)))
    }

    fun jump(nums: IntArray): Int {
        for (i in 1..<nums.size) {
            nums[i] = max(nums[i] + i, nums[i - 1])
        }

        var index = 0
        var res = 0
        while (index < nums.size - 1) {
            res++
            index = nums[index]
        }

        return res
    }

    // Works but time limit exceeded
//    private var min: Int = Int.MAX_VALUE
//
//    private val list = mutableListOf<Int>()
//
//    private fun jumpRec(nums: IntArray, index: Int, jumps: Int) {
//        if (index > nums.size - 1) {
//            return
//        }
//        if (index == nums.size - 1) {
//            println("jumps: $jumps")
//            if (jumps < min) {
//                min = jumps
//            }
//            return
//        }
//
//        for (i in nums[index] downTo 1) {
//            list.add(i)
//            println(list)
//            jumpRec(nums, index + i, jumps + 1)
//            list.remove(i)
//        }
//    }
}
