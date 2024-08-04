package leet.code.medium

import leet.code.Solution
import java.lang.StringBuilder

object P12IntegerToRoman : Solution {

    override fun test() {
        println(intToRoman(58))
    }

    private val map = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    fun intToRoman(num: Int): String {
        val sb = StringBuilder()

        var number = num
        var i = 1
        while (number > 0) {
            var digit = number % 10

            when {
                digit == 9 -> {
                    sb.insert(0, map[9 * i])
                }
                digit > 5 -> {
                    while (digit-- > 5) {
                        sb.insert(0, map[1 * i])
                    }
                    sb.insert(0, map[5 * i])
                }
                digit == 5 -> {
                    sb.insert(0, map[5 * i])
                }
                digit == 4 -> {
                    sb.insert(0, map[4 * i])
                }
                else -> {
                    while (digit-- > 0) {
                        sb.insert(0, map[1 * i])
                    }
                }
            }

            number /= 10
            i *= 10
        }

        return sb.toString()
    }
}
