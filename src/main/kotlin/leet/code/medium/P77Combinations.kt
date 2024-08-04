package leet.code.medium

import leet.code.Solution

object P77Combinations : Solution {

    override fun test() {
        println(combine(4, 2))
    }

    fun combine(n: Int, k: Int): List<List<Int>> {
        val combinations = mutableListOf<List<Int>>()
        track(combinations, n, k, 1, mutableListOf())
        return combinations
    }

    private fun track(list: MutableList<List<Int>>, n: Int, k: Int, start: Int, comb: MutableList<Int>) {
        if (comb.size == k) {
            list.add(comb.toList())
            return
        }

        for (i in start..n) {
            comb.add(i)
            track(list, n, k, i + 1, comb)
            comb.removeLast()
        }
    }
}
