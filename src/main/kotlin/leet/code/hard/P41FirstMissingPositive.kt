package leet.code.hard

import leet.code.Solution

class P41FirstMissingPositive : Solution {

    override fun test() {
        println(firstMissingPositive(intArrayOf(1, 2, 0)))
        println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
        println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
    }

    // Cycle sort
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        val n = nums.size
        while (i < n) {
            if (nums[i] in 1..n && nums[nums[i] - 1] != nums[i]) {
                nums[i] = nums[nums[i] - 1].also { nums[nums[i] - 1] = nums[i] }
            } else {
                i++
            }
        }

        i = 0
        while (i < n) {
            if (nums[i] != i + 1) {
                return i + 1
            }
            i++
        }

        return n + 1
    }

    // First solution
//    fun firstMissingPositive(nums: IntArray): Int {
//        val map = mutableMapOf<Int, Int?>(0 to 1)
//        for (num in nums) {
//            if (num > 0) {
//                if (map.containsKey(num - 1)) {
//                    map[num - 1] = num
//                }
//                map[num] = if (map.containsKey(num + 1)) num + 1 else null
//            }
//        }
//
//        var num = 0
//        var next = map[num]
//        while (next in map) {
//            next = map[next]
//            num++
//        }
//
//        return num + 1
//    }
}
