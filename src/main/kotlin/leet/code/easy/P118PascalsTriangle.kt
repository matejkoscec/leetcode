package leet.code.easy

import leet.code.Solution

class P118PascalsTriangle : Solution {

    override fun test() {
        println(generate(5))
    }

    fun generate(numRows: Int): List<List<Int>> {
        val output = mutableListOf(listOf(1))

        for (i in 1..<numRows) {
            val prev = output[i - 1]
            output += List(i + 1) { j ->
                prev.getOrElse(j - 1) { 0 } + prev.getOrElse(j) { 0 }
            }
        }

        return output
    }

    fun gen(numRows: Int): List<List<Int>> {
        val one = listOf(1)
        return generateSequence(one) { one + it.zipWithNext(Int::plus) + one }
            .take(numRows)
            .toList()
    }
}
