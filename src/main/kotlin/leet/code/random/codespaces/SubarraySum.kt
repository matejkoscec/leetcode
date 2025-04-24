package leet.code.random.codespaces

import leet.code.Solution

class SubarraySum : Solution {

    override fun test() {
        println(subSum(listOf(3, 7, 5, 6, 2), 5))
    }

    fun subSum(arr: List<Int>, target: Int): List<Int> {
        val prefix = IntArray(arr.size + 1)
        val map = mutableMapOf(0 to -1)

        var sum = 0
        for (i in arr.indices) {
            sum += arr[i]
            prefix[i + 1] = sum
            map[sum] = i
        }

        for (i in prefix.indices.reversed()) {
            val index = map[prefix[i] - target] ?: continue
            return listOf(index + 1, i - 1)
        }

        return listOf(-1)
    }
}
