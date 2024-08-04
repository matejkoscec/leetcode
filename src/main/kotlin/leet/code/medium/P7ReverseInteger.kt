package leet.code.medium

import leet.code.Solution

object P7ReverseInteger : Solution {

    override fun test() {
        println(reverse(123))
        println(reverse(2147483647))
    }

    // Fastest
    fun reverse(x: Int): Int {
        var num = x
        var res = 0L
        while (num != 0) {
            res = res * 10 + num % 10
            num /= 10
        }

        if (res < Int.MIN_VALUE || res > Int.MAX_VALUE) {
            return 0
        }

        return res.toInt()
    }

    // A bit faster
//    fun reverse(x: Int): Int {
//        var digits = (log10(x.absoluteValue.toDouble()) + 1).toInt()
//
//        var num = x
//        var res = 0L
//        while (num != 0) {
//            val digit = num % 10
//            res += digit * 10.0.pow((digits - 1).toDouble()).toLong()
//            num /= 10
//            digits--
//        }
//
//        if (res < Int.MIN_VALUE || res > Int.MAX_VALUE) {
//            return 0
//        }
//
//        return res.toInt()
//    }

    // First solution
//    fun reverse(x: Int): Int {
//        var digits = 0
//        var num = x
//        while (num != 0) {
//            num /= 10
//            digits++
//        }
//
//        num = x
//        var res = 0L
//        while (num != 0) {
//            val digit = num % 10
//            res += digit * 10.0.pow((digits - 1).toDouble()).toLong()
//            num /= 10
//            digits--
//        }
//
//        if (res < Int.MIN_VALUE || res > Int.MAX_VALUE) {
//            return 0
//        }
//
//        return res.toInt()
//    }
}
