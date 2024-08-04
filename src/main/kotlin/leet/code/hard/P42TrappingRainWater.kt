package leet.code.hard

import leet.code.Solution


object P42TrappingRainWater : Solution {

    override fun test() {
        println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    }

    fun trap(height: IntArray): Int {
        var water = 0

        var p1 = 0
        var p2 = height.size - 1
        var h1 = height[0]
        var h2 = height.last()
        while (p1 < p2) {
            if (h1 < h2) {
                p1++
                if (h1 < height[p1]) {
                    h1 = height[p1]
                } else {
                    water += h1 - height[p1]
                }
            } else {
                p2--
                if (h2 < height[p2]) {
                    h2 = height[p2]
                } else {
                    water += h2 - height[p2]
                }
            }
        }
        return water
    }
}
