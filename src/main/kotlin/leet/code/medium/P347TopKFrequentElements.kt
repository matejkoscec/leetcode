package leet.code.medium

import leet.code.Solution

object P347TopKFrequentElements : Solution {

    override fun test() {
        println(topKFrequent(intArrayOf(5, 3, 1, 1, 1, 3, 73, 1), 2).contentToString())
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return nums.asIterable()
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { (_, v) -> v }
            .take(k)
            .map { it.first }
            .toIntArray()
    }
}
