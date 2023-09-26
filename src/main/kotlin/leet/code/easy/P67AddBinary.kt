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
