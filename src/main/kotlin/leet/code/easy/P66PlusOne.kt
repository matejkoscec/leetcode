package leet.code.easy

import leet.code.Solution

class P66PlusOne : Solution {

    override fun test() {
        val res = plusOne(intArrayOf(9, 9, 9))
        println(res.contentToString())
    }

    private fun plusOne(digits: IntArray): IntArray {
        for (i in (digits.size - 1) downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }

        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }
}
