package leet.code.medium

import leet.code.Solution

class P50PowXN : Solution {

    override fun test() {
        println(myPow(2.0, -2))
    }

    // Binary exponentiation
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        val factor = when {
            n.isEven() -> 1.0
            n < 0 -> 1.0 / x
            else -> x
        }

        return factor * myPow(x * x, n / 2)
    }

    // Bonkers
    private fun Int.isEven(): Boolean = this and 1 == 0

    // Stack overflow error
//    fun myPow(x: Double, n: Int): Double {
//        return when {
//            x == 1.0 -> 1.0
//            n == 0 -> 1.0
//            n < 0 -> myPow(1 / x, -n)
//            n % 2 == 0 -> myPow(x * x, n / 2)
//            else -> x * myPow(x * x, (n - 1) / 2)
//        }
//    }
}
