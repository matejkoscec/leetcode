package leet.code.medium

import leet.code.Solution

class P11ContainerWithMostWater : Solution {

    override fun test() {
        println(maxArea(intArrayOf(1, 2, 1)))
    }

    fun maxArea(height: IntArray): Int {
        var leftI = 0
        var rightI = height.size - 1
        var maxArea = 0

        while (leftI < rightI) {
            val l = height[leftI]
            val r = height[rightI]

            val currentArea = minOf(l, r) * (rightI - leftI)
            if (currentArea > maxArea) {
                maxArea = currentArea
            }
            if (l < r) {
                leftI++
            } else {
                rightI--
            }
        }

        return maxArea
    }
}
