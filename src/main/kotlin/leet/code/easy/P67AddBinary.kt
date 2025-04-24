package leet.code.easy

import leet.code.Solution

class P67AddBinary : Solution {

    override fun test() {
        val a = "1010"
        val b = "1011"
        val res = addBinary(a, b)
        println(a)
        println(b)
        println(res)
        println(addBinary2(a, b))
    }

    // doesn't work for numbers > ULong
    fun addBinary2(a: String, b: String): String {
        var num1 = 0L
        var num2 = 0L
        var slider = 1L shl a.length - 1
        for (c in a) {
            if (c == '1') num1 = slider or num1
            slider = slider shr 1
        }
        slider = 1L shl b.length - 1
        for (c in b) {
            if (c == '1') num2 = slider or num2
            slider = slider shr 1
        }
        println("$num1 $num2")

        var sum = num1 + num2
        if (sum == 0L) return "0"

        val sb = StringBuilder()
        while (sum != 0L) {
            val rightMostBit = sum and 1
            sb.insert(0, rightMostBit)
            sum = sum shr 1
        }

        return sb.toString()
    }

    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()
        val max = if (a.length >= b.length) a else b
        val min = if (a.length < b.length) a else b
        val diff = max.length - min.length

        var carry = 0
        for (i in max.length - 1 downTo diff) {
            val (res, c) = add(max[i], min[i - diff], carry)
            sb.insert(0, res)
            carry = c
        }
        for (i in diff - 1 downTo 0) {
            val (res, c) = add(max[i], null, carry)
            sb.insert(0, res)
            carry = c
        }
        if (carry == 1) {
            sb.insert(0, 1)
        }

        return sb.toString()
    }

    private fun add(l: Char, r: Char?, carry: Int): Pair<Int, Int> {
        var res = carry
        var newCarry = 0
        if (l == '1') {
            res = if (res == 0) {
                1
            } else {
                newCarry = 1
                0
            }
        }
        if (r == '1') {
            res = if (res == 0) {
                1
            } else {
                newCarry = 1
                0
            }
        }

        return Pair(res, newCarry)
    }
}
