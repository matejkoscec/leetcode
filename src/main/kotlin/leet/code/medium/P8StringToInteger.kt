package leet.code.medium

import leet.code.Solution

class P8StringToInteger : Solution {

    override fun test() {
        println(Int.MAX_VALUE)
        println(myAtoi(" "))
        println(Int.MAX_VALUE.toString() > "2147483648")
    }

    fun myAtoi(s: String): Int {
        val str = s.trim()

        if (str.isEmpty()) return 0

        var sign = 1
        var i = 0
        if (str[0] == '-') {
            sign = -1
            i++
        } else if (str[0] == '+') {
            i++
        }

        var res: Long = 0
        while (i < str.length) {
            val ch = str[i]
            if (ch < '0' || ch > '9') break

            res = res * 10 + (ch - '0')
            if (sign * res > Int.MAX_VALUE) return Int.MAX_VALUE
            if (sign * res < Int.MIN_VALUE) return Int.MIN_VALUE

            i++
        }

        return (sign * res).toInt()
    }
}
