package leet.code.medium

import leet.code.Solution

object P150EvaluateReversePolishNotation : Solution {

    override fun test() {
        println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = mutableListOf<Int>()

        for (token in tokens) when (token) {
            "+" -> {
                stack.add(stack.removeLast() + stack.removeLast())
            }
            "-" -> {
                val right = stack.removeLast()
                val left = stack.removeLast()
                stack.add(left - right)
            }
            "*" -> {
                stack.add(stack.removeLast() * stack.removeLast())
            }
            "/" -> {
                val right = stack.removeLast()
                val left = stack.removeLast()
                stack.add(left / right)
            }
            else -> {
                stack.add(token.toInt())
            }
        }

        return stack.last()
    }
}
