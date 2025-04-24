package leet.code.medium

import leet.code.Solution
import kotlin.math.max
import kotlin.math.min

class P11ContainerWithMostWater : Solution {

    override fun test() {
        println(maxArea(intArrayOf(1, 2, 1)))
    }

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var max = 0

        while (left < right) {
            max = max(max, min(height[left], height[right]) * (right - left))
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return max
    }
}
