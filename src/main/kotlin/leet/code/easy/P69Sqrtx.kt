package leet.code.easy

import leet.code.Solution

object P69Sqrtx : Solution {

    override fun test() {
        println(mySqrt(4))
        println(mySqrt(1))
    }

    fun mySqrt(x: Int): Int {
        var left = 1
        var right = x

        while (left <= right) {
            val middle = (right + left) / 2
            if (middle < x / middle) {
                left = middle + 1
            } else if (middle > x / middle) {
                right = middle - 1
            } else {
                return middle
            }
        }

        return right
    }
}
