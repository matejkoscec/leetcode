package leet.code.medium

import leet.code.Solution

class P8StringToInteger : Solution {

    override fun test() {
        println(Int.MAX_VALUE)
        println(myAtoi(" "))
        println(Int.MAX_VALUE.toString() > "2147483648")
    }

    fun myAtoi(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var i = 0
        while (i < s.length && s[i].isWhitespace()) {
            i++
        }
        if (i == s.length) {
            return 0
        }
        val factor = if (s[i] == '+') {
            i++
            1
        } else if (s[i] == '-') {
            i++
            -1
        } else 1

        val digits = StringBuilder()
        var leadingZero = true
        while (i < s.length && s[i].isDigit()) {
            if (s[i] == '0' && leadingZero) {
                i++
                continue
            }
            leadingZero = false
            digits.append(s[i++])
        }

        if (digits.isEmpty()) {
            return 0
        }
        val maxInt = Int.MAX_VALUE.toString()
        if (digits.length < maxInt.length) {
            return factor * digits.toString().toInt()
        }
        if (digits.length > maxInt.length || digits.toString() > maxInt) {
            return if (factor > 0) Int.MAX_VALUE else Int.MIN_VALUE
        }

        return factor * digits.toString().toInt()
    }
}
