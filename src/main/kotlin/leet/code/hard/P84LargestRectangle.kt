package leet.code.hard

import leet.code.Solution
import kotlin.math.max

class P84LargestRectangle : Solution {

    override fun test() {
        println(largestRectangleArea2(intArrayOf(2, 1, 5, 6, 2, 3)))
//        println(largestRectangleArea(intArrayOf(1, 1, 1, 1, 2, 4, 2, 4)))
    }

    fun largestRectangleArea(height: IntArray): Int {
        if (height.isEmpty()) {
            return 0
        }

        val lessFromLeft = IntArray(height.size)
        val lessFromRight = IntArray(height.size)
        lessFromRight[height.lastIndex] = height.size
        lessFromLeft[0] = -1

        for (i in 1..<height.size) {
            var p = i - 1
            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p]
            }
            lessFromLeft[i] = p
        }

        for (i in height.lastIndex - 1 downTo 0) {
            var p = i + 1
            while (p < height.size && height[p] >= height[i]) {
                p = lessFromRight[p]
            }
            lessFromRight[i] = p
        }

        var maxArea = 0
        for (i in height.indices) {
            maxArea = max(maxArea, (height[i] * (lessFromRight[i] - lessFromLeft[i] - 1)))
        }

        return maxArea
    }

    fun largestRectangleArea2(heights: IntArray): Int {
        val next = mutableListOf<Int>()
        val prev = mutableListOf<Int>()
        val stack = ArrayDeque<Int>()

        val n = heights.size
        stack.add(n)

        for (i in n - 1 downTo 0) {
            while (stack.last() != n && heights[stack.last()] >= heights[i]) {
                stack.removeLast()
            }
            next.add(stack.last())
            stack.add(i)
        }

        stack.clear()
        stack.addLast(-1)

        for (i in 0..<n) {
            while (stack.last() != -1 && heights[stack.last()] >= heights[i]) {
                stack.removeLast()
            }
            prev.add(stack.last())
            stack.add(i)
        }

        var max = 0
        for (i in 0..<n) {
            max = max(max, heights[i] * (next[n - 1 - i] - prev[i] - 1))
        }

        return max
    }
}
