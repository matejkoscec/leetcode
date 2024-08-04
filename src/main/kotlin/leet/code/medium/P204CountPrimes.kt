package leet.code.medium

import leet.code.Solution
import kotlin.math.sqrt

class P204CountPrimes : Solution {

    override fun test() {
        println(countPrimes(10))
    }

    fun countPrimes(n: Int): Int {
        if (n < 2) {
            return 0
        }

        return (0..<n).count(::isPrime)
    }

    private fun isPrime(n: Int): Boolean {
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                return false
            }
        }

        return true
    }
}
