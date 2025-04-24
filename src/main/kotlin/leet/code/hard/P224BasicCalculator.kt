package leet.code.hard

import leet.code.Solution

class P224BasicCalculator : Solution {

    override fun test() {
        println(calculate("1 + 1 +(2 + 1)+1"))
    }

    fun calculate(s: String): Int {
        val stack = mutableListOf<Int>()

        var res = 0
        var number = 0
        var sign = 1
        for (c in s) {
            if (c.isDigit()) {
                number = 10 * number + (c - '0')
                continue
            }
            when (c) {
                '+' -> {
                    res += sign * number
                    number = 0
                    sign = 1
                }

                '-' -> {
                    res += sign * number
                    number = 0
                    sign = -1
                }

                '(' -> {
                    stack.add(res)
                    stack.add(sign)
                    res = 0
                    number = 0
                    sign = 1
                }

                ')' -> {
                    res += sign * number
                    number = 0
                    val topSign = stack.removeLast()
                    res *= topSign
                    val top = stack.removeLast()
                    res += top
                }
            }
        }

        res += sign * number

        return res
    }
}
