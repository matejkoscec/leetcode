package leet.code.medium

import leet.code.Solution

class P15ThreeSum : Solution {

    override fun test() {
        println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
        println((-2).toString().hashCode())
        println((-101).toString().hashCode())
        println(listOf(1, 2, 3).hashCode())
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = HashSet<List<Int>>()
        nums.sort()

        var i = 0
        while (i < nums.size) {
            if (nums[i] > 0) {
                break
            }
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val num1 = nums[i]
                val num2 = nums[j]
                val num3 = nums[k]
                val sum = num1 + num2 + num3
                if (sum == 0) {
                    set.add(listOf(num1, num2, num3))
                    j++
                    k--
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            i++
        }

        return set.toList()
    }
}
