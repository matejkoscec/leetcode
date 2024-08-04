package leet.code.medium

import leet.code.Solution
import kotlin.math.min

object P155MinStack : Solution {

    override fun test() {
        val stack = MinStack()
        stack.push(1)
        stack.push(0)
        stack.pop()
        println(stack.top())
    }

    class MinStack {

        private val stack = mutableListOf<Pair<Int, Int>>()

        fun push(`val`: Int) {
            if (stack.isEmpty()) {
                stack.add(Pair(`val`, `val`))
            } else {
                val min = min(`val`, stack.last().second)
                stack.add(Pair(`val`, min))
            }
        }

        fun pop() {
            stack.removeLast()
        }

        fun top(): Int = stack[stack.size - 1].first

        fun getMin(): Int = stack[stack.size - 1].second
    }
}
