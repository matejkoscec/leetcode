package leet.code.easy

import leet.code.Solution

class P20ValidParentheses : Solution {

    override fun test() {
        println(isValid("(([]))"))
    }

    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        for (char in s) {
            if (char in "([{") {
                stack.add(char)
                continue
            }

            if (stack.isEmpty()) return false

            when (stack.removeLast()) {
                '(' -> if (char != ')') return false
                '[' -> if (char != ']') return false
                '{' -> if (char != '}') return false
            }
        }

        return stack.isEmpty()
    }
}
