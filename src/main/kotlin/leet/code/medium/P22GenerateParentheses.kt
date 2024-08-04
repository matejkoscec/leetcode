package leet.code.medium

import leet.code.Solution

object P22GenerateParentheses : Solution {

    override fun test() {
        println(generateParenthesis(3))
    }

    fun generateParenthesis(n: Int): List<String> {
        val res = ArrayList<String>()
        trace(res, 0, 0, "", n)
        return res
    }

    private fun trace(res: MutableList<String>, left: Int, right: Int, s: String, n: Int) {
        if (s.length == n * 2) {
            res.add(s)
            return
        }
        if (left < n) {
            trace(res, left + 1, right, "$s(", n)
        }
        if (right < left) {
            trace(res, left, right + 1, "$s)", n)
        }
    }
}
