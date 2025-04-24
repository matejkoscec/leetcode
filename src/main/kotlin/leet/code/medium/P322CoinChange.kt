package leet.code.medium

import leet.code.Solution
import kotlin.math.min


class P322CoinChange : Solution {

    override fun test() {
//        println(coinChange(intArrayOf(186, 419, 83, 408), 6249))
        println(coinChange(intArrayOf(1, 2, 5), 11))
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val minCoins = IntArray(amount + 1) { amount + 1 }
        minCoins[0] = 0

        for (am in 1..amount) {
            for (coin in coins) {
                if (am - coin >= 0) {
                    minCoins[am] = min(minCoins[am], 1 + minCoins[am - coin])
                }
            }
        }

        return if (minCoins[amount] != amount + 1) minCoins[amount] else -1
    }
}