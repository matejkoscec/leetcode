package leet.code.hard

import leet.code.Solution
import kotlin.math.max

object P84LargestRectangle : Solution {

    override fun test() {
        println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
//        println(largestRectangleArea(intArrayOf(1, 1, 1, 1, 2, 4, 2, 4)))
    }

    fun largestRectangleArea(heights: IntArray): Int {
        val next = mutableListOf<Int>()
        val prev = mutableListOf<Int>()
        val stack = ArrayDeque<Int>()

        val n = heights.size
        stack.addLast(n)

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
