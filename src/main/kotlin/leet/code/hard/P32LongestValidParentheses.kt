package leet.code.hard

import leet.code.Solution

object P32LongestValidParentheses : Solution {

    override fun test() {
        println(longestValidParentheses(")()())()()("))
    }

    // Brute force solution (slow)
    fun longestValidParentheses(s: String): Int {
        if (s.isBlank()) {
            return 0
        }

        var max = 0
        var currentMax = 0
        var prevValid = false
        var i = 0
        while (i < s.length) {
            val (valid, value) = isValid(s.substring(i..<s.length))
            if (!valid) {
                i++
                prevValid = false
                if (currentMax > max) {
                    max = currentMax
                }
                currentMax = 0
                continue
            }
            i += value
            currentMax += value
            if (!prevValid) {
                prevValid = true
            }
        }
        if (currentMax > max) {
            max = currentMax
        }

        return max
    }

    private fun isValid(substring: String): Pair<Boolean, Int> {
        if (substring.isEmpty() || substring[0] == ')') {
            return Pair(false, 0)
        }

        val stack = ArrayDeque<Char>()
        var len = 0
        for (char in substring) {
            len++
            if (char == '(') {
                stack.addFirst('(')
            } else {
                stack.removeFirst()
                if (stack.isEmpty()) {
                    break
                }
            }
        }

        return Pair(stack.isEmpty(), len)
    }
}
