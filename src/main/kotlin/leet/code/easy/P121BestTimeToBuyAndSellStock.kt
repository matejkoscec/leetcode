package leet.code.easy

import leet.code.Solution

class P121BestTimeToBuyAndSellStock : Solution {

    override fun test() {
        println(intArrayOf(7, 1, 5, 3, 6, 4))
    }

    fun maxProfit(prices: IntArray): Int {
        var maxDiff = 0
        var min = Int.MAX_VALUE
        for (p in prices) {
            if (p < min) min = p
            val diff = p - min
            if (diff > maxDiff) maxDiff = diff
        }

        return maxDiff
    }
}